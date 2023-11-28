package Generator;

import java.io.File;
import java.io.IOException;

import Generator.Helper.GenerateUML;
import Models.Diagram;
import Models.Diagrams;
import Models.ImgData;
import Models.PdfData;

public class DiagramGenerator {
    private String path = null;
    private PdfData pdfData = null;

    
    // doc for utilisation a lib plantuml : https://plantuml.com/class-diagram

    public PdfData getPdfData(){
        if(pdfData== null){
            throw new IllegalArgumentException("PdfData is null you need to execute generateDiagrams (add/edit project) first!!!");
        }
        return pdfData;
    }

    /**
     * @param path
     * @param diagrams
     * @throws IOException
     */
    public void generateDiagrams(String path,Diagrams diagrams) throws IOException {
         if( isDotCommandAvailable() && /* Check if the executable file Graphviz (dot) exists: to draw */
             validData(path,diagrams) &&
             createdFolderIfNotExist(path) 
            ){
            pdfData = new PdfData();
            pdfData.pdfName = diagrams.getNameProject();
             for (Diagram diagram : diagrams.getDiagramList())
             {
                var pathImg = GenerateUML.generateUmlImage(diagram,path);
                if(pathImg != null){
                    pdfData.imgs.add(new ImgData(diagram.getDiagramsName(), diagram.diagramsDescription, pathImg));
                }
                
             }
            }
        
        
    }
    private boolean validData(String path,Diagrams diagrams){
        setPath(path);
        if(diagrams == null ) return false;
        
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
        boolean isCreate = folder.exists();
        if(!isCreate){
            isCreate = folder.mkdir();
        }
        return isCreate;

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
            System.out.println("------------- isDot Command Not Available \n\n");
            return false;
        }
    }
}
