class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class Exercise02EcommerceSearch {

    static int linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    static int binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products[mid].productName.compareToIgnoreCase(name);

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

        Product[] products = {
            new Product(101, "Keyboard", "Electronics"),
            new Product(102, "Laptop", "Electronics"),
            new Product(103, "Mouse", "Electronics"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Speaker", "Electronics")
        };

        int index1 = linearSearch(products, "Mouse");
        if (index1 != -1)
            System.out.println("Linear Search: " + products[index1].productName + " Found");
        else
            System.out.println("Product Not Found");

        int index2 = binarySearch(products, "Mouse");
        if (index2 != -1)
            System.out.println("Binary Search: " + products[index2].productName + " Found");
        else
            System.out.println("Product Not Found");
    }
}