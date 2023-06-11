public class Cart {
    private int Product_ID;
    private int Pharmacy_ID;
    private int Product_Amount;
    private double price;
    private int User_ID;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int product_ID) {
        Product_ID = product_ID;
    }

    public int getPharmacy_ID() {
        return Pharmacy_ID;
    }

    public void setPharmacy_ID(int pharmacy_ID) {
        Pharmacy_ID = pharmacy_ID;
    }

    public int getProduct_Amount() {
        return Product_Amount;
    }

    public void setProduct_Amount(int product_Amount) {
        Product_Amount = product_Amount;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public Cart(){}

    public Cart(int product_ID, int pharmacy_ID, int product_Amount, int user_ID, double price) {
        Product_ID = product_ID;
        Pharmacy_ID = pharmacy_ID;
        Product_Amount = product_Amount;
        User_ID = user_ID;
        this.price = price;
    }
}