package Generator.Helper;

import Generator.Models.Daigram;
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
        
        for (var classe : diagram.getListClass()) {
            uml.append(
                "class " + classe.getClassName() +" {\n");
            for (var feild : classe.attributes){
                uml.append(" "+ feild +"\n");
            }
            for (var method : classe.methods) {
                uml.append(" "+ method +"\n");
            }
            uml.append(" } \n");
        }
        for (var relationship : diagram.getListRelationships()) {
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
        SourceStringReader reader = new SourceStringReader(plantUmlText);

        // Write the generated image to the specified output file
        File outputFile = new File(outputImagePath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        reader.generateImage(outputStream, null);
        outputStream.close();

        System.out.println("UML image generated at: " + outputFile.getAbsolutePath());
    }
}
