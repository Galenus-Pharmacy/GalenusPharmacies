import java.util.Scanner;

public class Menu {
    Eshop eshop;
    Pharmacy_User pharmacyUser;
    Products product;
    User user;
    private int pharmacy_ID = 0, user_ID = 0, product_ID = 0;

    public int getUserInfo(String username,String password) {

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
            eshop.addProducts(product);
            flag  = false;
        }
    }


    public void showMenu() {
        boolean flag = false, back = false;
        Scanner scan = new Scanner(System.in);
        int sign = 0;
        while (sign != 1 && sign != 2) {
            System.out.println("1 Sign in");
            System.out.println("2. Sign up");
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
                                    int case1 = scan.nextInt();
                                    scan.nextLine();
                                    if (case1 == 1){
                                        eshop.search();
                                    }
                                    else if (case1 == 2){
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in:");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back:");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the product you are interested in:");
                                            String product = scan.nextLine();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Go back");
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
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                newProducts();
                                System.out.println();
                                System.out.println("Products added to your phamacy!");
                                System.out.println();
                                back = true;
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    System.out.print("Pharmacy ID: " + pharmacyUser.getPharmacy_ID());
                                    System.out.println();
                                    System.out.print("Pharmacy Name: " + pharmacyUser.getPharmacy_Name());
                                    System.out.println();
                                    System.out.print("Address: " + pharmacyUser.getAddress());
                                    System.out.println();
                                    System.out.print("Phone number: " + pharmacyUser.getPhone_number());
                                    System.out.println();
                                    System.out.print("Email: " + pharmacyUser.getEmail());
                                    System.out.println();
                                    System.out.print("Username: " + pharmacyUser.getUsername());
                                    System.out.println();
                                    System.out.println("1. Go Back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1.Sales History");
                            System.out.println("2.Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    // getOrderHistory;
                                    System.out.println();
                                    System.out.println("1. Go Back");
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
                    System.out.println("Welcome " + user.getFullname() + " to Galenus Pharmacy");
                    System.out.println("------------------------");
                    System.out.println("1.Search or Show categories");
                    System.out.println("2.Favorites");
                    System.out.println("3.Products category");
                    System.out.println("4.Profile");
                    System.out.println("5.Exit");
                    int eisodos;
                    Scanner eis = new Scanner(System.in);
                    eisodos = eis.nextInt();

                    switch (eisodos) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Show categories");
                                System.out.println("3. Go back");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    eshop.search();
                                }
                                else if (case1 == 2){
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in:");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the product you are interested in:");
                                            String product = scan.nextLine();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Add Product to Favorites");
                                            System.out.println("2. Add Product to Shopping Cart");
                                            System.out.println("3. Go back");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1){
                                                System.out.println("Give the name of the pharmacy you want to add the product to favorites from:");
                                                String pharm = scan.nextLine();
                                                eshop.addToFavorites(product,user.getUser_ID(),pharm);
                                                System.out.println("Product added to favorites.");
                                                eshop.showUserFavorites(user.getUser_ID());
                                                back = true;
                                            }
                                            if (c == 2){
                                                System.out.println("Give the name of the pharmacy you want to buy the product from:");
                                                String pharm = scan.nextLine();
                                                System.out.println("Give the amount of " + product + " you want to add to your shopping cart:");
                                                int amount = scan.nextInt();
                                                scan.nextLine();
                                                eshop.addToShoppingCart(product, user.getUser_ID(),pharm, amount);
                                                System.out.println("Product added to shopping cart.");
                                                back = true;
                                            }
                                            if (c == 3)
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
                            System.out.println("1. Favorite products");
                            System.out.println("Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    // eshop.showFavorites();
                                    System.out.println("1. Continue searching");
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. Show categories");
                            System.out.println("Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showCategories();
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 4:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    System.out.print("ID: " + user.getUser_ID());
                                    System.out.println();
                                    System.out.print("Name: " + user.getFullname());
                                    System.out.println();
                                    System.out.print("Address: " + user.getAddress());
                                    System.out.println();
                                    System.out.print("Phone number: " + user.getPhone_number());
                                    System.out.println();
                                    System.out.print("Email: " + user.getEmail());
                                    System.out.println();
                                    System.out.print("Username: " + user.getUsername());
                                    System.out.println();
                                    System.out.println("1. Go Back");
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
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    eshop.search();
                                }
                                else if (case1 == 2){
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in:");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back:");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the product you are interested in:");
                                            String product = scan.nextLine();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Go back");
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
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                newProducts();
                                System.out.println();
                                System.out.println("Products added to your phamacy!");
                                System.out.println();
                                back = true;
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    System.out.print("Pharmacy ID: " + pharmacyUser.getPharmacy_ID());
                                    System.out.print("Pharmacy Name: " + pharmacyUser.getPharmacy_Name());
                                    System.out.print("Address: " + pharmacyUser.getAddress());
                                    System.out.print("Phone number: " + pharmacyUser.getPhone_number());
                                    System.out.print("Email: " + pharmacyUser.getEmail());
                                    System.out.print("Username: " + pharmacyUser.getUsername());
                                    System.out.println("1. Go Back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1.Sales History");
                            System.out.println("2.Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    // getOrderHistory;
                                    System.out.println();
                                    System.out.println("1. Go Back");
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
                //menu for the User
                newUserInfo();
                while (flag == false) {
                    System.out.println("Welcome " + user.getFullname() + " to Galenus Pharmacy");
                    System.out.println("------------------------");
                    System.out.println("1.Search or Show categories");
                    System.out.println("2.Favorites");
                    System.out.println("3.Products category");
                    System.out.println("4.Profile");
                    System.out.println("5.Exit");
                    int eisodos;
                    Scanner eis = new Scanner(System.in);
                    eisodos = eis.nextInt();

                    switch (eisodos) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Show categories");
                                System.out.println("3. Go back");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    eshop.search();
                                }
                                else if (case1 == 2){
                                    eshop.showCategories();
                                    System.out.println("1. Find products for a category");
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in:");
                                        String category = scan.nextLine();
                                        eshop.showCategoryProducts(category);
                                        System.out.println("1. Get info for a product");
                                        System.out.println("2. Go back");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the product you are interested in:");
                                            String product = scan.nextLine();
                                            eshop.showProductInfo(product);
                                            System.out.println("1. Add Product to Favorites");
                                            System.out.println("2. Add Product to Shopping Cart");
                                            System.out.println("3. Go back");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1){
                                                System.out.println("Give the name of the pharmacy you want to add the product to favorites from:");
                                                String pharm = scan.nextLine();
                                                eshop.addToFavorites(product,user.getUser_ID(),pharm);
                                                System.out.println("Product added to favorites.");
                                                eshop.showUserFavorites(user.getUser_ID());
                                                back = true;
                                            }
                                            if (c == 2){
                                                System.out.println("Give the name of the pharmacy you want to buy the product from:");
                                                String pharm = scan.nextLine();
                                                System.out.println("Give the amount of " + product + " you want to add to your shopping cart:");
                                                int amount = scan.nextInt();
                                                scan.nextLine();
                                                eshop.addToShoppingCart(product, user.getUser_ID(),pharm, amount);
                                                System.out.println("Product added to shopping cart.");
                                                eshop.showUserCart(user.getUser_ID());
                                                back = true;
                                            }
                                            if (c == 3)
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
                            System.out.println("1. Favorite products");
                            System.out.println("Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    // eshop.showFavorites();
                                    System.out.println("1. Continue searching");
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. Show categories");
                            System.out.println("Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showCategories();
                                    System.out.println("2. Go back");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 4:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    System.out.print("ID: " + user.getUser_ID());
                                    System.out.println();
                                    System.out.print("Name: " + user.getFullname());
                                    System.out.println();
                                    System.out.print("Address: " + user.getAddress());
                                    System.out.println();
                                    System.out.print("Phone number: " + user.getPhone_number());
                                    System.out.println();
                                    System.out.print("Email: " + user.getEmail());
                                    System.out.println();
                                    System.out.print("Username: " + user.getUsername());
                                    System.out.println();
                                    System.out.println("1. Go Back");
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
            }
        }
    }


}
