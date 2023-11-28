package Models;

import Models.Enum.RelationType;

public class Relationship {
    private String childClass = "";
    private String parentClass = "";
    private RelationType relationshipType;
    private String parentMultiplicit = "";
    private String childMultiplicit = "";

    //#region constractor
    public Relationship() {
        
    }
    public Relationship(String childClass, String parentClass, RelationType relationshipType, String parentMultiplicit,
            String childMultiplicit) {
        this.childClass = childClass;
        this.parentClass = parentClass;
        this.relationshipType = relationshipType;
        this.parentMultiplicit = parentMultiplicit;
        this.childMultiplicit = childMultiplicit;
    }

    
    //#endregion

    //#region getter and setter

    public String getChildClass() {
        return childClass;
    }


    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }


    public String getParentClass() {
        return parentClass;
    }


    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }
    
    public RelationType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationType relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getParentMultiplicit() {
        return parentMultiplicit;
    }

    public void setParentMultiplicit(String parentMultiplicit) {
        this.parentMultiplicit = parentMultiplicit;
    }

    public String getChildMultiplicit() {
        return childMultiplicit;
    }

    public void setChildMultiplicit(String childMultiplicit) {
        this.childMultiplicit = childMultiplicit;
    }
    //#endregion


    
    
}
