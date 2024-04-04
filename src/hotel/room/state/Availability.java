package hotel.room.state;

public enum Availability {
    AVAILABLE(true),
    UNAVAILABLE(false);

    private boolean isAvailable;

    Availability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
