package ar.com.vic.test.util;

import java.util.Date;

import ar.com.vic.test.webAPIRest.model.Movie;

public class ResponseObject {
	private String status;
	private String statusMessage;
	private Date serverTime;
	private Iterable<Movie> data;
	
	public ResponseObject(String status, String statusMessage, Iterable<Movie> data) {
		super();
		this.status = status;
		this.statusMessage = statusMessage;
		this.data = data;
		this.serverTime = new Date();
		
		}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Date getServerTime() {
		return serverTime;
	}
	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}
	public Iterable<Movie> getData() {
		return data;
	}
	public void setData(Iterable<Movie> iterable) {
		this.data = iterable;
	}

}
