package Generator;

import java.io.File;
import java.io.IOException;

import Generator.Helper.GenerateUML;
import Models.Diagram;
import Models.Diagrams;

public class DiagramGenerator {
    private String path = "Path is empty";


    // doc for utilisation a lib plantuml : https://plantuml.com/class-diagram
    /**
     * @param path
     * @param diagrams
     * @throws IOException
     */
    public void generateDiagrams(String path,Diagrams diagrams) throws IOException {
         if( isDotCommandAvailable() && /* Check if the executable file Graphviz (dot) exists: to draw */
             validData(path,diagrams) &&
             createdFolderIfNotExist(diagrams.getNameProject()) 
            ){
             for (Diagram diagram : diagrams.getDiagramList())
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

    /**
     * @return true if the directory was created or is Exist
     * @param folderPath
     * 
     */
    private boolean createdFolderIfNotExist(String folderPath){
        File folder = new File(folderPath);
        boolean isCreat = folder.exists();
        if(!isCreat){
            isCreat = folder.mkdir();
        }
        return isCreat;

    }
   
    /**
     * @Description Check if the executable file Graphviz (dot) exists :
     * @Note Graphviz (dot) is executable file in system to draw
     */
    private boolean isDotCommandAvailable() {
        try {
            Process process = new ProcessBuilder("dot", "-V")
                    .redirectErrorStream(true)
                    .start();
            int exitCode = process.waitFor();
            System.out.println("ok");
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            System.out.println(":not ");
            return false;
        }
    }
}
