package com.bubanking.img.actor;

import org.apache.log4j.Logger;

import akka.actor.UntypedActor;

import com.bubanking.common.cmd.IProcessingCmd;
import com.bubanking.common.event.IProcessedEvent;
import com.bubanking.img.IPProperties;

public class IProcessingActor extends UntypedActor{
	
	private final Logger log = Logger.getLogger(IProcessingActor.class);

	private final IPProperties properties;
	
	
	public IProcessingActor(IPProperties properties) {
		this.properties = properties;
	}
	
	@Override
	public void onReceive(Object msg) throws Exception {
		
		if(msg instanceof IProcessingCmd) {
		
			IProcessingCmd cmd = (IProcessingCmd)msg;
			//TODO: please draw the text in source image
			
			//publish event to system actor
			String destination = "testing";

			getContext().system().eventStream().publish(new IProcessedEvent(cmd.getTxId(),destination));
			
		} else {
			log.info("No handle for the message:"  + msg);
		}
	
	}
	
	

}
