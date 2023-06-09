public class Favorite {
    private int Product_ID;
    private int User_ID;
    private int Pharmacy_ID;

    public Favorite() {}

    public Favorite(int product_ID, int user_ID, int pharmacy_ID) {
        Product_ID = product_ID;
        User_ID = user_ID;
        Pharmacy_ID = pharmacy_ID;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int product_ID) {
        Product_ID = product_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getPharmacy_ID() {
        return Pharmacy_ID;
    }

    public void setPharmacy_ID(int pharmacy_ID) {
        Pharmacy_ID = pharmacy_ID;
    }
}
