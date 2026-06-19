// Abstract factory declaring the factory method
abstract class DocumentFactory {

    // Factory Method
    public abstract Document createDocument();
}

// Factory for Word documents
class WordDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new WordDocument();
    }
}

// Factory for PDF documents
class PdfDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new PdfDocument();
    }
}

// Factory for Excel documents
class ExcelDocumentFactory extends DocumentFactory {

    public Document createDocument() {
        return new ExcelDocument();
    }
}