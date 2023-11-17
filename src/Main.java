import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Generator.DiagramGenerator;
import Generator.PdfGenerator;
import Generator.Helper.JsonHelper;
import Models.Diagrams;
import Views.Project;
import Views.Helper.FileHelper;

public class Main{
    private static DiagramGenerator generate= new DiagramGenerator();
    // private static Diagrams projectDiagrams = new Diagrams();
    private static Scanner input;

    public static void main(String[] args) {

        int choice = 0;
        
        try {
            do{
                System.out.println("Entre you choice : \n" +
            "1. create project \n" +
            "2. edit project from JSON\n" +
            "3. generate pdf \n" +
            "4. exit \n");

            System.out.print(":> ");
            input = new Scanner(System.in);
            if (!input.hasNextInt()) choice = 0;
            else choice = input.nextInt();
            //input.close();
                // Process the integer
            
            switch(choice){
                case 1 : 
                    generate = new DiagramGenerator(); 
                    System.out.print("  :> entre name of the project : ");
                    String nameProject = input.next();
                    nameProject = nameProject == null ? "lastProject" : nameProject;
                    ///
                    createNewProject(nameProject);
                    break;
                case 2 :
                    editProject();
                    break;
                case 3 :
                    ///
                    createPdf();
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
        }finally{
            input.close();
        }
   
        
    }

    private static void editProject() throws IOException{
        disaplayHeaderChoocePath();
        String path = FileHelper.chooseFilePathForLoad();
        String jsonProject = FileHelper.readJSONFileAsString(path);
        System.out.println(path);
        Diagrams project = JsonHelper.getUmlDiagramsFromJson(jsonProject);
        if(project==null) return;
        var t = path.lastIndexOf(File.separator + project.getNameProject()+ ".json");
        String pathProject = path.substring(0,t);
        generate.generateDiagrams(pathProject,project);
    }

    private static void disaplayHeaderChoocePath(){
        System.out.println("***************choose file path***************");
        System.out.println("");
    }
    
    private static String getAbsolutePath(){
        disaplayHeaderChoocePath();
        return FileHelper.chooseFilePathForSave();
    }

    private static String createNewProject(String nameProject) throws IOException{
        var path = getAbsolutePath();
        if(path == null){
            System.out.println(":) you must choose file path");
            return null;
        }
        Diagrams newProject = Project.createProject() ;

        newProject.setNameProject(nameProject);  
        path = path + File.separator +  nameProject; 

        generate.generateDiagrams(path,newProject);
        JsonHelper.saveUmlDiagramsAsJson(newProject,path);
        return path;
    }

    private static void createPdf() throws IOException{
        if(generate == null){
            System.out.println(":) you need create/edit project first ");
            return;
        }
        var path = generate.getPath();
        if(path == null) {
            System.out.println(":) you must choose file path");
        } ;
        
        var pdfData = generate.getPdfData();
        PdfGenerator.generatePDF(pdfData, path);
        System.out.println("completed");

    }

}