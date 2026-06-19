// Common interface for all document types
interface Document {
    void open();
}

// Concrete Word document
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word Document");
    }
}

// Concrete PDF document
class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

// Concrete Excel document
class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Document");
    }
}