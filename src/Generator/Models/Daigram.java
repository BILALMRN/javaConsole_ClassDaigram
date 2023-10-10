package Generator.Models;

import java.util.ArrayList;
import java.util.List;

public class Daigram {
    private static int id=1;
    private String diagramsName;
    private List<Relationship> relationships;
    private List<Class> daigram;
    
        // @startuml
        // 1- add relation

        // Object <|-- ArrayList
        // 2- add feild
        // Object : equals()
        // ArrayList : Object[] elementData
        // ArrayList : size()

        // @enduml

    public String diagramsDescription;
    public String diagramsAuthor;


    //#region constractor
    public Daigram() {
        this.daigram = new ArrayList<Class>();
        this.id+=1;
    }
    
    public Daigram(String diagramsName, String diagramsDescription, String diagramsAuthor, List<Class> daigram) {
        this.diagramsDescription = diagramsDescription;
        this.diagramsAuthor = diagramsAuthor;
        setDiagramsName(diagramsName);
        this.daigram = new ArrayList<Class>();
        this.id+=1;
    }
    //#endregion

    //#region getter and setter
    public static int getId() {
        return id;
    }
    public String getDiagramsName() {
        return diagramsName;
    }
    public void setDiagramsName(String diagramsName) {
        if(diagramsName != null || !diagramsName.isEmpty())
        this.diagramsName = diagramsName;
        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        if(relationships == null || relationships.isEmpty()){
            throw 
                new IllegalArgumentException("className is null");
        }
        this.relationships = relationships;
    }
    public List<Class> getDaigram() {
        return daigram;
    }
    public void setDaigram(List<Class> daigram) {
        if(daigram != null)
        this.daigram = daigram;
        else throw 
                new IllegalArgumentException("daigram is null   / List<Class> is null");
    }
    
    //#endregion

    public void editClass(Class c, int index) {
        if(c != null && index >= 0 && index < this.daigram.size())
        this.daigram.set(index, c);
        else throw 
                new IllegalArgumentException("class is null or index not exist");
    }
    public void addClass(Class c) {
        if(c != null ){
            this.daigram.add(c);
        }
    }
    public void addClassIfNotExist(Class c) {
        if(c != null ){
            if(this.daigram.contains(c)) 
                this.daigram.add(c);
        }
        

        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public void removeClass(Class c) {

        if(c != null){
            this.daigram.remove(c);
        }


        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public void removeAllClass() {
        this.daigram.clear();
    }

}
