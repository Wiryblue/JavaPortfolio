package Concurrency.PoliteWorkers;

public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {// you want synchronized when changing data
        this.owner = owner;
    }
}
