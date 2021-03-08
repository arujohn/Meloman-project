public interface IDatabase {
    void displayCategories();
    void displayProductsOfCategory(int categoryID);
    void buyProduct(int productID, String firstname, String lastname, String phone);
}
