package com.onepoint.training.bookingroom.service;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import eventstore.core.EsException;
import eventstore.core.WriteEventsCompleted;

public class WriteResult extends AbstractActor {

    final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(WriteEventsCompleted.class, m -> {
            log.info("range: {}, position: {}", m.numbersRange(), m.position());
            context().system().terminate();
        }).match(Status.Failure.class, f -> {
            final EsException exception = (EsException) f.cause();
            log.error(exception, exception.toString());
        }).build();
    }

}
