package hotel.room.state;

public enum Availability {

    AVAILABLE(true),
    UNAVAILABLE(false);

    private boolean available;

    Availability(boolean availability) {
        this.available = availability;
    }

    public boolean isAvailable() {
        return available;
    }
}
