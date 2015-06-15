package com.bubanking.img;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;

import com.bubanking.common.event.IProcessedEvent;
import com.bubanking.common.repository.IPTransactionRepository;
import com.bubanking.img.actor.IPMasterActor;
import com.bubanking.img.handle.UpdateIPTxHandler;

@Component
public class IPService implements InitializingBean,DisposableBean {
	
	final Logger log = Logger.getLogger(IPService.class);
	
	@Autowired
	private IPProperties conf;
	
	private ActorRef masterActor;
	private ActorSystem actorSystem;
	
	
	@Autowired
	private IPProperties ipProperties;
	
	@Autowired
	private IPTransactionRepository ipTransactionRepository;

	
	public void afterPropertiesSet() throws Exception {
		log.info("Initializing image processor service");
		
		actorSystem = ActorSystem.create("IPService");
		masterActor = actorSystem.actorOf(Props.create(IPMasterActor.class,ipProperties));
		
		//add some handlers
		actorSystem.eventStream().subscribe(actorSystem.actorOf(Props.create(UpdateIPTxHandler.class, ipTransactionRepository)), IProcessedEvent.class);
		
		log.info("Initialized image processor service");
	}
	
	public void destroy() throws Exception {
		log.info("Destroying image processor service");
		masterActor.tell(PoisonPill.getInstance(),null);
		Thread.sleep(1000);
		actorSystem.shutdown();
		
		
		log.info("Destroyed image processor service");
	}
	
	
	public void handleMessage(Object msg) {
		
		masterActor.tell(msg, null);
			
		
	}
}
