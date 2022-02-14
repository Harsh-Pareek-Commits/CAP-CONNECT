package com.cap.capconnect.security;

public class JwtResponse {
String token;
long id;
public JwtResponse(String token, long id) {
	super();
	this.token = token;
	this.id = id;
}
public JwtResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
@Override
public String toString() {
	return "JwtResponse [token=" + token + ", id=" + id + "]";
}

}
