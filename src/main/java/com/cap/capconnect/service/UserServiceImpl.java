package com.cap.capconnect.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.capconnect.entity.User;
import com.cap.capconnect.exception.UserNotFoundException;
import com.cap.capconnect.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService {
	 Logger log = LoggerFactory.getLogger(QueryServiceImpl.class);
	@Autowired
	  IUserRepository userRepository;

	  //add
	  @Override
		public  User addUser(User user) throws UserNotFoundException  {
			Optional<User> opt = null;
			try {
				opt = userRepository.findById(user.getUser_id());
				if (opt.isPresent()) {
					throw new UserNotFoundException("User name already exists");}
				else
					return userRepository.save(user);
			} catch (Exception e) {
				throw new UserNotFoundException("User cannot be added");
			}
		}


		@Override
		public User deleteUser(long user_id) throws UserNotFoundException {
			try {
				Optional<User> opt = userRepository.findById(user_id);
				if (opt.isPresent()) {
					userRepository.deleteById(user_id);
					return opt.get();

				} else {
					throw new UserNotFoundException("User not found in delete");
				}

			} catch (Exception e) {

				throw new UserNotFoundException("User not found in delete");

			}
		}
		//update
				@Override
				public User updateUser(User user) throws UserNotFoundException {
					Optional<User> opt = null;
					try {
						opt = userRepository.findById(user.getUser_id());
						if (opt.isPresent()) {

							userRepository.save(user);
						} else {
							throw new UserNotFoundException("User details not found");
						}
					} catch (Exception e) {
						
						throw new UserNotFoundException("User cannot be updated");
					}
					return opt.get();
			}

				//view
				
				@Override
				public List<User> viewUser() {

					List<User> userList=null;
					try {

						userList = userRepository.findAll();

					} catch (Exception e) {

						log.error("View user Exception:", e);
					}

					return userList;
				}
				
		//view by id
				@Override
				public User viewUserById(long user_id) throws UserNotFoundException {
					
					User user = null;
					try {
						Optional<User> opt = userRepository.findById(user_id);
						if (opt.isPresent()) {
							user = opt.get();
						} else {
							throw new UserNotFoundException("User id not found in view query by id");
						}
					} catch (Exception e) {

						throw new UserNotFoundException("User id not found in view query by id");
					}
					return user;
				}
				

}



