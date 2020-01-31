package com.onepoint.training.bookingroom.infos;

import java.util.UUID;

public class InventoryItemDeactivated {

    public UUID id;
    public int who;

    public InventoryItemDeactivated(UUID id, int who, String reason){
        this.id = id;
        this.who = who;
    }

}

/*
public class InventoryItemDeactivated_v2 {

    public UUID id;
    public int who;
    public String reason;

    public InventoryItemDeactivated_v2(UUID id, int who, String reason){
        this.id = id;
        this.who = who;
        this.reason = reason;
    }

}
*/