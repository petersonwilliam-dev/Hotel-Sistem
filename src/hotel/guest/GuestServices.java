package hotel.guest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuestServices{

    public void createGuest(String name, String surname, LocalDate dateOfBirth, String ITR, String numberPhone, String identificationCard, String password) throws Exception{
        if (ageIsValid(dateOfBirth)) {
            if (ITRIsValid(ITR) && numberPhoneIsValid(numberPhone) && identificationCardIsValid(identificationCard)) {
                Guest guest = new Guest(name, surname, dateOfBirth, ITR, numberPhone, identificationCard, password);
                new GuestDAO().createGuest(guest);
            } else {
                throw new RuntimeException("SOME DATA MAY BE WRONG");
            }
        } else {
            throw new RuntimeException("YOU NEED TO BE OF LEGAL AGE");
        }
    }

    public List<Guest> getAllGuests() throws SQLException {

        List<Guest> listGuest = new ArrayList<>();

        try (ResultSet resultSet = new GuestDAO().AllGuests()) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                LocalDate dateOfBirth = resultSet.getDate(4).toLocalDate();
                String ITR = resultSet.getString(5);
                String numberPhone = resultSet.getString(6);
                String identificationCard = resultSet.getString(7);
                String password = resultSet.getString(8);

                listGuest.add(new Guest(id, name, surname, dateOfBirth, ITR, numberPhone, identificationCard, password));
            }
            return listGuest;
        }
    }

    public Guest getGuest(String ITR, String password) throws Exception{
        ResultSet resultSet = new GuestDAO().getGuestByITR(ITR);
        if (resultSet.next()) {
            if (password.equals(resultSet.getString(8))) {
                return new Guest(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4).toLocalDate(), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
            } else {
                throw new RuntimeException("INCORRECT PASSWORD!");
            }
        } else {
            throw new RuntimeException("GUEST NOT FOUND!");
        }
    }

    public void editGuest(Guest guest) throws SQLException {
        new GuestDAO().editGuest(guest);
    }

    public void deleteGuest(int id) throws SQLException{
        new GuestDAO().deleteGuest(id);
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
