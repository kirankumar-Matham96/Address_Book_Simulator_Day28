package comAddressBook;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSimulator {
    Map<String, AddressBook> booksMap = new HashMap<>();
    ScannerForAddressBook scannerForAddressBook = initializeScanner();
    static AddressBookSimulator addressBookSimulator = new AddressBookSimulator();

    public static void main(String[] args) {
        ScannerForAddressBook scannerForAddressBook = initializeScanner();

        System.out.println("Welcome to address book simulator!");

        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by city/state" +
                                               "\n4.Exit");
            int option = scannerForAddressBook.scannerProvider().nextInt();
            switch(option) {
                case 1:
                    addressBookSimulator.addBook();
                    break;
                case 2:
                    addressBookSimulator.accessBook();
                    break;
                case 3:
                    addressBookSimulator.searchContactByCityOrState();
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    scannerForAddressBook.scannerProvider().close();//closing scanner
            }
        }
    }

    /**
     * add new Book
     */
    public void addBook(){
        System.out.println("Enter the name of new book");
        String bookName = scannerForAddressBook.scannerProvider().nextLine();
        if(addressBookSimulator.booksMap.containsKey(bookName)){
            System.out.println("Book already exists!");
        } else {
            addressBookSimulator.booksMap.put(bookName, new AddressBook());
        }
    }

    /**
     * Access existing Book
     */
    public void accessBook(){
        System.out.println("Enter the name of the book to access it");
        Object bookName1 = scannerForAddressBook.scannerProvider().nextLine();
        if(addressBookSimulator.booksMap.containsKey(bookName1)) {
            AddressBook addressBook = addressBookSimulator.booksMap.get(bookName1);
            addressBook.accessAddressBook();
            System.out.println("sorted contacts: "+addressBookSimulator.booksMap.toString());
        }
    }

    /**
     * Search contact by city/state
     */
    public void searchContactByCityOrState(){
        System.out.println("Enter the city/state name to search contact");
        String placeName = scannerForAddressBook.scannerProvider().nextLine();
        addressBookSimulator.booksMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getContactsList().stream()
                    .filter(contact -> contact.getCity().equals(placeName) ||
                            contact.getState().equals(placeName))
                    .findFirst().orElse(null));
        });
    }

    /**
     * initializes scanner class
     */
    public static ScannerForAddressBook initializeScanner(){
        ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
        return scannerForAddressBook;
    }
}
