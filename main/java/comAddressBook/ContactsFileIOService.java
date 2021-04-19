package comAddressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ContactsFileIOService {
    public static String ADDRESS_BOOK_FILE_NAME = "Contacts.txt";
    public static String ADDRESS_BOOK_CSV_FILE = "ContactsCSV.csv";

    /**
     * writes to a CSV file
     */
    public void writeToCSVFile(List<Contacts> contactsList){
        StringBuffer contactBuffer = new StringBuffer();
        StringBuffer detailsBuffer = new StringBuffer();
        contactsList.forEach(contacts -> {
            detailsBuffer.append("Contact: {");
            detailsBuffer.append(contacts.getFirstName().concat(","));
            detailsBuffer.append(contacts.getLastName().concat(","));
            detailsBuffer.append(contacts.getAddress().concat(","));
            detailsBuffer.append(contacts.getCity().concat(","));
            detailsBuffer.append(contacts.getState().concat(","));
            detailsBuffer.append(contacts.getEmail().concat(","));
            detailsBuffer.append(contacts.getPhoneNumber().concat("}\n"));
        });
        contactBuffer.append(detailsBuffer);
        try {
            Files.write(Paths.get(ADDRESS_BOOK_CSV_FILE), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * writes to a text file
     * @param contactsList
     */
    public void writeToFile(List<Contacts> contactsList) {
        StringBuffer contactBuffer = new StringBuffer();
        contactsList.forEach(contacts -> {
            String contact = contacts.toString().concat("\n");
            contactBuffer.append(contact);
        });
        try {
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
