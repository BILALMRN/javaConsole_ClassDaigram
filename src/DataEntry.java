import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataEntry implements Serializable {
    private String className;
    private List<String> attributes;
    private List<String> methods;

    public DataEntry() {
        this.attributes = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public void collectDataFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter class name:");
        this.className = scanner.nextLine();

        System.out.println("Add attributes (type 'done' to finish):");
        String attribute;
        while (!(attribute = scanner.nextLine()).equalsIgnoreCase("done")) {
            attributes.add(attribute);
        }

        System.out.println("Add methods (type 'done' to finish):");
        String method;
        while (!(method = scanner.nextLine()).equalsIgnoreCase("done")) {
            methods.add(method);
        }
    }

    public void setData(String className, List<String> attributes, List<String> methods) {
        this.className = className;
        this.attributes = attributes;
        this.methods = methods;
    }

    public String getClassName() {
        return className;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public List<String> getMethods() {
        return methods;
    }
}
