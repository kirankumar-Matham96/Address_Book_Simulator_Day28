package comAddressBook;

import java.util.ArrayList;

public class AddressBook {
    ArrayList<Contacts> contactsList = new ArrayList<>();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();

    /**
     * method to add new contact from the console
     */
    public void addContact() {
        Contacts contacts = new Contacts();
        System.out.println("Please enter first name");
        contacts.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter last name");
        contacts.setLastName(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter address");
        contacts.setAddress(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter city");
        contacts.setCity(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter state");
        contacts.setState(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter email");
        contacts.setEmail(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter zip");
        contacts.setZip(scannerForAddressBook.scannerProvider().nextInt());
        System.out.println("Please enter phone number");
        contacts.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());
        contactsList.add(contacts);
    }

    /**
     * edits the contact details of selected name
     */
    public void editDetails() {
        Contacts contacts = new Contacts();
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Select option:" + "\n" + "1.first name" + "\n" + "2.last name" +
                    "\n" + "3.address" + "\n" + "4.city" + "\n" +
                    "5.state" + "\n" + "6.email" + "\n" + "7.zip" +
                    "\n" + "8.phone number" + "\n" + "9.exit");
            switch (scannerForAddressBook.scannerProvider().nextInt()) {
                case 1:
                    System.out.println("Enter new first name to change: ");
                    contacts.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                case 2:
                    System.out.println("Enter new last name to change: ");
                    contacts.setLastName(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                case 3:
                    System.out.println("Enter new address to change: ");
                    contacts.setAddress(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                case 4:
                    System.out.println("Enter new city to change: ");
                    contacts.setCity(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                case 5:
                    System.out.println("Enter new state to change: ");
                    contacts.setState(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                case 6:
                    System.out.println("Enter new email to change: ");
                    contacts.setEmail(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                case 7:
                    System.out.println("Enter new zip to change: ");
                    contacts.setZip(scannerForAddressBook.scannerProvider().nextInt());
                    break;
                case 8:
                    System.out.println("Enter new phone number to change: ");
                    contacts.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());
                    break;
                default:
                    System.out.println("Thank you!");
                    isExit = true;
            }
        }
    }
}
