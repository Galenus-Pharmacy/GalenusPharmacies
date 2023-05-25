public class Cart {
    double sum;
    Pharmacy_User pUser = new Pharmacy_User();
    Products products = new Products();
    Temp_Cart tempCart = new Temp_Cart();
    public Cart() {}

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

    public Temp_Cart getTempCart() {
        return tempCart;
    }

    public void setTempCart(Temp_Cart tempCart) {
        this.tempCart = tempCart;
    }
}

