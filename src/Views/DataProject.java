package Views;

import java.io.IOException;
import java.util.Scanner;

import Models.Diagrams;

public class DataProject extends DataEntry{
    public static Diagrams createProject() throws IOException{
        Diagrams project = new Diagrams();
        int choice = 0;
            try {
                do{
                    System.out.println("entre you choice : \n" +
                "1. create Diagram \n" +
                "2. edit Diagram \n" +
                "3. delete Diagram \n" +
                "4. done \n");
                System.out.print(":> ");
                Scanner input = new Scanner(System.in);
                if (!input.hasNextInt()) choice = 0;
                else choice = input.nextInt();
                switch(choice){
                    case 1 : 
                        {
                        DataEntry dataEntry = new DataEntry();
                        project.addDaigramIfNotExist(dataEntry.createDiagram());
                        
                        }
                        break;
                    case 2 :

                        break;
                    case 3 :

                        break;
                    case 4 :
                        return project;
                    default:
                        System.out.println("Wrong choice");
                        break;

                    
                }

                }while(true);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return project;
    }
}
