package com.hzsun.demotest.dto.userinfo.extenddto;

import com.hzsun.demotest.dto.userinfo.UserpaywayDTO;

public class ExtendUserPayWayDTO extends UserpaywayDTO {
	private static final long serialVersionUID = 1L;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
