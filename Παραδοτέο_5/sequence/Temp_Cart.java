public class Temp_Cart {
    private int Pharmacy_Id;
    private double Product_Price;
    private int Product_Id;
    private String Product_Name;
    private int Product_Amount;
    public Temp_Cart(int pharmacy_Id, double product_Price, int product_Id, String product_Name, int product_Amount) {
        Pharmacy_Id = pharmacy_Id;
        Product_Price = product_Price;
        Product_Id = product_Id;
        Product_Name = product_Name;
        Product_Amount = product_Amount;
    }

    public int getPharmacy_Id() {
        return Pharmacy_Id;
    }

    public void setPharmacy_Id(int pharmacy_Id) {
        Pharmacy_Id = pharmacy_Id;
    }

    public double getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(double product_Price) {
        Product_Price = product_Price;
    }

    public int getProduct_Id() {
        return Product_Id;
    }
    public void setProduct_Id(int product_Id) {
        Product_Id = product_Id;
    }
    public String getProduct_Name() {
        return Product_Name;
    }
    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }
    public int getProduct_Amount() {
        return Product_Amount;
    }
    public void setProduct_Amount(int product_Amount) {
        Product_Amount = product_Amount;
    }
}
