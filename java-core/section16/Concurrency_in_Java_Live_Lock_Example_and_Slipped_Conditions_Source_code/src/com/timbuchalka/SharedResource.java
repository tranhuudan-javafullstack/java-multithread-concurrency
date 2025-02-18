package com.timbuchalka.Concurrency_in_Java_Live_Lock_Example_and_Slipped_Conditions_Source_code.src.com.timbuchalka;

/**
 * Created by timbuchalka on 2/08/2016.
 */
public class SharedResource {

    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
