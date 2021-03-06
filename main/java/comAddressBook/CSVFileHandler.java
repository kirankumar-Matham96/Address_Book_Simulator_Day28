package comAddressBook;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVFileHandler {
    private static String FILE_NAME;

    /**
     * when a new address book created, a new file should be created as well.
     * Also should select the correct file for the operations like editing or adding new contact.
     * constructor will achieve these things.
     */
    public CSVFileHandler(String file_name) {
        this.FILE_NAME = (file_name+".csv");
    }

    /**
     * writes data to csv file
     * @param contactsList
     * @throws IOException
     * @throws CsvRequiredFieldEmptyException
     * @throws CsvDataTypeMismatchException
     */
    public void csvWriter(List<Contacts> contactsList) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        Writer writer = Files.newBufferedWriter(Paths.get(FILE_NAME));
        StatefulBeanToCsv<Contacts> statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(',')
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build();
        System.out.println("in CSVHandler: "+contactsList);
        statefulBeanToCsv.write(contactsList);
        writer.close();
    }
}
