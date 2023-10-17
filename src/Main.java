import Models.Diagrams;
import Views.DataEntry;

public class Main{

    public static void main(String[] args) {

        Diagrams project = new Diagrams();

        DataEntry dataEntry = new DataEntry();

        project.addDaigramIfNotExist(dataEntry.createDaigram());
        
        


    
        
        
    }

}