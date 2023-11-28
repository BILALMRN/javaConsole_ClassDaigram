package Views;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Models.Diagram;
import Models.Diagrams;

public class Project {


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
        Scanner input;
        int choice = 0;
        try {
                do{
                    System.out.println("entre you choice : \n" +
                "1. Add Diagram \n" +
                "2. Edit Diagram \n" +
                "3. Delete Diagram \n" +
                "4. Delete  all Diagrams \n" +
                "5. done \n");
                System.out.print(":> ");
                input = new Scanner(System.in);
                if (!input.hasNextInt()) choice = 0;
                else choice = input.nextInt();
                //input.close();
                switch(choice){
                    case 1 : 
                        {
                            project.addDaigramIfNotExist(DataDiagram.createDiagram());
                        }
                        break;
                    case 2 :

                            var DiagramList1 = project.getDiagramList();
                            if (DiagramList1==null)break;
                            int index = selectDiagram(DiagramList1);
                            if(index >= 0) project.removeDaigram(DiagramList1.get(index));
                            project.addDaigramIfNotExist(DataDiagram.createDiagram());
                        
                        break;
                    case 3 :

                            List<Diagram> DiagramList = project.getDiagramList();
                            if (DiagramList==null)break;
                            int index3 = selectDiagram(DiagramList);
                            if(index3 >= 0) project.removeDaigram(DiagramList.get(index3));
                            
                        
                        break;
                    case 4 :
                            project.removeAllDaigram();
                        break;
                    case 5 :
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
    private static int selectDiagram(List<Diagram> DiagramList){
        int index = 0;
        int choice = 0;
            System.out.println("Select diagram");
            for (Diagram diagram2 : DiagramList) {
                System.out.println("        "+(++index)+" : "+diagram2.getDiagramsName());
            }
        Scanner input = new Scanner(System.in);
        System.out.print(":> ");
            if (!input.hasNextInt()) return -1;
            else choice = input.nextInt() - 1 ;

            if(choice < 0 || choice >= DiagramList.size()) return -1;
            return choice;
        
    }

}
