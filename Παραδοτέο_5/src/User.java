import java.util.Scanner;
public class User {
    private int User_ID;
    private String Fullname;
    private String Username, Email,Password ,Phone_number ,Address  ;
    private int ESY_code;
    public User(){};
    /*** SETTERS AND GETTERS */
    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getESY_code() {
        return ESY_code;
    }

    public void setESY_code(int ESY_code) {
        this.ESY_code = ESY_code;
    }

    /*** CONTSTRUCTOR */
    public User(int user_ID, String fullname, String username, String email, String password, String phone_number, String address, int ESY_code) {
        User_ID = user_ID;
        Fullname = fullname;
        Username = username;
        Email = email;
        Password = password;
        Phone_number = phone_number;
        Address = address;
        this.ESY_code = ESY_code;
    }






    void new_account(){
        System.out.println("sign In /n");
        System.out.println("sign Up /n");
        Scanner userS = new Scanner(System.in);
        String users ;
        users = userS.nextLine();
        if(users == "sign In"){
            Scanner uname = new Scanner(System.in);
            Scanner upass = new Scanner(System.in);
            String usname , uspass;
            usname= uname.nextLine();
            uspass= upass.nextLine();

        }



    }

}