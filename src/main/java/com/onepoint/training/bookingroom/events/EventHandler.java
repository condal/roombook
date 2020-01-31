package com.onepoint.training.bookingroom.events;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import eventstore.akka.tcp.ConnectionActor;
import eventstore.core.ReadEvent;

import eventstore.core.ReadResult;
import eventstore.j.ReadEventBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventHandler {



    @Scheduled(fixedDelay = 5000)
    public void handle(){
        final ActorSystem system = ActorSystem.create();
        //final ActorRef connection = system.actorOf(ConnectionActor.getProps());
        final ActorRef readResult = system.actorOf(Props.create(ReadResult.class));

        final ReadEvent readEvent = new ReadEventBuilder("stream")
                .resolveLinkTos(false)
                .requireMaster(true)
                .build();
        readResult.tell(readEvent, readResult);

        if(readResult!=null)
        log.info(readResult.toString());
    }

}
