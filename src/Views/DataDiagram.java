package Views;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Classe;
import Models.Diagram;
import Models.Relationship;
import Models.Enum.RelationType;

 class DataDiagram {
    
    private static Diagram diagram;
    private static String DefaultName= "1";

    private DataDiagram() {
        
    }
    
    public static Diagram createDiagram() {
        diagram = new Diagram();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the diagram name: ");
        String diagramsName = scanner.nextLine();
        diagram.setDiagramsName(diagramsName.isEmpty() ? DefaultName+=1 : diagramsName);
        
        System.out.print("Enter the Author name: ");
        String diagramsAuthor = scanner.nextLine();
        diagram.diagramsAuthor = diagramsAuthor;

        System.out.print("Enter the diagrams description: ");
        String diagramsDescription = scanner.nextLine();
        diagram.diagramsDescription = diagramsDescription;

        System.out.print("Do you want to add class to the diagram? (yes/no)");
        System.out.print(":> ");
        String addClasses = scanner.nextLine().toLowerCase();

        if (addClasses.equals("yes")) {
            addClasses = "";
            while (true) {
                diagram.addClassIfNotExist(createClass());
                System.out.println("Do you want to add other class to the diagram? (yes/no);");
                System.out.print(":> ");
                addClasses = scanner.nextLine();
                if (!addClasses.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }
        
        if(diagram.getListClass().size() < 1) return diagram ;

        System.out.println("Do you want to add Relationship to the diagram? (yes/no)");
        System.out.print(":> ");
        String addRelationship = scanner.nextLine().toLowerCase();

        if (addRelationship.equals("yes")) {
            addRelationship = "";
            while (true) {
                
                diagram.addRelationshipIfNotExist(createRelationship());
                System.out.println("Do you want to add other Relationship to the diagram? (yes/no);.");
                System.out.print(":> ");
                addRelationship = scanner.nextLine();
                if (!addRelationship.equalsIgnoreCase("yes")) {
                    break;
                }
            }
            
        }

        return diagram;
    }



    // public static Diagram editDiagram(){
        
    //     return createDiagram();
    // }

    //#region function use in createDiagram

    private static void printAllNameClass(){
        System.out.println("List of all classes:");
        for (Classe classe : diagram.getListClass()) {
            System.out.println("#  " + classe.getClassName());
        }
    }

    private static Relationship createRelationship(){
        Scanner scanner = new Scanner(System.in);
        printAllNameClass();
        Relationship relationship = new Relationship();
        System.out.println("Example:    ParentClass --relation-- ChildClass");
        System.out.print("Enter the name of ParentClass  the relationship: ");
        relationship.setParentClass(scanner.nextLine().toLowerCase());
        System.out.print("Enter the name of ChildClass  the relationship: ");
        relationship.setChildClass(scanner.nextLine().toLowerCase());

        relationship.setRelationshipType(choiceRelationType());
        
        System.out.println("Do you want to add Multiplicity to the Relationship? (yes/no)");
        System.out.println("Example:    ParentClass '1..2'  --relation--  '0..*' ChildClass");
        System.out.print(":> ");
        scanner = new Scanner(System.in);
        String addMultiplicity;
        addMultiplicity = scanner.nextLine();

        if (addMultiplicity.toLowerCase().equals("yes")) {
            System.out.print("Enter the Multiplicity of ParentClass  the relationship: ");
            relationship.setParentMultiplicit(scanner.nextLine().toLowerCase());
            System.out.print("Enter the Multiplicity of ChildClass  the relationship: ");
            relationship.setChildMultiplicit(scanner.nextLine().toLowerCase());
        }
        return relationship;
    }

    private static RelationType choiceRelationType(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
        System.out.println("choose relationship type (NUM ):");
        System.out.println("1. DEPENDENCY");
        System.out.println("2. ASSOCIATION");
        System.out.println("3. AGGREGATION");
        System.out.println("4. COMPOSITION");
        System.out.println("5. GENERALIZATION");
        System.out.println("6. REALIZATION");
        System.out.println("7. INHERITANCE");
        System.out.print(":> ");
        choice = scanner.nextInt();
        }while(choice < 1 || choice > 7 );
        
        
        RelationType relationType = null;
        switch (choice){
            case 1:
                relationType = RelationType.DEPENDENCY;
                break;
            case 2:
                relationType = RelationType.ASSOCIATION;
                break;
            case 3:
                relationType = RelationType.AGGREGATION;
                break;
            case 4:
                relationType = RelationType.COMPOSITION;
                break;
            case 5:
                relationType = RelationType.GENERALIZATION;
                break;
            case 6:
                relationType = RelationType.REALIZATION;
                break;
            case 7:
                relationType = RelationType.INHERITANCE;
                break;
        }
        return relationType;
    }

    private static List<String> createAttributes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter attributes exemple( Visibilite nom_de_Attribut :Type ). Enter 'done' when finished.");
        System.out.print(":> ");
        List <String> attributes = new ArrayList<>();
            while (true) {
                String attribute = scanner.nextLine();
                if (attribute.equals("done")) {
                    break;
                }
                attributes.add(attribute);
            }
        return attributes;
    }

    private static List<String> createMethods(){
        Scanner scanner = new Scanner(System.in);
       System.out.println("Enter methods exemple( Visibilite nom_de_Method():Type_de_retoun ). Enter 'done' when finished.");
        System.out.print(":> ");
        List <String> methods = new ArrayList<>();
            while (true) {
                String method = scanner.nextLine();
                if (method.equals("done")) {
                    break;
                }
                methods.add(method);
            }
        return methods;
    }

    private static Classe createClass() {
        Scanner scanner = new Scanner(System.in);
        Classe classe = new Classe();

        System.out.print("Enter the class name: ");
        String className = scanner.nextLine();
        classe.setClassName(className.isEmpty() ? DefaultName+=1 : className);
        

        System.out.println("Do you want to add attributes to the class? (yes/no) : ");
        System.out.print(":> ");
        String addAttributes = scanner.nextLine().toLowerCase();

        if (addAttributes.equals("yes")) {
            classe.attributes.addAll(createAttributes());
        }

        System.out.println("Do you want to add methods to the class? (yes/no) : ");
        System.out.print(":> ");
        String addMethods = scanner.nextLine().toLowerCase();

        if (addMethods.equals("yes")) {
            classe.methods.addAll(createMethods());
        }
        return classe;
    }

    //#endregion

    //#region function afiche


    
    //#endregion
}
