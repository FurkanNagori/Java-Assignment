import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String state;
    private int pinCode;
    private String country;

    Address(String city, String state, int pinCode, String country) {
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public int getPinCode() {
        return this.pinCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getState() {
        return this.state;
    }
}
