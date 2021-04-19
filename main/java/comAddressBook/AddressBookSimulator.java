package comAddressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSimulator {
    Map<String, AddressBook> booksMap = new HashMap<>();
    Map<String, List<List<Contacts>>> cityPersonMap = new HashMap<>();
    Map<String, List<List<Contacts>>> statePersonMap = new HashMap<>();
    ScannerForAddressBook scannerForAddressBook = initializeScanner();
    static AddressBookSimulator addressBookSimulator = new AddressBookSimulator();

    public static void main(String[] args) {
        ScannerForAddressBook scannerForAddressBook = initializeScanner();

        System.out.println("Welcome to address book simulator!");

        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by city/state" +
                                               "\n4.Show the contacts by city\n5.Show the contacts by state" +
                                               "\n6.Find number of contacts in a city/state\n7.Exit");
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
                case 4:
                    addressBookSimulator.showContactsByCity();
                    break;
                case 5:
                    addressBookSimulator.showContactByState();
                    break;
                case 6:
                    addressBookSimulator.countContactsByCityOrState();
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
     * Show the contacts by city
     */
    public void showContactsByCity(){
        System.out.println("Enter the city name to search contacts");
        String city = scannerForAddressBook.scannerProvider().nextLine();
        List<List<Contacts>> listOfCityContactsList = new ArrayList<>();
        List<Contacts> cityContactList;
        for(Map.Entry<String, AddressBook> entry : addressBookSimulator.booksMap.entrySet()) {
            cityContactList = entry.getValue().getContactsList().stream()
                    .filter(contact ->
                            contact.getCity().equals(city))
                    .collect(Collectors.toList());
            listOfCityContactsList.add(cityContactList);
        }
        addressBookSimulator.cityPersonMap.put(city,listOfCityContactsList);
        System.out.println(addressBookSimulator.cityPersonMap);
    }

    /**
     * Show the contacts by state
     */
    public void showContactByState(){
        System.out.println("Enter the state name to search contacts");
        String state = scannerForAddressBook.scannerProvider().nextLine();
        List<List<Contacts>> listOfStateContactsList = new ArrayList<>();
        List<Contacts> stateContactList;
        for (Map.Entry<String, AddressBook> entry : addressBookSimulator.booksMap.entrySet()) {
            stateContactList = entry.getValue().getContactsList().stream()
                    .filter(contact ->
                            contact.getState().equals(state))
                    .collect(Collectors.toList());
            listOfStateContactsList.add(stateContactList);
        }
        addressBookSimulator.statePersonMap.put(state,listOfStateContactsList);
        System.out.println(addressBookSimulator.statePersonMap);
    }

    /**
     * Find number of contacts in a city/state
     */
    public void countContactsByCityOrState(){
        System.out.println("Enter the city/state name to search number of contacts");
        String placeName2 = scannerForAddressBook.scannerProvider().nextLine();
        addressBookSimulator.booksMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println("Contacts in a city/state: " +
                    entry.getValue()
                            .getContactsList().stream()
                            .filter(contact -> contact.getCity().equals(placeName2) ||
                                    contact.getState().equals(placeName2))
                            .count());
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
