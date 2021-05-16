package comAddressBook;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ContactsFileIOService {

    /**
     * Writes to a json file
     */
    public void writeToJson(List<Contacts> contactsList,String bookName){
        JsonFileHandler jsonFileHandler = new JsonFileHandler(bookName);
        jsonFileHandler.jsonWriter(contactsList);
    }

    /**
     * writes to a CSV file
     * @param contactsList
     */
    public void writeToCSVFile(List<Contacts> contactsList,String bookName) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CSVFileHandler csvFileHandler = new CSVFileHandler(bookName);
        csvFileHandler.csvWriter(contactsList);
    }

    /**
     * writes to a text file
     * @param contactsList
     */
    public void writeToNormalFile(List<Contacts> contactsList, String bookName) {
        StringBuffer contactBuffer = new StringBuffer();
        contactsList.forEach(contacts -> {
            String contact = contacts.toString().concat("\n");
            contactBuffer.append(contact);
        });
        try {
            Files.write(Paths.get(bookName+".txt"), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData(String bookName) {
        try {
            Files.lines(new File(bookName+".txt").toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
