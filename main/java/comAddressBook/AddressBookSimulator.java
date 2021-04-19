package comAddressBook;

public class AddressBookSimulator {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Simulator program!");
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
        addressBook.editDetails();
    }
}
