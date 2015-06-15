package com.bubanking.common.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="destination_data")
public class DestinationData extends SourceData{
	
	
	
	@Field(value="file_location")
	private String fileLocation;

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	
	
	
	
	

}
