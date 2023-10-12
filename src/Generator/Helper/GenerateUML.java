package Generator.Helper;

import net.sourceforge.plantuml.SourceStringReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import Models.Classe;
import Models.Daigram;
import Models.Relationship;

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

    public static void generateUmlImage(Daigram diagram, String outputPath) throws IOException {
        String plantUmlText = generateUmlString(diagram);
        SourceStringReader reader = new SourceStringReader(plantUmlText);

        File outputFile = new File(outputPath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        try {
            reader.outputImage(outputStream);
            System.out.println("UML image generated at: " + outputFile.getAbsolutePath());
        }
         finally {
            // Close the output stream
            outputStream.close();
        }

        
    }
}
