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
            // this text in same (1) line
            uml.append(
                        relationship.getParentClass()        
                +" \""+ relationship.getChildMultiplicit()   +"\" "+
                        relationship.getRelationshipType()     
                +" \""+ relationship.getParentMultiplicit()  +"\" "+
                        relationship.getChildClass()         +" \n"
             );
        }

        uml.append("@enduml");
        return uml.toString();
    }

    public static void generateUmlImage(Daigram diagram, String outputDirectory) throws IOException {
        String plantUmlText = generateUmlString(diagram);
        SourceStringReader reader = new SourceStringReader(plantUmlText);

        String outputPath = outputDirectory + File.separator + "uml_image_" + diagram.getDiagramsName() + ".png"; // Change the file format as needed
        File outputFile = new File(outputPath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        try {
            reader.outputImage(outputStream);
            System.out.println("UML image generated at: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error generating UML image: " + e.getMessage());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.err.println("Error closing output stream: " + e.getMessage());
                }
            }
        }

        
    }
}
