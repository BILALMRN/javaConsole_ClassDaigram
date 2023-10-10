package Generator.Models;

import java.util.List;

public class Class {
    private String className;

    public List<String> attributes;
    public List<String> methods;
    
    
    //#region constractor
    public Class() {
    }

    public Class(String className, List<String> attributes, List<String> methods) {
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
