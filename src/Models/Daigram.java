package Models;

import java.util.ArrayList;
import java.util.List;

public class Daigram {
    private static int id=1;
    private String diagramsName;
    private List<Relationship> relationships;
    private List<Classe> daigram;
    

    public String diagramsDescription;
    public String diagramsAuthor;


    //#region constractor
    public Daigram() {
        this.daigram = new ArrayList<Classe>();
        this.relationships = new ArrayList<Relationship>();
        this.id+=1;
    }
    
    public Daigram(String diagramsName, String diagramsDescription, String diagramsAuthor, List<Classe> daigram) {
        this.diagramsDescription = diagramsDescription;
        this.diagramsAuthor = diagramsAuthor;
        setDiagramsName(diagramsName);
        this.daigram = new ArrayList<Classe>();
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
    public List<Relationship> getListRelationships() {
        return relationships;
    }

    public void setListRelationships(List<Relationship> relationships) {
        if(relationships == null || relationships.isEmpty()){
            throw 
                new IllegalArgumentException("className is null");
        }
        this.relationships = relationships;
    }
    public List<Classe> getListClass() {
        return daigram;
    }
    public void setListClass(List<Classe> daigram) {
        if(daigram != null)
        this.daigram = daigram;
        else throw 
                new IllegalArgumentException("daigram is null   / List<Class> is null");
    }
    
    //#endregion

    public void editClass(Classe c, int index) {
        if(c != null && index >= 0 && index < this.daigram.size())
        this.daigram.set(index, c);
        else throw 
                new IllegalArgumentException("class is null or index not exist");
    }
    public void addClass(Classe c) {
        if(c != null ){
            this.daigram.add(c);
        }
    }
    public void addClassIfNotExist(Classe c) {
        if(c != null ){
            if(!this.daigram.contains(c)) 
                this.daigram.add(c);
        }
        

        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public void removeClass(Classe c) {

        if(c != null){
            this.daigram.remove(c);
        }


        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public void removeAllClass() {
        this.daigram.clear();
    }

    public void editRelationship(Relationship c, int index) {
        if(c != null && index >= 0 && index < this.relationships.size())
        this.relationships.set(index, c);
        else throw 
                new IllegalArgumentException("class is null or index not exist");
    }
    public void addRelationship(Relationship c) {
        if(c != null ){
            this.relationships.add(c);
        }
    }
    public void addRelationshipIfNotExist(Relationship c) {
        if(c != null ){
            if(!this.relationships.contains(c)) 
                this.relationships.add(c);
        }
        

        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public void removeRelationship(Classe c) {

        if(c != null){
            this.relationships.remove(c);
        }


        else throw 
                new IllegalArgumentException("daigram is null");
    }
    public void removeAllRelationship() {
        this.relationships.clear();
    }

}
