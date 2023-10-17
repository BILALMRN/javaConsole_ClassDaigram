package Views;

import javax.swing.JFileChooser;



public class DataEntry extends DataDaigram {

    public DataEntry() {
        super();
    }

    public String chooseFilePathForSave() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null;
    }

    public String chooseFilePathForLoad() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null;
    }
}
