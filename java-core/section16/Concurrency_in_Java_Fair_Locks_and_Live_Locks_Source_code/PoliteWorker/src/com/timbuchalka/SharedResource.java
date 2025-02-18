package com.timbuchalka.Concurrency_in_Java_Fair_Locks_and_Live_Locks_Source_code.PoliteWorker.src.com.timbuchalka;

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
