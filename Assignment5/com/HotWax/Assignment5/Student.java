import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String dateOfBirth;

    Student(String firstName, String dateOfBirth) {
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
}
