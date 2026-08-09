interface Product {

    void displayProduct();
    void calculatePrice();
}

class ProductDetails {

    String name;
    double price;

    ProductDetails(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Electronic Product
class Electronic extends ProductDetails implements Product {

    Electronic(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Product Type: Electronic");
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }

    public void calculatePrice() {
        double finalPrice = price + (price * 0.18);
        System.out.println("Final Price with Tax: " + finalPrice);
    }
}

// Clothing Product
class Clothing extends ProductDetails implements Product {

    Clothing(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Product Type: Clothing");
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }

    public void calculatePrice() {
        double finalPrice = price + (price * 0.05);
        System.out.println("Final Price with Tax: " + finalPrice);
    }
}

// Grocery Product
class Grocery extends ProductDetails implements Product {

    Grocery(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Product Type: Grocery");
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }

    public void calculatePrice() {
        double finalPrice = price + (price * 0.02);
        System.out.println("Final Price with Tax: " + finalPrice);
    }
}

public class Exp7b {

    public static void main(String[] args) {

        Electronic e = new Electronic("Laptop", 50000);
        Clothing c = new Clothing("T-Shirt", 1000);
        Grocery g = new Grocery("Rice", 500);

        System.out.println("----- E-Commerce Product System -----");

        e.displayProduct();
        e.calculatePrice();

        System.out.println();

        c.displayProduct();
        c.calculatePrice();

        System.out.println();

        g.displayProduct();
        g.calculatePrice();
    }
}