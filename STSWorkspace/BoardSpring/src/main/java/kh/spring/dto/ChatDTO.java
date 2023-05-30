package kh.spring.dto;

import java.sql.Timestamp;

public class ChatDTO {
	private String sender;
	private String message;
	private Timestamp send_date;
	
	public ChatDTO() {
		super();
	}
	public ChatDTO(String sender, String message, Timestamp send_date) {
		super();
		this.sender = sender;
		this.message = message;
		this.send_date = send_date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getSend_date() {
		return send_date;
	}
	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}
	
	
}
