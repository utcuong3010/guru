package com.bubanking.common.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="ip_transaction")
public class IPTransaction {
	
	@Id
	private String id;
	private String name;
	private IPStatus status;
	private String source;
	private String destination;
	private Date createdDate = new Date();
	private Date completedDate;
	private User who;
	

	public IPTransaction(IPStatus status, User who) {
		this.status = status;
		this.who = who;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the status
	 */
	public IPStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(IPStatus status) {
		this.status = status;
	}


	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}


	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}


	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}


	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}


	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * @return the completedDate
	 */
	public Date getCompletedDate() {
		return completedDate;
	}


	/**
	 * @param completedDate the completedDate to set
	 */
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}


	/**
	 * @return the who
	 */
	public User getWho() {
		return who;
	}


	/**
	 * @param who the who to set
	 */
	public void setWho(User who) {
		this.who = who;
	}	
	
	/***
	 * 
	 * @return
	 */
	public static IPTransaction create(String name, String source, User who) {
		IPTransaction tx = new IPTransaction(IPStatus.PENDING, who);
		tx.setName(name);
		tx.setSource(source);
		tx.setCreatedDate(new Date());
		return tx;
	}


	
	
}
