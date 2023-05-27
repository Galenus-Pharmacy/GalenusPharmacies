public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store Products
        Products prod = new Products();
        Cart cart = new Cart();
        Pharmacy_User pUser = new Pharmacy_User();
     //   prod.setProductInfo();
        Premium_User pu = new Premium_User();
        Eshop es = new Eshop();
        Menu menu = new Menu(es);
      /*  System.out.println(prod.productList.get(0).getProduct_id());
        pu.setEmail("a");
        System.out.println(pu.getEmail());


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

        menu.showMenu();
    }
}