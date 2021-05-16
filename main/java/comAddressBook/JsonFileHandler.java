package comAddressBook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonFileHandler {
    private String fileName;
    public JsonFileHandler(String bookName) {
        this.fileName = bookName+".json";
    }

    public void jsonWriter(List<Contacts> contactsList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(contactsList,writer);
            System.out.println("Wrote to json!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
