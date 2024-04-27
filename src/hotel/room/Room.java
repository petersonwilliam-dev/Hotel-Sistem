package hotel.room;
import java.util.Objects;

public class Room {

    private int number;
    private String type;
    private String description;
    private int capacity;
    private double dailyValue;

    public Room(int number, String type, String description, int capacity, double price) {
        this.number = number;
        this.type = type;
        this.description = description;
        this.capacity = capacity;
        this.dailyValue = price;
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

    public int getCapacity() {
        return capacity;
    }

    public double getDailyValue() {
        return dailyValue;
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
        return "\n=-=-=-=-=-= ROOM "+getNumber()+" =-=-=-=-=-= \n"+
                "Type: " + getType()+"\n"+
                "Capacity: " + getCapacity() + "\n"+
                "Price: R$"+getDailyValue()+"\n"+
                "Description: " + getDescription();
    }
}
