import java.io.IOException;
import java.util.Scanner;

import Generator.DiagramGenerator;
import Views.DataProject;

public class Main{

    public static void main(String[] args) throws IOException {

        int choice = 0;
        try {
            do{
                System.out.println("Entre you choice : \n" +
            "1. create project Diagram (img && json) \n" +
            "2. edit project Diagram \n" +
            "3. generate pdf contain Diagrams project \n" +
            "4. exit \n");

            System.out.print(":> ");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) choice = 0;
            else choice = input.nextInt();
                // Process the integer
            
            switch(choice){
                case 1 : 
                    {
                        System.out.println("***************you must choose file path***************");
                        var path = DataProject.chooseFilePathForSave();
                        if(path == null){
                            System.out.println(":) you must choose file path");
                            break;
                        }
                        DiagramGenerator generate = new DiagramGenerator();                        
                        generate.generateDiagrams(path,DataProject.createProject());
                    }
                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nWrong choice");
                    break;
                
            }

            }while(true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        

        
        
        


    
        
        
    }

}