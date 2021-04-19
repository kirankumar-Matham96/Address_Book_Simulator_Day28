package comAddressBook;

import java.util.ArrayList;

public class AddressBook {
    ArrayList<Contacts> contactsList = new ArrayList<>();;

    //main method
    public void addContact()
    {
        Contacts contacts = new Contacts();
        contacts.setFirstName("Kiran");
        contacts.setLastName("Kumar");
        contacts.setAddress("Near my home");
        contacts.setCity("My city");
        contacts.setState("My state");
        contacts.setPhoneNumber("+91 8688332960");
        contacts.setZip(102658);
        contacts.setEmail("mymail@gmail.com");
        AddressBook addressBook = new AddressBook();
        addressBook.contactsList.add(contacts);
        System.out.println(addressBook.contactsList);
    }
}
