import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Eshop eshop;
    Pharmacy_User pharmacyUser;
    Products product;
    User user;
    private int pharmacy_ID = 0, user_ID = 0, product_ID = 0;

    public int getPharmacy_ID() {
        return pharmacy_ID;
    }

    public void setPharmacy_ID(int pharmacy_ID) {
        this.pharmacy_ID = pharmacy_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getUserInfo(String username, String password) {

        for (Pharmacy_User pharmacyUserE : eshop.pharmacyUserList) {
            if (pharmacyUserE.getUsername().equals(username) && pharmacyUserE.getPassword().equals(password)) {
                int pharmacyID = pharmacyUserE.getPharmacy_ID();
                String pharmacyName = pharmacyUserE.getPharmacy_Name();
                String pharmacyEmail = pharmacyUserE.getEmail();
                String pharmacyAddress = pharmacyUserE.getAddress();
                long pharmacyPhone = pharmacyUserE.getPhone_number();
                pharmacyUser = new Pharmacy_User(pharmacyID, pharmacyName, username, pharmacyEmail, pharmacyAddress, pharmacyPhone, password);
                return 1;
            }
        }

        for (User userE : eshop.userList) {
            if (userE.getUsername().equals(username) && userE.getPassword().equals(password)) {
                int ID = userE.getUser_ID();
                String name = userE.getFullname();
                String email = userE.getEmail();
                String address = userE.getAddress();
                long phone = userE.getPhone_number();
                user = new User(ID, name, username, email, password, phone, address);
                return 2;
            }
        }
        return 0;
    }

    public void newPharmacyUserInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creating your pharmacy account...");
        System.out.println("Give your pharmacy name:");
        String name = scan.nextLine();
        System.out.println("Give your email:");
        String email = scan.nextLine();
        System.out.println("Give your address");
        String address = scan.nextLine();
        System.out.println("Give your Phone Number:");
        long phone_number = scan.nextLong();
        scan.nextLine();
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        pharmacyUser = new Pharmacy_User(this.pharmacy_ID, name, username, email, address, phone_number, password);
        eshop.addPharmacyUser(pharmacyUser);
        this.pharmacy_ID++;
    }

    public void newUserInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creating your account...");
        System.out.println("Give your full name:");
        String fullname = scan.nextLine();
        System.out.println("Give your email:");
        String email = scan.nextLine();
        System.out.println("Give your address");
        String address = scan.nextLine();
        System.out.println("Give your Phone Number:");
        long phone_number = scan.nextLong();
        scan.nextLine();
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        user = new User(this.user_ID, fullname, username, email, password, phone_number, address);
        eshop.addUser(user);
        this.user_ID++;
    }

    public Menu(Eshop eshop) {
        this.eshop = eshop;
    }

    public void newProducts() {
        Scanner scanner = new Scanner(System.in);
        int productCount;
        boolean flag = false;
        System.out.print("Enter the number of products you want to add: ");
        productCount = scanner.nextInt();
        scanner.nextLine();
        List<Products> newProductsList = new ArrayList<>();

        for (int i = 0; i < productCount; i++) {
            System.out.println("Enter details for the (" + (i+1) + ") product you want to add:");
            System.out.print("Product Name:");
            String productName = scanner.nextLine();
            System.out.print("Product Price:");
            double productPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Product Amount:");
            int productAmount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Product category:");
            String productCategory = scanner.nextLine();
            flag = false;
            for (Products products : eshop.productsList) {
                if (productName.equals(products.getProduct_Name())) {
                    product = new Products(pharmacyUser.getPharmacy_ID(), products.getProduct_id(), productName, productPrice, productAmount, productCategory);
                    flag = true;
                }
            }
            if (!flag) {
                product = new Products(pharmacyUser.getPharmacy_ID(), this.product_ID, productName, productPrice, productAmount, productCategory);
                this.product_ID++;
            }
            newProductsList.add(product);
            flag  = false;
        }
        eshop.productsList.addAll(newProductsList);
    }


    public void showMenu() {
        boolean flag = false, back = false;
        Scanner scan = new Scanner(System.in);
        int sign = 0;
        while (sign != 1 && sign != 2) {
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("Choose an option: (Give number)");
            sign = scan.nextInt();
            scan.nextLine();
            if (sign != 1 && sign != 2)
                System.out.println("Choose a valid option");
        }

        if (sign == 1) {
            String username, password;
            System.out.print("Username:");
            username = scan.nextLine();
            System.out.print("Password:");
            password = scan.nextLine();
            int acc = getUserInfo(username, password);
            if (acc == 1) {
                while (flag == false) {
                    System.out.println("Welcome " + pharmacyUser.getPharmacy_Name() + " to Galenus Pharmacy");
                    System.out.println("-------------------------------");
                    System.out.println("1.Search or Show categories");
                    System.out.println("2.Add product");
                    System.out.println("3.Profile");
                    System.out.println("4.Show history order");
                    System.out.println("5.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int insert;
                    insert = scan.nextInt();
                    switch (insert) {
                        case 1:
                            back = false;
                            int search ;
                                while (back == false) {
                                    System.out.println("1. Search");
                                    System.out.println("2. Show categories");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int case1 = scan.nextInt();
                                    scan.nextLine();
                                    if (case1 == 1){
                                        eshop.search();
                                    }
                                    else if (case1 == 2){
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in: (Give Name)");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back:");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the product you are interested in: (Give Name)");
                                            String product = scan.nextLine();
                                            System.out.println();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1)
                                                back = true;
                                        }

                                            else if (check == 2)
                                                back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                  }
                                    else if (case1 == 3)
                                        back = true;
                                }
                            break;

                        case 2:
                            back = false;
                            System.out.println("1. Add products");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                newProducts();
                                System.out.println("Products added to your phamacy!");
                                System.out.println();
                                back = true;
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showPharmacyProfile(pharmacyUser.getPharmacy_ID());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email, Username)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setPharmacy_Name(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setAddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setPhone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setEmail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String name = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setUsername(name);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1.Sales History");
                            System.out.println("2.Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.OrderHistory(pharmacyUser.getPharmacy_ID());
                                    System.out.println("1. Go Back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            flag = true;
                            break;
                    }


                }
                flag = true;
            } else if (acc == 2) {
                while (flag == false) {
                    System.out.println();
                    System.out.println("Welcome " + user.getFullname() + " to Galenus Pharmacy");
                    System.out.println("------------------------");
                    System.out.println("1.Search categories");
                    System.out.println("2.Show categories");
                    System.out.println("3.Favorites");
                    System.out.println("4.Shopping Cart");
                    System.out.println("5.Profile");
                    System.out.println("6.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int eisodos;
                    Scanner eis = new Scanner(System.in);
                    eisodos = eis.nextInt();

                    switch (eisodos) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Go back");
                                System.out.println();
                                System.out.println("Choose an option (Give number)");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    eshop.search();
                                }
                                else if (case1 == 2)
                                    back = true;
                            }
                            break;
                        case 2:
                            back = false;
                            System.out.println("1. Show categories");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int  check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        System.out.println("Give the category you are interested in: (Give name)");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1) {
                                            System.out.println("Give the product you are interested in: (Give name)");
                                            String product = scan.nextLine();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Add Product to Favorites");
                                            System.out.println("2. Add Product to Shopping Cart");
                                            System.out.println("3. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1) {
                                                System.out.println("Give the name of the pharmacy you want to add the product to favorites from:");
                                                String pharm = scan.nextLine();
                                                eshop.addToFavorites(product, user.getUser_ID(), pharm);
                                                System.out.println("Product added to favorites.");
                                                eshop.showUserFavorites(user.getUser_ID());
                                                back = true;
                                            }
                                            if (c == 2) {
                                                System.out.println("Give the name of the pharmacy you want to buy the product from:");
                                                String pharm = scan.nextLine();
                                                System.out.println("Give the amount of " + product + " you want to add to your shopping cart:");
                                                int amount = scan.nextInt();
                                                scan.nextLine();
                                                eshop.addToShoppingCart(product, user.getUser_ID(), pharm, amount);
                                                System.out.println("Product added to shopping cart.");
                                                eshop.showShoppingCart(user.getUser_ID());
                                                System.out.println("Do you want to complete your order?");
                                                System.out.println("1. Yes.");
                                                System.out.println("2. No.");
                                                c = scan.nextInt();
                                                scan.nextLine();
                                                if (c == 1) {
                                                    eshop.OrderProducts(user.getUser_ID());
                                                    back = true;
                                                }
                                                back = true;
                                            }
                                            if (c == 3)
                                                back = true;
                                        } else if (check == 2)
                                            back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;
                        case 3:
                            back = false;
                            System.out.println("1. Favorite products");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showUserFavorites(user.getUser_ID());
                                    System.out.println("1. Remove a product from Favorite List");
                                    System.out.println("2. Remove all products from Favorite List");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String pharm = scan.nextLine();
                                        int pharmacyId = -1;
                                        int productId = -1;
                                        for (Pharmacy_User pharmacyy : eshop.pharmacyUserList){
                                            if (pharmacyy.getPharmacy_Name().equals(pharm))
                                                pharmacyId = pharmacyy.getPharmacy_ID();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Favorite> removeProductFromFavorite = new ArrayList<>();

                                        for (Favorite favor1 : eshop.favoriteList) {
                                            if (user.getUser_ID() == favor1.getUser_ID() && favor1.getPharmacy_ID() == pharmacyId) {
                                                for (Products prods : eshop.productsList) {
                                                    if (prods.getProduct_Name().equals(prod) && prods.getPharmacy_ID() == pharmacyId) {
                                                        productId = prods.getProduct_id();
                                                    }
                                                }
                                                if (favor1.getProduct_ID() == productId) {
                                                    removeProductFromFavorite.add(favor1);
                                                }
                                            }
                                        }

                                        eshop.favoriteList.removeAll(removeProductFromFavorite);
                                    }
                                    if (check == 2){
                                        List<Favorite> removeUserFavorites = new ArrayList<>();
                                        for (Favorite fav : eshop.favoriteList) {
                                            if (user.getUser_ID() == fav.getUser_ID()) {
                                                removeUserFavorites.add(fav);
                                            }
                                        }
                                        eshop.favoriteList.removeAll(removeUserFavorites);
                                    }
                                    if (check == 3) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 4:
                            back = false;
                            System.out.println("1. Shopping Cart");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showShoppingCart(user.getUser_ID());
                                    System.out.println("1. Complete Order");
                                    System.out.println("2. Remove a product from shopping cart");
                                    System.out.println("3. Remove all products from shopping cart");
                                    System.out.println("4. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1)
                                        eshop.OrderProducts(user.getUser_ID());
                                    if (check == 2){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String pharm = scan.nextLine();
                                        int pharmacyId = -1;
                                        int productId = -1;
                                        for (Pharmacy_User pharmacyy : eshop.pharmacyUserList){
                                            if (pharmacyy.getPharmacy_Name().equals(pharm))
                                                pharmacyId = pharmacyy.getPharmacy_ID();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Cart> removeProductFromCart = new ArrayList<>();

                                        for (Cart cartt : eshop.cartList) {
                                            if (user.getUser_ID() == cartt.getUser_ID() && cartt.getPharmacy_ID() == pharmacyId) {
                                                for (Products prods : eshop.productsList) {
                                                    if (prods.getProduct_Name().equals(prod) && prods.getPharmacy_ID() == pharmacyId) {
                                                        productId = prods.getProduct_id();
                                                    }
                                                }
                                                if (cartt.getProduct_ID() == productId) {
                                                    removeProductFromCart.add(cartt);
                                                }
                                            }
                                        }

                                        eshop.cartList.removeAll(removeProductFromCart);
                                    }
                                    if (check == 3){
                                        List<Cart> removeProductFromCart = new ArrayList<>();
                                        for (Cart carttt : eshop.cartList) {
                                            if (user.getUser_ID() == carttt.getUser_ID()) {
                                                removeProductFromCart.add(carttt);
                                            }
                                        }
                                        eshop.cartList.removeAll(removeProductFromCart);
                                    }

                                    if (check == 4) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showUserProfile(user.getUser_ID());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println("Choose an option (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email, Username)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setFullname(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (User userr : eshop.userList) {
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setAddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setPhone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setEmail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String name = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setUsername(name);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 6:
                            flag = true;
                            break;
                    }
                }
            }
        } else if (sign == 2) {
            int creatingAccount = 0;
            while (creatingAccount != 1 && creatingAccount != 2) {
                System.out.println("1. Create a pharmacy account.");
                System.out.println("2. Create a buyer account");
                creatingAccount = scan.nextInt();
                scan.nextLine();
                if (creatingAccount != 1 && creatingAccount != 2)
                    System.out.println("Choose a valid option");
            }
            if (creatingAccount == 1) {
                //return object Pharmacy user?
                newPharmacyUserInfo();
                while (flag == false) {
                    System.out.println("Welcome " + pharmacyUser.getPharmacy_Name() + " to Galenus Pharmacy");
                    System.out.println("-------------------------------");
                    System.out.println("1.Search or Show categories");
                    System.out.println("2.Add product");
                    System.out.println("3.Profile");
                    System.out.println("4.Show history order");
                    System.out.println("5.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int insert;
                    insert = scan.nextInt();
                    switch (insert) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Show categories");
                                System.out.println("3. Go back");
                                System.out.println();
                                System.out.println("Choose an option: (Give number)");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    eshop.search();
                                }
                                else if (case1 == 2){
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in: (Give Name)");
                                        String category = scan.nextLine();
                                        System.out.println();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back:");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the product you are interested in: (Give Name)");
                                            String product = scan.nextLine();
                                            System.out.println();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1)
                                                back = true;
                                        }

                                        else if (check == 2)
                                            back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                                else if (case1 == 3)
                                    back = true;
                            }
                            break;

                        case 2:
                            back = false;
                            System.out.println("1. Add products");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                newProducts();
                                System.out.println("Products added to your phamacy!");
                                System.out.println();
                                back = true;
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showPharmacyProfile(pharmacyUser.getPharmacy_ID());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email, Username)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setPharmacy_Name(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setAddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setPhone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setEmail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String name = scan.nextLine();
                                            for (Pharmacy_User puserr : eshop.pharmacyUserList ){
                                                if (puserr.getPharmacy_ID() == pharmacyUser.getPharmacy_ID())
                                                    puserr.setUsername(name);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1.Sales History");
                            System.out.println("2.Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.OrderHistory(pharmacyUser.getPharmacy_ID());
                                    System.out.println("1. Go Back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            flag = true;
                            break;
                    }


                }
                flag = true;
            }
            else if (creatingAccount == 2) {
                newUserInfo();
                while (flag == false) {
                    System.out.println();
                    System.out.println("Welcome " + user.getFullname() + " to Galenus Pharmacy");
                    System.out.println("------------------------");
                    System.out.println("1.Search categories");
                    System.out.println("2.Show categories");
                    System.out.println("3.Favorites");
                    System.out.println("4.Shopping Cart");
                    System.out.println("5.Profile");
                    System.out.println("6.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int eisodos;
                    Scanner eis = new Scanner(System.in);
                    eisodos = eis.nextInt();

                    switch (eisodos) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Go back");
                                System.out.println();
                                System.out.println("Choose an option (Give number)");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    eshop.search();
                                }
                                else if (case1 == 2)
                                    back = true;
                            }
                            break;
                        case 2:
                            back = false;
                            System.out.println("1. Show categories");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int  check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        System.out.println("Give the category you are interested in: (Give name)");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1) {
                                            System.out.println("Give the product you are interested in: (Give name)");
                                            String product = scan.nextLine();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Add Product to Favorites");
                                            System.out.println("2. Add Product to Shopping Cart");
                                            System.out.println("3. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1) {
                                                System.out.println("Give the name of the pharmacy you want to add the product to favorites from:");
                                                String pharm = scan.nextLine();
                                                eshop.addToFavorites(product, user.getUser_ID(), pharm);
                                                System.out.println("Product added to favorites.");
                                                eshop.showUserFavorites(user.getUser_ID());
                                                back = true;
                                            }
                                            if (c == 2) {
                                                System.out.println("Give the name of the pharmacy you want to buy the product from:");
                                                String pharm = scan.nextLine();
                                                System.out.println("Give the amount of " + product + " you want to add to your shopping cart:");
                                                int amount = scan.nextInt();
                                                scan.nextLine();
                                                eshop.addToShoppingCart(product, user.getUser_ID(), pharm, amount);
                                                System.out.println("Product added to shopping cart.");
                                                eshop.showShoppingCart(user.getUser_ID());
                                                System.out.println("Do you want to complete your order?");
                                                System.out.println("1. Yes.");
                                                System.out.println("2. No.");
                                                c = scan.nextInt();
                                                scan.nextLine();
                                                if (c == 1) {
                                                    eshop.OrderProducts(user.getUser_ID());
                                                    back = true;
                                                }
                                                back = true;
                                            }
                                            if (c == 3)
                                                back = true;
                                        } else if (check == 2)
                                            back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;
                        case 3:
                            back = false;
                            System.out.println("1. Favorite products");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showUserFavorites(user.getUser_ID());
                                    System.out.println("1. Remove a product from Favorite List");
                                    System.out.println("2. Remove all products from Favorite List");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String pharm = scan.nextLine();
                                        int pharmacyId = -1;
                                        int productId = -1;
                                        for (Pharmacy_User pharmacyy : eshop.pharmacyUserList){
                                            if (pharmacyy.getPharmacy_Name().equals(pharm))
                                                pharmacyId = pharmacyy.getPharmacy_ID();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Favorite> removeProductFromFavorite = new ArrayList<>();

                                        for (Favorite favor1 : eshop.favoriteList) {
                                            if (user.getUser_ID() == favor1.getUser_ID() && favor1.getPharmacy_ID() == pharmacyId) {
                                                for (Products prods : eshop.productsList) {
                                                    if (prods.getProduct_Name().equals(prod) && prods.getPharmacy_ID() == pharmacyId) {
                                                        productId = prods.getProduct_id();
                                                    }
                                                }
                                                if (favor1.getProduct_ID() == productId) {
                                                    removeProductFromFavorite.add(favor1);
                                                }
                                            }
                                        }

                                        eshop.favoriteList.removeAll(removeProductFromFavorite);
                                    }
                                    if (check == 2){
                                        List<Favorite> removeUserFavorites = new ArrayList<>();
                                        for (Favorite fav : eshop.favoriteList) {
                                            if (user.getUser_ID() == fav.getUser_ID()) {
                                                removeUserFavorites.add(fav);
                                            }
                                        }
                                        eshop.favoriteList.removeAll(removeUserFavorites);
                                    }
                                    if (check == 3) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1. Shopping Cart");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showShoppingCart(user.getUser_ID());
                                    System.out.println("1. Complete Order");
                                    System.out.println("2. Remove a product from shopping cart");
                                    System.out.println("3. Remove all products from shopping cart");
                                    System.out.println("4. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1)
                                        eshop.OrderProducts(user.getUser_ID());
                                    if (check == 2){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String pharm = scan.nextLine();
                                        int pharmacyId = -1;
                                        int productId = -1;
                                        for (Pharmacy_User pharmacyy : eshop.pharmacyUserList){
                                            if (pharmacyy.getPharmacy_Name().equals(pharm))
                                                pharmacyId = pharmacyy.getPharmacy_ID();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Cart> removeProductFromCart = new ArrayList<>();

                                        for (Cart cartt : eshop.cartList) {
                                            if (user.getUser_ID() == cartt.getUser_ID() && cartt.getPharmacy_ID() == pharmacyId) {
                                                for (Products prods : eshop.productsList) {
                                                    if (prods.getProduct_Name().equals(prod) && prods.getPharmacy_ID() == pharmacyId) {
                                                        productId = prods.getProduct_id();
                                                    }
                                                }
                                                if (cartt.getProduct_ID() == productId) {
                                                    removeProductFromCart.add(cartt);
                                                }
                                            }
                                        }

                                        eshop.cartList.removeAll(removeProductFromCart);
                                    }
                                    if (check == 3){
                                        List<Cart> removeProductFromCart = new ArrayList<>();
                                        for (Cart carttt : eshop.cartList) {
                                            if (user.getUser_ID() == carttt.getUser_ID()) {
                                                removeProductFromCart.add(carttt);
                                            }
                                        }
                                        eshop.cartList.removeAll(removeProductFromCart);
                                    }

                                    if (check == 4) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showUserProfile(user.getUser_ID());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println("Choose an option (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email, Username)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setFullname(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (User userr : eshop.userList) {
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setAddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setPhone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setEmail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String name = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setUsername(name);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 6:
                            flag = true;
                            break;
                    }
                }
            }
        }
    }

}
