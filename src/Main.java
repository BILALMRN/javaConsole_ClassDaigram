// 
import java.io.IOException;

import Generator.DiagramGenerator;
import Models.Daigram;
import Models.Diagrams;
import Models.Classe;
import Models.Relationship;
import Models.Enum.RelationType;

public class Main{

    public static void main(String[] args) {


        /// teste le code 

        /// creat le projet
        Diagrams project = new Diagrams();
        project.setNameProject("test");


        // creat Daigram 
         Daigram daigram = new Daigram();
         daigram.diagramsAuthor = "bilal";
         daigram.diagramsDescription = "diagram de ecomerce pour test";

         daigram.setDiagramsName("dagram de ecomerce");

         // creat class

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
        class1.attributes.add("id : int ");
        class1.attributes.add("sold : double ");
        class1.attributes.add("name : string ");

        // add method
        class1.methods.add("getId()");
        class1.methods.add("buy()");
        class1.methods.add("sell()");
        class1.methods.add("getSold()");

        //****

        Classe class3 = new Classe();

        class3.setClassName("class3");

        // add attributes
        class1.attributes.add("id : int ");
        class1.attributes.add("sold : double ");
        class1.attributes.add("name : string ");

        // add method
        class1.methods.add("getId()");
        class1.methods.add("buy()");
        class1.methods.add("sell()");
        class1.methods.add("getSold()");

        //relationshep

        Relationship relationship = new Relationship();

        relationship.setParentClass(class1.getClassName());
        relationship.setChildClass(class2.getClassName());
        relationship.setParentMultiplicit("1..0");
        relationship.setChildMultiplicit("1..*");
        relationship.setRelationshipType(RelationType.GENERALIZATION);

        daigram.addClass(class1);
        daigram.addClassIfNotExist(class2);
        daigram.addClassIfNotExist(class3);
        daigram.addRelationship(relationship);
        daigram.addRelationshipIfNotExist(relationship);

        project.addDaigram(daigram);
        project.addDaigram(daigram);
        project.addDaigramIfNotExist(daigram);

        //DiagramGenerator generator = new DiagramGenerator();
        //try {
           // generator.generateDiagrams("/home/bilal/Desktop",project);
        //}
        //catch
        //(IOException e) {

            //e.printStackTrace();
        //}
        
        
    }

}