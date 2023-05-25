public class Inventory {
    private int Pharmacy_Id;
    private String Pharmacy_Name;
    private int Product_Id;
    private int Product_Amount;

    public Inventory(int pharmacy_Id, String pharmacy_Name, int product_Id, int product_Amount) {
        Pharmacy_Id = pharmacy_Id;
        Pharmacy_Name = pharmacy_Name;
        Product_Id = product_Id;
        Product_Amount = product_Amount;
    }

    public int getPharmacy_Id() {
        return Pharmacy_Id;
    }

    public void setPharmacy_Id(int pharmacy_Id) {
        Pharmacy_Id = pharmacy_Id;
    }

    public String getPharmacy_Name() {
        return Pharmacy_Name;
    }

    public void setPharmacy_Name(String pharmacy_Name) {
        Pharmacy_Name = pharmacy_Name;
    }

    public int getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(int product_Id) {
        Product_Id = product_Id;
    }

    public int getProduct_Amount() {
        return Product_Amount;
    }

    public void setProduct_Amount(int product_Amount) {
        Product_Amount = product_Amount;
    }

}
