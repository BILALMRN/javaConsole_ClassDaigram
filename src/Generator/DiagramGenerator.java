package Generator;

import Generator.Helper.GenerateUML;
import Generator.Models.Diagrams;
import net.sourceforge.plantuml.core.Diagram;


public class DiagramGenerator {
    private String path;


    // doc for utilisation a lib plantuml : https://plantuml.com/class-diagram
    public void generateDiagram(String path,Diagrams diagrams) {
        if(validData(path,diagrams)){
            String uml;
            for (Diagram diagram : diagrams) {
                
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

    
    
}
