import java.util.Scanner;

//Our app
public class Meloman {
    private Scanner input; //Scanner instance for holding the user's input
    private Controller controller; //the instance of Controller class

    //We initialize fields in default constructor
    public Meloman() {
        controller = new Controller();
        input = new Scanner(System.in); // the input will be taken in console (System.in)
    }

    //The main flow and loop of the app
    public void start() {
        while(true) { //infinite loop
            //The main menu of the app
            System.out.println("Welcome to Meloman Shop!");
            System.out.println("1. See the categories of products");
            System.out.println("2. Exit");

            int a = input.nextInt(); //hold input of the user

            if(a == 1) {
                seeProducts(); //call the buyProducts() method
            } else if (a == 2) {
                input.close(); //close the input
                break; //break infinite loop
            }
        }
    }

    // seeProducts() method demonstrates categories, products and processes users purchases
    public void seeProducts() {
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
