package Views;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Classe;
import Models.Diagram;
import Models.Relationship;
import Models.Enum.RelationType;

 class DataDiagram {
    
    private Diagram diagram;
    protected Scanner scanner = new Scanner(System.in);
    private String DefaultName= "1";

    public DataDiagram() {
        diagram = new Diagram();
    }
    

    public Diagram createDiagram() {
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
                if (addClasses.equals("done") || !addClasses.equals("yes")) {
                    break;
                }
                
                diagram.addClassIfNotExist(createClass());
                System.out.println("Do you want to add other class to the diagram? (yes/no);Enter 'done' when finished.");
                System.out.print(":> ");
                addClasses = scanner.nextLine();
            }
        }
        

        System.out.println("Do you want to add Relationship to the diagram? (yes/no)");
        System.out.print(":> ");
        String addRelationship = scanner.nextLine().toLowerCase();

        if (addRelationship.equals("yes")) {
            addRelationship = "";
            while (true) {
                if (addRelationship.equals("done")) {
                    break;
                }
                
                diagram.addRelationshipIfNotExist(createRelationship());
                System.out.println("Do you want to add other Relationship to the diagram? (yes/no);Enter 'done' when finished.");
                System.out.print(":> ");
                addRelationship = scanner.nextLine();
            }
            
        }

        return diagram;
    }

    private void printAllNameClass(){
        System.out.println("List of all classes:");
        for (Classe classe : diagram.getListClass()) {
            System.out.println("#  " + classe.getClassName());
        }
    }

    private Relationship createRelationship(){
        
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
        String addMultiplicity = scanner.nextLine().toLowerCase();

        if (addMultiplicity.equals("yes")) {
            System.out.print("Enter the Multiplicity of ParentClass  the relationship: ");
            relationship.setParentMultiplicit(scanner.nextLine().toLowerCase());
            System.out.print("Enter the Multiplicity of ChildClass  the relationship: ");
            relationship.setChildMultiplicit(scanner.nextLine().toLowerCase());
        }
        return relationship;
    }

    private RelationType choiceRelationType(){
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

    private List<String> createAttributes(){

        System.out.println("Enter attributes (e.g., 'id : int', 'name : string'). Enter 'done' when finished.");
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

    private List<String> createMethods(){
        System.out.println("Enter methods (e.g., 'getId() : int', 'getName() : string'). Enter 'done' when finished.");
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

    private Classe createClass() {
        
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
}