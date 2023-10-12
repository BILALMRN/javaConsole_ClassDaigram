package Models;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String className;

    public List<String> attributes;
    public List<String> methods;
    
    
    //#region constractor
    public Classe() {
        this.attributes = new ArrayList<>();
        this.methods =  new ArrayList<>();
    }

    public Classe(String className, List<String> attributes, List<String> methods) {
        this.attributes = attributes;
        this.methods = methods;
        setClassName(className);
    }
    //#endregion

    //#region getter and setter
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        if(className == null || className.isEmpty()){
            throw 
                new IllegalArgumentException("className is null");
        }
        this.className = className;
    }
    
    //#endregion
    
}
