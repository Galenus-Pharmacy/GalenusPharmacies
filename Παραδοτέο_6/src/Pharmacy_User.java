public class Pharmacy_User {

    private int pharmacy_ID = 0;
    private String pharmacy_Name;
    private String username;
    private String email;
    private String address;
    private long phone_number;
    private String password;

    public Pharmacy_User() {}

    public Pharmacy_User(int pharmacy_ID, String pharmacy_Name, String username, String email, String address, long phone_number, String password) {
        this.pharmacy_ID = pharmacy_ID;
        this.pharmacy_Name = pharmacy_Name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
    }

    public int getPharmacy_ID() {
        return pharmacy_ID;
    }

    public void setPharmacy_ID(int pharmacy_ID) {
        this.pharmacy_ID = pharmacy_ID;
    }

    public String getPharmacy_Name() {
        return pharmacy_Name;
    }

    public void setPharmacy_Name(String pharmacy_Name) {
        this.pharmacy_Name = pharmacy_Name;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}