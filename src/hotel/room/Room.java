package hotel.room;

import hotel.room.state.Availability;

import java.util.Objects;

public class Room {

    private int number;
    private String type;
    private String description;
    private Availability isAvailable;
    private int capacity;
    private double price;

    public Room(int number, String type, String description, String isAvailable, int capacity, double price) {
        this.number = number;
        this.type = type;
        this.description = description;
        this.isAvailable = Availability.valueOf(isAvailable);
        this.capacity = capacity;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Availability getAvailable() {
        return isAvailable;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return getNumber() == room.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return "=-=-=-=-=-= ROOM "+getNumber()+" =-=-=-=-=-= \n"+
                "Type: " + getType()+"\n"+
                "Capacity: " + getCapacity() + "\n"+
                "Price: R$"+getPrice()+"\n"+
                "Is available: " + getAvailable()+"\n"+
                "Description: " + getDescription();
    }
}
