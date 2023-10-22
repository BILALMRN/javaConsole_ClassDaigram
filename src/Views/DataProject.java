package Views;

import java.io.IOException;
import java.util.Scanner;

import Models.Diagrams;

public class DataProject extends DataEntry{
    public static Diagrams createProject() throws IOException{
        Diagrams project = new Diagrams();
        return choiceOperationDiagrams(project);
    }
    public static Diagrams editProject(Diagrams project) throws IOException{
        if(project==null)throw new IllegalArgumentException("the project is null to edit");
        return choiceOperationDiagrams(project);
    }

    private static Diagrams choiceOperationDiagrams(Diagrams project) throws IOException{
        if(project == null){
            //System.out.println("le project is null or empty ");
            throw new IllegalArgumentException("the project is null");
        }
        int choice = 0;
        try {
                do{
                    System.out.println("entre you choice : \n" +
                "1. Add Diagram \n" +
                "2. Edit Diagram \n" +
                "3. Delete Diagram \n" +
                "4. done \n");
                System.out.print(":> ");
                Scanner input = new Scanner(System.in);
                if (!input.hasNextInt()) choice = 0;
                else choice = input.nextInt();
                //input.close();
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
