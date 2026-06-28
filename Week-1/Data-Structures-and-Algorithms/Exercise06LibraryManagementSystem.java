class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class Exercise06LibraryManagementSystem {

    static int linearSearch(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(title))
                return i;
        }
        return -1;
    }

    static int binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0)
                return mid;
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Book[] books = {
            new Book(101, "C Programming", "Dennis Ritchie"),
            new Book(102, "Data Structures", "Mark Allen"),
            new Book(103, "Java", "James Gosling"),
            new Book(104, "Python", "Guido van Rossum"),
            new Book(105, "SQL", "Chris Fehily")
        };

        int index1 = linearSearch(books, "Java");
        if (index1 != -1)
            System.out.println("Linear Search: " + books[index1].title + " Found");
        else
            System.out.println("Book Not Found");

        int index2 = binarySearch(books, "Java");
        if (index2 != -1)
            System.out.println("Binary Search: " + books[index2].title + " Found");
        else
            System.out.println("Book Not Found");
    }
}