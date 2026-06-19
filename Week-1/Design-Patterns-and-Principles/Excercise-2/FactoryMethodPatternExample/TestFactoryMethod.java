public class TestFactoryMethod {

    public static void main(String[] args) {

        // Create Word document using factory
        DocumentFactory wordFactory =
                new WordDocumentFactory();

        Document wordDoc =
                wordFactory.createDocument();

        wordDoc.open();

        // Create PDF document using factory
        DocumentFactory pdfFactory =
                new PdfDocumentFactory();

        Document pdfDoc =
                pdfFactory.createDocument();

        pdfDoc.open();

        // Create Excel document using factory
        DocumentFactory excelFactory =
                new ExcelDocumentFactory();

        Document excelDoc =
                excelFactory.createDocument();

        excelDoc.open();
    }
}