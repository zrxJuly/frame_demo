package com.zrxjuly.validate;

import java.util.Arrays;

public class User {
	private String username;
	private String password;
	private String[] hobby;
	private String vcode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	@Override
	public String toString() {
		return "User [username="
				+ username
				+ ", password="
				+ password
				+ ", hobby="
				+ Arrays.toString(hobby)
				+ ", vcode="
				+ vcode
				+ "]";
	}

}
