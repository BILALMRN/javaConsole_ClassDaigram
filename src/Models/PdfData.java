package Models;

import java.util.List;

public class PdfData {
    public String pdfName;
    public List<ImgData> imgs;



    public PdfData(){
        imgs = new java.util.ArrayList<>();
    }

    // public static ImgData createImg(String titre, String description, String imgPath){
    //     return new ImgData( titre,  description,  imgPath);
    // }
}



