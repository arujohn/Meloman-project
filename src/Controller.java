public class Controller {
    private final Database database;

    public Controller() {
        database = new Database();
    }

    public void displayCategories() {
        database.displayCategories();
    }

    public void displayProductsOfCategory(int categoryID) {
        database.displayProductsOfCategory(categoryID);
    }

    public void buyProduct(int productID, String firstName, String lastName, String phone) {
        database.buyProduct(productID, firstName, lastName, phone);
    }
}
