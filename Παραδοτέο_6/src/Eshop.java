import java.util.ArrayList;
import java.util.Scanner;

public class Eshop {
    String name = "Galenus Pharmacies";
    User user;
    Pharmacy_User pharmacyUser;
    Products products;
    Favorite favorite;
    Cart cart;
    Order order;
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Pharmacy_User> pharmacyUserList = new ArrayList<>();
    ArrayList<Products> productsList = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();
    ArrayList<String> categoryProducts = new ArrayList<>();
    ArrayList<Favorite> favoriteList = new ArrayList<>();
    ArrayList<Cart> cartList = new ArrayList<>();
    ArrayList<Order> orderList = new ArrayList<>();

    int orderID = 0;

    public void addToFavorites(String product, int userID, String pharm) {
        int pharm_id = -1;
        int prod_id = -1;
        boolean exists = false;
        for (Pharmacy_User pharmacyUser : pharmacyUserList)
            if (pharmacyUser.getPharmacy_Name().equals(pharm)) {
                pharm_id = pharmacyUser.getPharmacy_ID();
            }
        for (Products productinfo : productsList) {
            if (productinfo.getProduct_Name().equals(product) && productinfo.getPharmacy_ID() == pharm_id) {
                prod_id = productinfo.getProduct_id();
                //   favorite = new Favorite(prod_id, userID, pharm_id);
                // favoriteList.add(favorite);
            }
        }
        for (Favorite fav : favoriteList) {
            if (fav.getUser_ID() == userID && fav.getPharmacy_ID() == pharm_id && fav.getProduct_ID() == prod_id) {
                exists = true;
                favoriteList.remove(fav);
                favorite = new Favorite(prod_id, userID, pharm_id);
                favoriteList.add(favorite);
            }
        }
        if (!exists) {
            favorite = new Favorite(prod_id, userID, pharm_id);
            favoriteList.add(favorite);
        }
    }

    public void showUserFavorites(int user_id) {
        int i = 1;
        int pharmacy_ID = -1;
        int product_ID = -1;
        double price = 0;
        String user = null, product = null, pharmacy = null;
        for (User user2 : userList)
            if (user2.getUser_ID() == user_id) {
                user = user2.getFullname();
            }
        System.out.println("Results for " + user + " favorite list:");
        for (Favorite favor : favoriteList) {
            if (favor.getUser_ID() == user_id) {
                for (Products productinfo : productsList) {
                    if (productinfo.getPharmacy_ID() == favor.getPharmacy_ID()) {
                        pharmacy_ID = productinfo.getPharmacy_ID();
                        product_ID = productinfo.getProduct_id();
                        product = productinfo.getProduct_Name();
                        price = productinfo.getProduct_Price();
                        for (Pharmacy_User pharmacyUser : pharmacyUserList)
                            if (pharmacyUser.getPharmacy_ID() == pharmacy_ID) {
                                pharmacy = pharmacyUser.getPharmacy_Name();
                            }
                    }
                }
                System.out.print(i + ":" + " Product:" + product + " Product Price:$" + price + "  Pharmacy Name:" + pharmacy);
                System.out.println();
                i++;
            }
        }
    }

    public void addToShoppingCart(String product, int userID, String pharm, int amount) {
        int pharm_id = -1;
        int prod_id = -1;
        double productPrice = 0;
        boolean exists = false;
        for (Pharmacy_User pharmacyUser : pharmacyUserList)
            if (pharmacyUser.getPharmacy_Name().equals(pharm)) {
                pharm_id = pharmacyUser.getPharmacy_ID();
            }
        for (Products productinfo : productsList) {
            if (productinfo.getProduct_Name().equals(product) && productinfo.getPharmacy_ID() == pharm_id) {
                prod_id = productinfo.getProduct_id();
                productPrice = productinfo.getProduct_Price() * amount;
            }
        }
        for (Cart cartt : cartList) {
            if (cartt.getUser_ID() == userID && cartt.getPharmacy_ID() == pharm_id && cart.getProduct_ID() == prod_id) {
                exists = true;
                cartList.remove(cartt);
                cart = new Cart(prod_id, pharm_id, amount, userID, productPrice);
                cartList.add(cart);
            }
        }
        if (!exists) {
            cart = new Cart(prod_id, pharm_id, amount, userID, productPrice);
            cartList.add(cart);
        }
    }

    public void showShoppingCart(int userID) {
        for (Cart cartt : cartList) {
            int i = 1;
            String prodname = null;
            String pharmacy = null;
            double price = 0;
            if (cartt.getUser_ID() == userID) {
                for (Products productinfo : productsList) {
                    if (cartt.getProduct_ID() == productinfo.getProduct_id())
                        prodname = productinfo.getProduct_Name();
                    price = productinfo.getProduct_Price();
                }
                for (Pharmacy_User pharmacyUser : pharmacyUserList)
                    if (pharmacyUser.getPharmacy_ID() == cartt.getPharmacy_ID()) {
                        pharmacy = pharmacyUser.getPharmacy_Name();
                    }
            }
            System.out.print(i + ":" + "  Pharmacy Name: " + pharmacy + "  Product: " + prodname + "  Product Price: $ " + price + "  Product Amount: " + cartt.getProduct_Amount() + "  Product total Price: $" + cartt.getPrice());
            System.out.println();
            i++;
        }
    }

    public void OrderProducts(int userID){
        double totalCartPrice = 0;
        double totalPrice = 0;
        int pharmId=-1;
        int productId=-1;
        int amount = -1;
        for (Cart cartt : cartList){
            if (cartt.getUser_ID() == userID){
                pharmId = cartt.getPharmacy_ID();
                productId = cartt.getProduct_ID();
                amount = cartt.getProduct_Amount();
                totalCartPrice = totalCartPrice + cart.getPrice()*cart.getProduct_Amount();
                order = new Order(cartt, this.orderID,totalCartPrice);
                orderID++;
                orderList.add(order);
                for (Products prod : productsList)
                    if (prod.getProduct_id() == productId && pharmId == prod.getPharmacy_ID()){
                        cartt.setProduct_Amount(cartt.getProduct_Amount()-amount);
                        System.out.println("Amount:" + cartt.getProduct_Amount());
                    }
                cartList.remove(cartt);
            }
        }
        for (Order orderr : orderList){
            if (orderr.getOrderId() == this.orderID){
                totalPrice = totalPrice + orderr.getTotalPrice();
            }
        }
        for (Order orderrr : orderList) {
            System.out.print("Order ID:" + orderrr.getOrderId());
            System.out.print("Cart:" + orderrr.getCart());
            System.out.println("Price:" + orderrr.getTotalPrice());
            System.out.println();
        }
    }
    public void showUserProfile(int userid){
        for (User userr : userList){
            if (userr.getUser_ID() == userid) {
                System.out.print("ID: " + userr.getUser_ID());
                System.out.println();
                System.out.print("Name: " + userr.getFullname());
                System.out.println();
                System.out.print("Address: " + userr.getAddress());
                System.out.println();
                System.out.print("Phone number: " + userr.getPhone_number());
                System.out.println();
                System.out.print("Email: " + userr.getEmail());
                System.out.println();
                System.out.print("Username: " + userr.getUsername());
                System.out.println();
            }
        }
    }

    public void showUserCart(int user_id) {
        int i=1;
        int pharmacy_ID = -1;
        int product_ID = -1;
        String user = null, product = null, pharmacy = null ;
        for (User user2 :userList)
            if (user2.getUser_ID() == user_id) {
                user = user2.getFullname();
            }
        System.out.println("Results for " + user + " cart list:");
        for (Cart cart : cartList){
            if (cart.getUser_ID() == user_id) {
                for (Products productinfo : productsList) {
                    if (productinfo.getPharmacy_ID() == cart.getPharmacy_ID()) {
                        pharmacy_ID = productinfo.getPharmacy_ID();
                        product_ID = productinfo.getProduct_id();
                        product = productinfo.getProduct_Name();
                        for (Pharmacy_User pharmacyUser : pharmacyUserList)
                            if (pharmacyUser.getPharmacy_ID() == pharmacy_ID) {
                                pharmacy = pharmacyUser.getPharmacy_Name();
                            }
                    }
                }
                System.out.print(i + ":" + " Product:" + product + " Product Amount:" + cart.getProduct_Amount() + " Product Price:$" + cart.getPrice() + "  Pharmacy Name:" + pharmacy);
                System.out.println();
                i++;
            }
        }
    }

    public void addPharmacyUser(Pharmacy_User pharmacyUser) {
        try {
            if (pharmacyUserList.contains(pharmacyUser))
                throw new IllegalArgumentException("Pharmacy user already exists");
            else
                pharmacyUserList.add(pharmacyUser);
        } catch (Exception e) {
            System.out.println("The Pharmacy user already exists in the list");
        }
    }

    public void addUser(User user) {
        try {
            if (userList.contains(user))
                throw new IllegalArgumentException("User already exists");
            else
                userList.add(user);
        } catch (Exception e) {
            System.out.println("The user already exists in the list");
        }
    }

    public void addProducts(Products product) {
        for (Products prod : productsList) {
            if (productsList.contains(product))
                System.out.println("Product Already Exists");
            else
                productsList.add(product);
        }
    }

     public void showCategories() {
        int i=1;
        System.out.println("Categories:");
        for (Products product : productsList){
            String category = product.getProduct_category();
            if (!(categories.contains(category)))
                categories.add(category);
        }
        for (String c : categories){
            System.out.println(i + ": " + c);
            i++;
        }

    }

    public void showCategoryProducts(String category) {
        int i=1;
        System.out.println("Results for " + category + " category:");
        for (Products product : productsList){
            if  (product.getProduct_category().equals(category)) {
                String productt = product.getProduct_Name();
                if (!(categoryProducts.contains(productt)))
                    categoryProducts.add(productt);
            }
        }

        for (String c : categoryProducts){
            System.out.println(i + ": " + c);
            i++;
        }
        categoryProducts.clear();
    }

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Search any category, product, or pharmacy:");
        String search = scan.nextLine();
        for (Products productt : productsList){
            if (productt.getProduct_category().equals(search))
                showCategoryProducts(search);
        }
        for (Products product : productsList){
            if (product.getProduct_Name().equals(search))
                showProductInfo(search);
        }
        for (Pharmacy_User pharmUser : pharmacyUserList){
            if (search.equals(pharmUser.getPharmacy_Name())) {
                int pID = pharmUser.getPharmacy_ID();
                showPharmacyUserInfo(search);
                System.out.println();
                showPharmacyProducts(pID, search);
            }
        }
    }

    public void showPharmacyProducts(int pharmacy,String name) {
        System.out.println(name + " products:");
        System.out.println();
        for (Products productinfo : productsList){
            if (productinfo.getPharmacy_ID() == pharmacy) {
                for (Pharmacy_User pharmacyUser : pharmacyUserList)
                    if (pharmacyUser.getPharmacy_ID() == productinfo.getPharmacy_ID())
                        System.out.print("Pharmacy Name: " + pharmacyUser.getPharmacy_Name() + "  ");
                System.out.print("Product ID: " + productinfo.getProduct_id()+ "  ");
                System.out.print("Product Name: " + productinfo.getProduct_Name() + "  ");
                System.out.print("Product Price: " + productinfo.getProduct_Price() + "  ");
                System.out.print("Product Amount: " + productinfo.getProduct_Amount() + "  ");
                System.out.println("Product Category :" + productinfo.getProduct_category());
                System.out.println();
            }
        }

    }

    public void showProductInfo(String product) {
        System.out.println("Results for " + product + ":");
        for (Products productinfo : productsList){
            if ((productinfo.getProduct_Name().equals(product))) {
                for (Pharmacy_User pharmacyUser : pharmacyUserList)
                    if (pharmacyUser.getPharmacy_ID() == productinfo.getPharmacy_ID())
                        System.out.print("Pharmacy Name: " + pharmacyUser.getPharmacy_Name() + "  ");
                System.out.print("Product ID: " + productinfo.getProduct_id()+ "  ");
                System.out.print("Product Name: " + productinfo.getProduct_Name() + "  ");
                System.out.print("Product Price: " + productinfo.getProduct_Price() + "  ");
                System.out.print("Product Amount: " + productinfo.getProduct_Amount() + "  ");
                System.out.println("Product Category :" + productinfo.getProduct_category());
                System.out.println();
            }
        }

    }

    public void showProducts() {
        System.out.println("Product List:");
        for (Products product : productsList) {
            System.out.print("Pharmacy ID: " + product.getPharmacy_ID() + "  ");
            System.out.print("Product ID: " + product.getProduct_id()+ "  ");
            System.out.print("Product Name: " + product.getProduct_Name() + "  ");
            System.out.print("Product Price: " + product.getProduct_Price() + "  ");
            System.out.print("Product Amount: " + product.getProduct_Amount() + "  ");
            System.out.println("Product Category: " + product.getProduct_category());
            System.out.println();
        }
    }

    public void showPharmacyProfile(int pharmacyId){
        for (Pharmacy_User pus : pharmacyUserList){
            if (pharmacyId == pus.getPharmacy_ID()){
                System.out.print("Pharmacy ID: " + pus.getPharmacy_ID() + "  ");
                System.out.print("Pharmacy Name: " + pus.getPharmacy_Name() + "  ");
                System.out.print("Pharmacy Email: " + pus.getEmail() + "  ");
                System.out.print("Pharmacy Address: " + pus.getAddress() + "  ");
                System.out.print("Pharmacy Phone: " + pus.getPhone_number() + "  ");
                System.out.println("Pharmacy Username: " + pus.getUsername());
                System.out.println();
            }
        }
    }
    public void showPharmacyUserInfo(String username) {
        System.out.println("Pharmacy's Info:");
        //System.out.println();
        for (Pharmacy_User phUser : pharmacyUserList) {
            if (phUser.getPharmacy_Name().equals(username)) {
                System.out.print("Pharmacy ID: " + phUser.getPharmacy_ID() + "  ");
                System.out.print("Pharmacy Name: " + phUser.getPharmacy_Name() + "  ");
                System.out.print("Pharmacy Email: " + phUser.getEmail() + "  ");
                System.out.print("Pharmacy Address: " + phUser.getAddress() + "  ");
                System.out.print("Pharmacy Phone: " + phUser.getPhone_number() + "  ");
                System.out.println();
            }
        }
    }
}