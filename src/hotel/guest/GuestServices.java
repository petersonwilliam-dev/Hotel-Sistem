package hotel.guest;

import java.time.LocalDate;

public class GuestServices{

    public void createGuest(String name, String surname, LocalDate dateOfBirth, String ITR, String numberPhone, String identificationCard) throws Exception{
        if (ageIsValid(dateOfBirth)) {
            if (ITRIsValid(ITR) && numberPhoneIsValid(numberPhone) && identificationCardIsValid(identificationCard)) {
                Guest guest = new Guest(name, surname, dateOfBirth, ITR, numberPhone, identificationCard);
                new GuestDAO().createGuest(guest);
            } else {
                throw new RuntimeException("SOME DATA MAY BE WRONG");
            }
        } else {
            throw new RuntimeException("YOU NEED TO BE OF LEGAL AGE");
        }
    }

    private boolean ageIsValid(LocalDate dateOfBirth) {
        LocalDate dataMaxAllowed = LocalDate.now().minusYears(18);
        if (dateOfBirth.isEqual(dataMaxAllowed) || dateOfBirth.isBefore(dataMaxAllowed)) return true;
        return false;
    }

    private boolean ITRIsValid(String ITR) {
        if (ITR.matches("[0-9]+")) return true;
        return false;
    }

    private boolean numberPhoneIsValid(String numberPhone) {
        if (numberPhone.trim().length() == 11 && numberPhone.matches("[0-9]+")) return true;
        return false;
    }

    private boolean identificationCardIsValid(String identificationCard) {
        if (identificationCard.matches("[0-9]+")) return true;
        return false;
    }
}
