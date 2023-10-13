import java.util.ArrayList;
import java.util.Scanner;

public class DataEntry {
    private String className;
    private ArrayList<String> attributes = new ArrayList<>();
    private ArrayList<String> methods = new ArrayList<>();

    public DataEntry(String className) {
        this.className = className;
    }

    public void addAttribute(String attribute) {
        attributes.add(attribute);
    }

    public void addMethod(String method) {
        methods.add(method);
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public ArrayList<String> getMethods() {
        return methods;
    }

    public static DataEntry createDataEntry() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the class name:");
        String className = scanner.nextLine();

        DataEntry dataEntry = new DataEntry(className);

        System.out.println("Do you want to add attributes to the class? (yes/no)");
        String addAttributes = scanner.nextLine().toLowerCase();

        if (addAttributes.equals("yes")) {
            System.out.println("Enter attributes (e.g., 'id : int', 'name : string'). Enter 'done' when finished.");
            while (true) {
                String attribute = scanner.nextLine();
                if (attribute.equals("done")) {
                    break;
                }
                dataEntry.addAttribute(attribute);
            }
        }

        System.out.println("Do you want to add methods to the class? (yes/no)");
        String addMethods = scanner.nextLine().toLowerCase();

        if (addMethods.equals("yes")) {
            System.out.println("Enter methods (e.g., 'getId()', 'buy()'). Enter 'done' when finished.");
            while (true) {
                String method = scanner.nextLine();
                if (method.equals("done")) {
                    break;
                }
                dataEntry.addMethod(method);
            }
        }

        return dataEntry;
    }
}
