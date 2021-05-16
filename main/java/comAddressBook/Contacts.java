package comAddressBook;


import com.opencsv.bean.CsvBindByPosition;

/**
 * simploe POJO for address book
 */
public class Contacts {
    @CsvBindByPosition(position = 0)
    private String firstName;
    @CsvBindByPosition(position = 1)
    private String lastName;
    @CsvBindByPosition(position = 2)
    private String address;
    @CsvBindByPosition(position = 3)
    private String city;
    @CsvBindByPosition(position = 4)
    private String state;
    @CsvBindByPosition(position = 5)
    private String email;
    @CsvBindByPosition(position = 6)
    private int zip;
    @CsvBindByPosition(position = 7)
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return "Contact{" + "\n" + "FIRST_NAME = " + firstName + "\n"+ "LAST_NAME = " + lastName + "\n" + "ADDRESS = " + address + "\n"+ "CITY = " + city + "\n"+
                "STATE = " + state + "\n" + "EMAIL = " + email + "\n" +
                "ZIP = " + zip + "\n" + "PHONE_NUMBER = " + phoneNumber + "\n" + '}';
    }
}
