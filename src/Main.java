import java.io.IOException;
import java.util.Scanner;

import Generator.DiagramGenerator;
import Views.DataProject;

public class Main{
    private static DiagramGenerator generate= new DiagramGenerator();;

    public static void main(String[] args) throws IOException {

        int choice = 0;
        try {
            do{
                System.out.println("Entre you choice : \n" +
            "1. create project \n" +
            "2. edit project \n" +
            "3. generate pdf \n" +
            "4. exit \n");

            System.out.print(":> ");
            Scanner input = new Scanner(System.in);
            if (!input.hasNextInt()) choice = 0;
            else choice = input.nextInt();
                // Process the integer
            
            switch(choice){
                case 1 : 
                    generate = new DiagramGenerator(); 
                    createNewProject();
                    break;
                case 2 :

                    break;
                case 3 :
                    generate = new DiagramGenerator(); 
                    createNewPdf();
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
    public static void createNewProject() throws IOException{
        System.out.println("***************choose file path***************");
        System.out.println("");
        var path = DataProject.chooseFilePathForSave();
        if(path == null){
            System.out.println(":) you must choose file path");
            return;
        }                     
        generate.generateDiagrams(path,DataProject.createProject());
    }
    public static void createNewPdf() throws IOException{
        createNewProject();
        var pdfData = generate.getPdfData();
        ///
        System.out.println("this method not completed");

    }

}