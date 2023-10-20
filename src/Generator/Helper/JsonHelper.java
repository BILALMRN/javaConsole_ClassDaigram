package Generator.Helper;

import com.google.gson.Gson;
import Models.Diagrams;

public class JsonHelper{
    public static void saveUmlDiagramsAsJson(Diagrams diagrams, String outputImagePath){
        Gson gson = new Gson();
        String json = gson.toJson(diagrams);
        System.out.println(json);
    }

    public static Diagrams getUmlDiagramsFromJson(String jsonString){
        Gson gson = new Gson();
        Diagrams diagrams = gson.fromJson(jsonString, Diagrams.class);
        return diagrams;
    }
}
