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
        int pharmacyId = 0;
        int productId = 0;
        int userId = 0;
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
        pUser = new Pharmacy_User(pharmacyId,"Nikolas","Nikolaos_Pharmacy","Nikolaospharmacy@gmail.com","Riga Feraiou_13",6912457800L,"Nikolas1!");
        es.pharmacyUserList.add(pUser);
        pharmacyId++;
        menu.setPharmacy_ID(pharmacyId);

        pUser = new Pharmacy_User(pharmacyId,"Sophie","SophiePharmacy","SophiePharmacy@bing.com","Maizonos105",6900112233L,"SOPhie123");
        es.pharmacyUserList.add(pUser);
        pharmacyId++;
        menu.setPharmacy_ID(pharmacyId);

        pUser = new Pharmacy_User(pharmacyId,"Charis", "CharisPharmacy" , "CharisPharmacy@gmail.com","Korinthou123",6910245890L,"Charis12!");
        es.pharmacyUserList.add(pUser);
        pharmacyId++;
        menu.setPharmacy_ID(pharmacyId);

        pUser = new Pharmacy_User(pharmacyId,"Paris","ParisPharmacy","ParisPharmacy@yahoo.com","Korinthou2", 6932165478L,"Paris123");
        es.pharmacyUserList.add(pUser);
        pharmacyId++;
        menu.setPharmacy_ID(pharmacyId);

        prod = new Products(0, productId, "Strepsils", 10, 100, "Neckpain");
        es.productsList.add(prod);
        productId++;
        menu.setProduct_ID(productId);

        prod = new Products(0, productId, "Panadol", 2, 1000, "Paracetamol");
        es.productsList.add(prod);
        productId++;
        menu.setProduct_ID(productId);


        prod = new Products(1, productId, "Panadol", 2, 1000, "Paracetamol");
        es.productsList.add(prod);
        productId++;
        menu.setProduct_ID(productId);

        prod = new Products(2, productId, "Nivea", 2, 1000, "Face Care");
        es.productsList.add(prod);
        productId++;
        menu.setProduct_ID(productId);

        prod = new Products(3, productId, "Gilette", 2, 1000, "After Shave");
        es.productsList.add(prod);
        productId++;
        menu.setProduct_ID(productId);

        prod = new Products(2, productId, "Depon", 2, 1000, "Paracetamol");
        es.productsList.add(prod);
        productId++;
        menu.setProduct_ID(productId);

        user = new User(userId, "Charis Pissouros", "CharisPis","CharisPissou@gmail.com","Charis9",6969656510L,"Konstantinoupolews 2");
        es.userList.add(user);
        userId++;
        menu.setUser_ID(userId);

        user = new User(userId,"Elias Alevras","AlevrasEl","AlevrasEl@gmail.com","Elias12",6920104571L,"Riga Feraiou 54");
        es.userList.add(user);
        userId++;
        menu.setUser_ID(userId);

        user = new User(userId,"Savvas Stylianou","SavvasStyl","SavvasStyl@gmail.com","Savvis45",690012142025L,"Maizonos12");
        es.userList.add(user);
        userId++;
        menu.setUser_ID(userId);

        user = new User(userId,"Sotiris Chatzigiannis","SotirisChatz","SotChatz@gmail.com","Sot12345",690012142025L,"Maizonos 35");
        es.userList.add(user);
        userId++;
        menu.setUser_ID(userId);

        menu.showMenu();
    }
}