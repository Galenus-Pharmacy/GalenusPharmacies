public class Cart {
    private int Pharmacy_Id;
    private int User_ID;
    private double sum;

    public Cart(){};
    public Cart(int pharmacy_Id, int user_ID, double sum) {
        Pharmacy_Id = pharmacy_Id;
        User_ID = user_ID;
        this.sum = sum;
    }
    public int getPharmacy_Id() {
        return Pharmacy_Id;
    }
    public void setPharmacy_Id(int pharmacy_Id) {
        Pharmacy_Id = pharmacy_Id;
    }
    public int getUser_ID() {
        return User_ID;
    }
    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}

