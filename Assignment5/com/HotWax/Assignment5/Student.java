import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
    private String firstName;
    private Date dateOfBirth;
    private Address address;
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Student(String firstName, String dateOfBirth, String city, String state, int pinCode, String country) {
        this.firstName = firstName;

        try {
            this.dateOfBirth = simpleDateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        address = new Address(city,state,pinCode,country);
    }
    public String getFirstName() {
        return this.firstName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
}
