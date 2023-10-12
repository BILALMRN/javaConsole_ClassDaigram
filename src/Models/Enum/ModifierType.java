package Models.Enum;

public enum ModifierType {
    PRIVATE("-"),
	PRIVATE_STATIC("- {static}"),
	PRIVATE_FINAL_STATIC(""),
	
	PROTECTED("#"),
    PROTECTED_ABSTRACT("# {abstract}"),
	PROTECTED_STATIC("{static}"),
	PROTECTED_FINAL_STATIC(""),
	
	PUBLIC("+"),
	PUBLIC_ABSTRACT("+ {abstract}"),
	PUBLIC_STATIC("+ {static}"),
	PUBLIC_FINAL_STATIC(""),
	
	PACKAGE("~"),
	PACKAGE_ABSTRACT("~ {abstract}"),
	PACKAGE_STATIC("~ {static}"),
	PACKAGE_FINAL_STATIC("");
    
    private String modifierType;
    
    ModifierType(String modifierType) {
        this.modifierType = modifierType;
    }
    public String getModifier() {
        return modifierType;
    }
}
