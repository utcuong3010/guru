package com.bubanking.img.actor;

import org.apache.log4j.Logger;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;

import com.bubanking.common.cmd.IProcessingCmd;
import com.bubanking.common.util.JsonUtils;
import com.bubanking.img.IPProperties;


public class IPMasterActor extends UntypedActor {
	
	final Logger log = Logger.getLogger(IPMasterActor.class);
	
	//delivery job to workers
	private ActorRef router = null;	
	
	private final IPProperties properties; 	
	
	public IPMasterActor(IPProperties properties) {
		
		this.properties = properties;
	}
	
	
	@Override
	public void preStart() throws Exception {

		System.err.println(properties);
		router = getContext().actorOf(Props.create(IProcessingActor.class, properties)
				.withRouter(new RoundRobinRouter(1)));

	}

	@Override
	public void onReceive(Object msg) throws Exception {
		
		if(msg instanceof IProcessingCmd) {
			
			router.tell(msg, ActorRef.noSender());
			
		} else {
			throw new Exception("No handle for this message :" +JsonUtils.toJson(msg));
		}
		
	}
	
	

}
