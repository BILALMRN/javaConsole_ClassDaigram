package Generator.Helper;

import Generator.Models.Daigram;
import Generator.Models.Relationship;
import net.sourceforge.plantuml.SourceStringReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import Generator.Models.Classe;

public class GenerateUML {
    private static String generateUmlString(Daigram diagram) {
        StringBuilder uml = new StringBuilder();

        // @startuml
        // 1- add relation

        // Object <|-- ArrayList
        // 2- add feild
        // Object : equals()
        // ArrayList : Object[] elementData
        // ArrayList : size()

        // @enduml


        uml.append("@startuml\n");
        
        for (Classe classe : diagram.getListClass()) {
            uml.append(
                "class " + classe.getClassName() +" {\n");
            for (String feild : classe.attributes){
                uml.append(" "+ feild +"\n");
            }
            for (String method : classe.methods) {
                uml.append(" "+ method +"\n");
            }
            uml.append(" } \n");
        }
        for (Relationship relationship : diagram.getListRelationships()) {
            uml.append(
                relationship.getParentClass()        +" "+ 
            relationship.getChildMultiplicit()       +" "+
            relationship.getRelationshipType()       + " " +
            relationship.getParentMultiplicit()      +" "+
             relationship.getChildClass()
             +" \n"
             );
        }

        uml.append("@enduml");
        return uml.toString();
    }

    public static void generateUmlImage(Daigram diagram, String outputImagePath) throws IOException {
        // Create a PlantUML source reader
        String plantUmlText = generateUmlString(diagram);
        // add save file



        ///
        // Create a SourceStringReader with the PlantUML text
        SourceStringReader reader = new SourceStringReader(plantUmlText);

        // Create a FileOutputStream for the output image
        File outputFile = new File(outputImagePath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        try {
            // Generate the image and write it to the output stream
            reader.outputImage(outputStream);
        }
         finally {
            // Close the output stream
            outputStream.close();
        }

        //System.out.println("UML image generated at: " + outputFile.getAbsolutePath());
    }
}
