package Generator.Helper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import Models.Diagrams;

public class JsonHelper{
    public static void saveUmlDiagramsAsJson(Diagrams diagrams, String outputJsonPath) throws IOException{
        Gson gson = new Gson();
        String json = gson.toJson(diagrams);
        System.out.println(json);

        var crunchifyFile = new FileWriter(outputJsonPath+ File.separator + diagrams.getNameProject() +".json");
        crunchifyFile.write(json);
        System.out.println(outputJsonPath+ File.separator + diagrams.getNameProject() +".json");
        crunchifyFile.flush();
        crunchifyFile.close();

    }

    public static Diagrams getUmlDiagramsFromJson(String jsonString){
        Gson gson = new Gson();
        Diagrams diagrams = gson.fromJson(jsonString, Diagrams.class);
        return diagrams;
    }
}
