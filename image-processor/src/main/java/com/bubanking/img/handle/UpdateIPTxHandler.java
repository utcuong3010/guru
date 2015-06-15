package com.bubanking.img.handle;

import java.util.Date;

import org.apache.log4j.Logger;

import akka.actor.UntypedActor;

import com.bubanking.common.domain.IPStatus;
import com.bubanking.common.domain.IPTransaction;
import com.bubanking.common.event.IProcessedEvent;
import com.bubanking.common.repository.IPTransactionRepository;


public class UpdateIPTxHandler extends UntypedActor {
	
	private final Logger log = Logger.getLogger(UpdateIPTxHandler.class); 
	
	private final IPTransactionRepository ipTransactionRepository;
	
	public UpdateIPTxHandler(IPTransactionRepository repository) {
		
		this.ipTransactionRepository = repository;
	}
	
	@Override
	public void onReceive(Object event) throws Exception {
		
		if(event instanceof IProcessedEvent) {
			IProcessedEvent processedEvent = (IProcessedEvent)event;
			
			IPTransaction ipTx = ipTransactionRepository.findOne(processedEvent.getTxId());
			///set info and update
			ipTx.setDestination(processedEvent.getDestination());
			ipTx.setStatus(IPStatus.SUCCEED);
			ipTx.setCompletedDate(new Date());
			
			ipTransactionRepository.save(ipTx);
		
		} else {			
			log.info("No handler for event:" + event);
		}
	}

}
