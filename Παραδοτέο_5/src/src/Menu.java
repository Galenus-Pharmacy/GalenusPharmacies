import java.util.Scanner;

public class Menu {
    Eshop eshop;
    Pharmacy_User pharmacyUser;
    Products product;
    User user;
    private int pharmacy_ID = 0, user_ID = 0, product_ID = 0;

    public void getUserInfo(String username,String password) {
        for (Pharmacy_User pharmacyUser : eshop.pharmacyUserList) {
            if (pharmacyUser.getUsername().equals(username) && pharmacyUser.getPassword().equals(password)) {
                int pharmacyID = pharmacyUser.getPharmacy_ID();
                String pharmacyName = pharmacyUser.getPharmacy_Name();
                String pharmacyEmail = pharmacyUser.getEmail();
                String pharmacyAddress = pharmacyUser.getAddress();
                int pharmacyPhone = pharmacyUser.getPhone_number();
                pharmacyUser = new Pharmacy_User(pharmacyID, pharmacyName, username, pharmacyEmail, pharmacyAddress, pharmacyPhone, password);
            }
        }

        for (User user : eshop.userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                int ID = user.getUser_ID();
                String name = user.getFullname();
                String email = user.getEmail();
                String address = user.getAddress();
                int phone = user.getPhone_number();
                user = new User(ID, name, username, email, password, phone, address);
            }
        }
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
        int phone_number = scan.nextInt();
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
        int phone_number = scan.nextInt();
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
        scanner.nextLine(); // Consume the newline character

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
                    product = new Products(pharmacyUser.getPharmacy_ID(), product.getProduct_id(), productName, productPrice, productAmount, productCategory);
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
        int creatingAccount = 0;
        while (creatingAccount != 1 && creatingAccount != 2) {
            System.out.println("1. Create a pharmacy account.");
            System.out.println("2. Create a buyer account");
            creatingAccount = scan.nextInt();
            scan.nextLine();
            if (creatingAccount != 1 && creatingAccount != 2)
                System.out.println("Choose a valid option");
        }
        if (sign == 2 && creatingAccount == 1) {
            //return object Pharmacy user?
            newPharmacyUserInfo();
            while (flag == false) {
                System.out.println("Welcome " + pharmacyUser.getPharmacy_Name() + " to Galenus Pharmacy");
                System.out.println("-------------------------------");
                System.out.println("1.Search");
                System.out.println("2.Add product");
                System.out.println("3.Profile");
                System.out.println("4.Show history order");
                System.out.println("5.Exit");
                int insert;
                insert = scan.nextInt();
                switch (insert) {
                    case 1:
                        System.out.println("1. Search products");
                        System.out.println("Go back");
                        int search = scan.nextInt();
                        scan.nextLine();
                        if (search == 2)
                            break;
                        else {
                            while (back == false) {
                                eshop.showCategories();
                                eshop.showProducts();
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
                                // getUserInfo(username,password);
                                System.out.println(pharmacyUser.getPharmacy_ID());
                                System.out.println(pharmacyUser.getPharmacy_Name());
                                System.out.println(pharmacyUser.getAddress());
                                System.out.println(pharmacyUser.getPhone_number());
                                System.out.println(pharmacyUser.getEmail());
                                System.out.println(pharmacyUser.getUsername());
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
        }
        if (sign == 2 && creatingAccount == 2) {
            //menu for the User
            newUserInfo();
            while (flag == false) {
                System.out.println("Welcome " + user.getFullname() + " to Galenus Pharmacy");
                System.out.println("------------------------");
                System.out.println("1.Search ");
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
                        System.out.println("1. Search products");
                        System.out.println("Go back");
                        int search = scan.nextInt();
                        scan.nextLine();
                        if (search == 2)
                            break;
                        else {
                            while (back == false) {
                                eshop.showCategories();
                                eshop.showProducts();
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
                                // getUserInfo(username,password);
                                System.out.println(user.getUser_ID());
                                System.out.println(user.getFullname());
                                System.out.println(user.getAddress());
                                System.out.println(user.getPhone_number());
                                System.out.println(user.getEmail());
                                System.out.println(user.getUsername());
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
