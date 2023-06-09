public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store Products
        Products prod = new Products();
        Pharmacy_User pUser = new Pharmacy_User();
        User user = new User();
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
        pUser = new Pharmacy_User(0,"Nikolas","Nikolaos_Pharmacy","Nikolaospharmacy@gmail.com","Riga Feraiou_13",6912457800L,"Nikolas1!");
        es.pharmacyUserList.add(pUser);

        pUser = new Pharmacy_User(1,"Sophie","SophiePharmacy","SophiePharmacy@bing.com","Maizonos105",6900112233L,"SOPhie123");
        es.pharmacyUserList.add(pUser);

        pUser = new Pharmacy_User(2,"Charis", "CharisPharmacy" , "CharisPharmacy@gmail.com","Korinthou123",6910245890L,"Charis12!");
        es.pharmacyUserList.add(pUser);

        pUser = new Pharmacy_User(3,"Paris","ParisPharmacy","ParisPharmacy@yahoo.com","Korinthou2", 6932165478L,"Paris123");
        es.pharmacyUserList.add(pUser);

        prod = new Products(0, 0, "Strepsils", 10, 100, "Neckpain");
        es.productsList.add(prod);

        prod = new Products(0, 1, "Panadol", 2, 1000, "Paracetamol");
        es.productsList.add(prod);

        prod = new Products(1, 1, "Panadol", 2, 1000, "Paracetamol");
        es.productsList.add(prod);

        prod = new Products(2, 2, "Nivea", 2, 1000, "Face Care");
        es.productsList.add(prod);

        prod = new Products(3, 3, "Gilette", 2, 1000, "After Shave");
        es.productsList.add(prod);

        prod = new Products(2, 4, "Depon", 2, 1000, "Paracetamol");
        es.productsList.add(prod);

        user = new User(0, "Charis Pissouros", "CharisPis","CharisPissou@gmail.com","Charis9",6969656510L,"Konstantinoupolews 2");
        es.userList.add(user);

        user = new User(1,"Elias Alevras","AlevrasEl","AlevrasEl@gmail.com","Elias12",6920104571L,"Riga Feraiou 54");
        es.userList.add(user);

        user = new User(2,"Savvas Stylianou","SavvasStyl","SavvasStyl@gmail.com","Savvis45",690012142025L,"Maizonos12");
        es.userList.add(user);

        user = new User(3,"Sotiris Chatzigiannis","SotirisChatz","SotChatz@gmail.com","Sot12345",690012142025L,"Maizonos 35");
        es.userList.add(user);

        menu.showMenu();
    }
}