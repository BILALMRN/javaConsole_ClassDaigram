package Generator;

import Generator.Models.Diagrams;


public class DiagramGenerator {
    private String path;

    public void generateDiagram(String path,Diagrams diagrams) {
        if(validData(path,diagrams)){

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
