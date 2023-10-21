package Views;

import javax.swing.JFileChooser;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DataEntry extends DataDiagram {

    public DataEntry() {
        super();
    }
 public static String readJSONFileAsString(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);
            Gson gson = new Gson();
            return gson.toJson(jsonElement);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
     public static String chooseFilePathForSave() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String directoryPath = selectedDirectory.getAbsolutePath();
            return directoryPath;
        }
        return null;
    }
    public static String chooseFilePathForLoad() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null;
    }
}
