package test.img;

import java.io.IOException;

import Generator.DiagramGenerator;
import Models.Classe;
import Models.Diagram;
import Models.Diagrams;
import Models.Relationship;
import Models.Enum.RelationType;

public class test {
    public static void main(String[] args) {
            /// tested le code

        /// create le project
        Diagrams project = new Diagrams();
        project.setNameProject("test");


        // create Diagram
         Diagram diagram = new Diagram();
         diagram.diagramsAuthor = "bilal";
         diagram.diagramsDescription = "diagram de ecommerce pour test";

         diagram.setDiagramsName("diagram de ecommerce");

         // create class

        Classe class1 = new Classe();

        class1.setClassName("class1");

        // add attributes
        class1.attributes.add("id : int ");
        class1.attributes.add("sold : double ");
        class1.attributes.add("name : string ");

        // add method
        class1.methods.add("getId()");
        class1.methods.add("buy()");
        class1.methods.add("sell()");
        class1.methods.add("getSold()");

        //****

        Classe class2 = new Classe();

        class2.setClassName("class2");

        // add attributes
        class2.attributes.add("id : int ");
        class2.attributes.add("sold : double ");
        class2.attributes.add("name : string ");

        // add method
        class2.methods.add("getId()");
        class2.methods.add("buy()");
        class2.methods.add("sell()");
        class2.methods.add("getSold()");

        //****

        Classe class3 = new Classe();

        class3.setClassName("class3");

        // add attributes
        class3.attributes.add("id : int ");
        class3.attributes.add("sold : double ");
        class3.attributes.add("name : string ");

        // add method
        class3.methods.add("getId()");
        class3.methods.add("buy()");
        class3.methods.add("sell()");
        class3.methods.add("getSold()");

        //relationship

        Relationship relationship = new Relationship();

        relationship.setParentClass(class1.getClassName());
        relationship.setChildClass(class2.getClassName());
        relationship.setParentMultiplicit("1..0");
        relationship.setChildMultiplicit("1..*");
        relationship.setRelationshipType(RelationType.GENERALIZATION);

        Relationship relationship1 = new Relationship();

        relationship1.setParentClass(class2.getClassName());
        relationship1.setChildClass(class3.getClassName());
        relationship1.setParentMultiplicit("1..0");
        relationship1.setChildMultiplicit("1..*");
        relationship1.setRelationshipType(RelationType.GENERALIZATION);

        Relationship relationship2 = new Relationship();

        relationship2.setParentClass(class3.getClassName());
        relationship2.setChildClass(class1.getClassName());
        relationship2.setParentMultiplicit("0..1");
        relationship2.setChildMultiplicit("1..*");
        relationship2.setRelationshipType(RelationType.GENERALIZATION);


        ////* */

        diagram.addClass(class1);
        diagram.addClass(class2);
        diagram.addClassIfNotExist(class3);
        diagram.addRelationship(relationship);
        diagram.addRelationshipIfNotExist(relationship1);
        diagram.addRelationshipIfNotExist(relationship2);

        project.addDaigram(diagram);
        project.addDaigramIfNotExist(diagram);
        project.addDaigramIfNotExist(diagram);

        DiagramGenerator generator = new DiagramGenerator();
        try {
           generator.generateDiagrams("/home/bilal/Desktop",project);
            System.out.println("tt");
        }
        catch
        (IOException e) {

            e.printStackTrace();
        }
    }
}
