package Models;

import java.util.ArrayList;
import java.util.List;

public class Diagrams{
    private String nameProject;
    private List<Diagram> diagramList;


    public Diagrams(){
        this.diagramList = new ArrayList<>();
    }
    public Diagrams(String nameProject, List<Diagram> diagramList) {

    }

    public String getNameProject() {
        if (nameProject == null) {
            return "unknown";
        }
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        if(nameProject == null)
            throw new NullPointerException("Name project is null");
        this.nameProject = nameProject;
    }

    public List<Diagram> getDiagramList() {
        return diagramList;
    }

    public void setDiagramList(List<Diagram> diagramList) {
        if(nameProject == null)
            throw new NullPointerException("diagramList project is null");
        this.diagramList = diagramList;
    }

    public void addDaigram(Diagram c) {
        if(c != null ){
            this.diagramList.add(c);
        }
    }
    public void addDaigramIfNotExist(Diagram c) {
        if(c != null ){
            if(!this.diagramList.contains(c)) 
                this.diagramList.add(c);
        }
        

        else throw 
                new IllegalArgumentException("diagramList is null");
    }
    public void removeDaigram(Diagram c) {

        if(c != null){
            this.diagramList.remove(c);
        }


        else throw 
                new IllegalArgumentException("diagramList is null");
    }
    public void removeAllDaigram() {
        this.diagramList.clear();
    }

    

}
