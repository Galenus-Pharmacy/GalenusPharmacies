public class Temp_Cart {
    double sum;
    Pharmacy_User pUser = new Pharmacy_User();
    Products products = new Products();

    public Temp_Cart() {}

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Pharmacy_User getpUser() {
        return pUser;
    }

    public void setpUser(Pharmacy_User pUser) {
        this.pUser = pUser;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

}