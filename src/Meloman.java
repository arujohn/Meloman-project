import java.util.Scanner;

public class Meloman {
    private Scanner input;
    private Controller controller;

    public Meloman() {
        controller = new Controller();
        input = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("Welcome to Meloman Shop!");
            System.out.println("1. See the categories of products");
            System.out.println("2. Exit");

            int a = input.nextInt();

            if(a == 1) {
                buyProducts();
            } else if (a == 2) {
                input.close();
                System.exit(0);
            }
        }
    }

    public void buyProducts() {
        controller.displayCategories();
        System.out.println("Enter the number of the category whose products you want to see:");

        int categoryID = input.nextInt();
        controller.displayProductsOfCategory(categoryID);

        System.out.println("\nDo you want ot buy any product? (y or n): ");
        char answer = input.next().charAt(0);

        if(answer == 'y' || answer == 'Y') {
            System.out.println("Enter the ID of the product you want to buy: ");
            int productID = input.nextInt();
            buyProduct(productID);
        } else if (answer == 'n' || answer == 'N'){
            System.out.println("We hope you will like something in the other categories.");
        } else
            System.out.println("Please enter y or n.");
    }

    public void buyProduct(int productID) {
        System.out.println("Please, enter your firstname: ");
        String firstname = input.next();

        System.out.println("Enter your lastname: ");
        String lastname = input.next();

        System.out.println("Enter your phone number: ");
        String phone = input.next();

        controller.buyProduct(productID, firstname, lastname, phone);
        System.out.println("You successfully bought that product");
    }
}
