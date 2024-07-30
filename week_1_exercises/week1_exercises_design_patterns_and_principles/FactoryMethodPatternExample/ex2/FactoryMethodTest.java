package ex2;

public class FactoryMethodTest {
    public static void main(String[] args) {
        Document wordDoc = new WordDocument();
        Document pdfDoc = new PdfDocument();
        Document excelDoc = new ExcelDocument();
        wordDoc.createDocument();
        pdfDoc.createDocument();
        excelDoc.createDocument();
        
    }
}

