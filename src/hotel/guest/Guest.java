package hotel.guest;

import java.time.LocalDate;

public class Guest {

    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String ITR;
    private String numberPhone;
    private String identificationCard;

    public Guest(String name, String surname, LocalDate dateOfBirth,  String ITR, String numberPhone, String identificationCard) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.ITR = ITR;
        this.numberPhone = numberPhone;
        this.identificationCard = identificationCard;
    }

    public Guest(int id, String name, String surname, LocalDate dateOfBirth, String ITR, String numberPhone, String identificationCard) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.ITR = ITR;
        this.numberPhone = numberPhone;
        this.identificationCard = identificationCard;
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

}
