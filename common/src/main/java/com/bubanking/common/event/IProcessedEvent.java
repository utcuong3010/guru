package com.bubanking.common.event;

import java.io.Serializable;

public class IProcessedEvent implements Serializable {

	private String txId;
	private String destination;
	
	public IProcessedEvent(String txId, String destination) {
		this.txId = txId;
		this.destination = destination;
	}
	
	/**
	 * @return the txId
	 */
	public String getTxId() {
		return txId;
	}

	/**
	 * @param txId the txId to set
	 */
	public void setTxId(String txId) {
		this.txId = txId;
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
	
}
