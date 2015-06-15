package com.bubanking.img;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="image.processor")
public class IPProperties {
	

	/***
	 * worker for processing image
	 */
	private int numberOfIPWorkers;
	

	public int getNumberOfIPWorkers() {
		return numberOfIPWorkers;
	}
	
	public void setNumberOfIPWorkers(int numberOfIPWorkers) {
		this.numberOfIPWorkers = numberOfIPWorkers;
	}



	@Override
	public String toString() {
		return "IPProperties [numberOfIPWorkers=" + numberOfIPWorkers + "]";
	}
	
	
	
	
	
	
	
}
