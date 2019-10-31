package com.developer.machete.model;

public class UserQuery {
	private Long id;
	private String usrquery;
	private String ip;
	private Long timestamp;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsrquery() {
		return usrquery;
	}

	public void setUsrquery(String usrquery) {
		this.usrquery = usrquery;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
