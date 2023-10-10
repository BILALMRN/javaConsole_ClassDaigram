// 
import Generator.DiagramGenerator;
import Generator.PdfGenerator;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();

        System.out.println("Choose an option:");
        System.out.println("1. Create a new project");
        System.out.println("2. Load a project from a file");

        int choice = scanner.nextInt();

        DataEntry dataEntry = new DataEntry();

        if (choice == 1) {
            // Create a new project
            dataEntry.collectDataFromUser();
        } else if (choice == 2) {
            // Load a project from a file
            int returnValue = fileChooser.showOpenDialog(frame);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile))) {
                    DataEntry loadedData = (DataEntry) ois.readObject();
                    dataEntry.setData(loadedData.getClassName(), loadedData.getAttributes(), loadedData.getMethods());
                    System.out.println("Project loaded successfully from the file.");
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error loading the project: " + e.getMessage());
                }
            } else {
                System.out.println("No file selected.");
            }
        }

        // Use the DataEntry data to create the class and the PDF file here

        frame.dispose();
    }
}
