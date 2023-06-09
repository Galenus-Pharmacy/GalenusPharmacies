public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store Products
        Products prod = new Products();
        Pharmacy_User pUser = new Pharmacy_User();
     //   prod.setProductInfo();
        Premium_User pu = new Premium_User();
        Eshop es = new Eshop();
        Menu menu = new Menu(es);
      /*  System.out.println(prod.productList.get(0).getProduct_id());
        pu.setEmail("a");
        System.out.println(pu.getEmail());

         Pharmacy_User(int pharmacy_ID, String pharmacy_Name, String username, String email, String address, int phone_number, String password)

        System.out.println(pUser.pharmacyUserList.get(0).getEmail());

       */
       // menu.newPharmacyUserInfo();
     //   menu.newPharmacyUserInfo();
       // menu.newProducts();

        //menu.newPharmacyUserInfo();
        //menu.newPharmacyUserInfo();
        //es.showProducts();
        //es.showCategories();
        //System.out.println(es.userList.get(0).getEmail());
        String name = "P", username = "username", email = "1", address = "1", password = "password";
        int id=0, number=3;
        pUser = new Pharmacy_User(id, name, username, email, address, number, password);
        es.pharmacyUserList.add(pUser);
        prod = new Products(0, 0, "strepsils", 10, 100, "neckpain");
        es.productsList.add(prod);
        prod = new Products(0, 1, "panadol", 2, 1000, "paracetamol");
        es.productsList.add(prod);
        menu.showMenu();
    }
}