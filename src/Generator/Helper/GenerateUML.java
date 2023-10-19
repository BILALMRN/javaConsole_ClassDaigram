package Generator.Helper;

import net.sourceforge.plantuml.SourceStringReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import Models.Classe;
import Models.Diagram;
import Models.Relationship;

public class GenerateUML {
    private static String generateUmlString(Diagram diagram) {
        StringBuilder uml = new StringBuilder();

        // @startuml
        // 1- add relation

        // Object <|-- ArrayList
        // 2- add feild
        // Object : equals()
        // ArrayList : Object[] elementData
        // ArrayList : size()

        // @enduml

        if (diagram.getListClass().size() < 1) return "";

        uml.append("@startuml\n");
        
        for (Classe classe : diagram.getListClass()) {
            uml.append(
                "Class " + classe.getClassName() +" { \n");
            for (String feild : classe.attributes){
                uml.append(" "+ feild +" \n");
            }
            for (String method : classe.methods) {
                uml.append(" "+ method +" \n");
            }
            uml.append(" } \n");
        }
        for (Relationship relationship : diagram.getListRelationships()) {
            // this text in same (1) line
            uml.append(
                        relationship.getParentClass()        
                +" \""+ relationship.getChildMultiplicit()   +"\" "+
                        relationship.getRelationshipType().getSymbol()     
                +" \""+ relationship.getParentMultiplicit()  +"\" "+
                        relationship.getChildClass()         +" \n"
             );
        }

        uml.append("@enduml");
        return uml.toString();
    }

    public static void generateUmlImage(Diagram diagram, String path) throws IOException {
        String plantUmlText = generateUmlString(diagram);//generation the style image and contain
        if(plantUmlText.isEmpty()) {
            System.out.println(" daigram is empty ");
            return;
        }
        String fullPathImage = createFolderIfNotExist(path) + File.separator + diagram.getDiagramsName()+ ".png";
        System.out.println(fullPathImage);
        generateImage(fullPathImage, plantUmlText);
              
    }

    private static String createFolderIfNotExist(String folderPath){
        File folder = new File(folderPath);
        if(!folder.exists()){
            return  folder.mkdir() ? folder.getAbsolutePath() : folderPath;
        }
        return folderPath;

    }

    private static void generateImage(String outputPath,String plantUmlText) throws IOException {
        // if(plantUmlText.isEmpty() || plantUmlText == null){
        //     System.out.println("error");
        //     return;
        // }
        


        File outputFile = new File(outputPath);
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        
        try {
            SourceStringReader reader = new SourceStringReader(plantUmlText);
        if(reader.equals(null)){
            System.out.println("error");
            return;
        }
        reader.outputImage(outputStream);
        System.out.println("is pass");
            System.out.println("UML image generated at: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
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
