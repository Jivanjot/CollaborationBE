package com.collaboration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
//@SequenceGenerator(name="myfriendidseq",sequenceName="friendidseq")
@Table(name="c_friend")
public class Friend {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myfriendidseq")
	private int friendId;
	private String loginName;
	private String friendLoginName;
	private String status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFriendLoginName() {
		return friendLoginName;
	}
	public void setFriendLoginName(String friendLoginName) {
		this.friendLoginName = friendLoginName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
