package Generator;

import java.io.File;
import java.io.IOException;

import Generator.Helper.GenerateUML;
import Models.Daigram;
import Models.Diagrams;

public class DiagramGenerator {
    private String path;


    // doc for utilisation a lib plantuml : https://plantuml.com/class-diagram
    /**
     * @param path
     * @param diagrams
     * @throws IOException
     */
    public void generateDiagrams(String path,Diagrams diagrams) throws IOException {
        if(validData(path,diagrams) && createdFolderIfNotExist(diagrams.getNameProject()) ){
             for (Daigram diagram : diagrams.getDiagramList())
             {
                 GenerateUML.generateUmlImage(diagram,path);
            }
        }
        
        
    }
    private boolean validData(String path,Diagrams diagrams){
        setPath(path);
        if(diagrams == null)
            throw new IllegalArgumentException("Your project is empty no diagrams");
        
        return true;
    }
    private void setPath(String path) {
        if (path == null|| path.isEmpty()) 
            throw  new IllegalArgumentException("Path is empty");
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    private boolean createdFolderIfNotExist(String folderPath){
        File folder = new File(folderPath);
        boolean isCreat = folder.exists();
        if(!isCreat){
            isCreat = folder.mkdir();
        }
        return isCreat;

    }
    
}
