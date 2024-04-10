package hotel.guest;

import java.time.LocalDate;
import java.util.Objects;

public class Guest {

    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String ITR;
    private String numberPhone;
    private String identificationCard;
    private String password;

    public Guest(String name, String surname, LocalDate dateOfBirth,  String ITR, String numberPhone, String identificationCard, String password) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.ITR = ITR;
        this.numberPhone = numberPhone;
        this.identificationCard = identificationCard;
        this.password = password;
    }

    public Guest(int id, String name, String surname, LocalDate dateOfBirth, String ITR, String numberPhone, String identificationCard, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.ITR = ITR;
        this.numberPhone = numberPhone;
        this.identificationCard = identificationCard;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getITR() {
        return ITR;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;
        return Objects.equals(getITR(), guest.getITR());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getITR());
    }

    @Override
    public String toString() {
        return "=============================== \n" +
                "Guest "+getName()+" "+getSurname()+
                "\nDate Of Birth: "+getDateOfBirth()+
                "\nITR: "+getITR()+
                "\nIdentification: " + getIdentificationCard() +
                "\nNumber phone: " + getNumberPhone();
    }
}
