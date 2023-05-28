import java.util.ArrayList;
import java.util.Scanner;

public class Eshop {
    String name = "Galenus Pharmacies";
    User user;
    Pharmacy_User pharmacyUser;
    Products products;
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Pharmacy_User> pharmacyUserList = new ArrayList<>();
    ArrayList<Products> productsList = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();

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
        try {
            if (productsList.contains(product))
                throw new IllegalArgumentException("Product already exists");
            else
                productsList.add(product);
        } catch (Exception e) {
            System.out.println("The product already exists in the list111111");
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
            if ((product.getProduct_category().equals(category)))
                System.out.println(i + ":" + product.getProduct_Name());
        }
        i++;
    }

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Search any category, product, or pharmacy:");
        String search = scan.nextLine();
        for (String categor : categories){
            if (categor.equals(search))
                showCategoryProducts(search);
        }
        for (Products product : productsList){
            if (product.getProduct_category().equals(search))
                showProductInfo(search);
        }
        for (Pharmacy_User pharmUser : pharmacyUserList){
            if (search.equals(pharmUser.getPharmacy_Name())) {
                showPharmacyUserInfo(search);
                System.out.println();
                showPharmacyProducts(search);
            }
        }
    }

    public void showPharmacyProducts(String pharmacy) {
        System.out.println(pharmacy + " products:");
        for (Products productinfo : productsList){
            if ((productinfo.getProduct_Name().equals(pharmacy))) {
                for (Pharmacy_User pharmacyUser : pharmacyUserList)
                    if (pharmacyUser.getPharmacy_ID() == productinfo.getPharmacy_ID())
                        System.out.print("Pharmacy Name: " + pharmacyUser.getPharmacy_Name() + "  ");
                System.out.print("Product ID: " + productinfo.getProduct_id()+ "  ");
                System.out.print("Product Name: " + productinfo.getProduct_Name() + "  ");
                System.out.print("Product Price: " + productinfo.getProduct_Price() + "  ");
                System.out.print("Product Amount: " + productinfo.getProduct_Amount() + "  ");
                System.out.println("Product Category:" + productinfo.getProduct_category());
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
                System.out.println("Product Category:" + productinfo.getProduct_category());
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
            System.out.println("Product Category:" + product.getProduct_category());
            System.out.println();
        }
    }

    public void showPharmacyUserInfo(String username) {
        System.out.println("Pharmacy's Info:");
        System.out.println();
        for (Pharmacy_User pharmacyUser : pharmacyUserList) {
            if (pharmacyUser.getUsername().equals(username)) {
                System.out.print("Pharmacy ID: " + pharmacyUser.getPharmacy_ID() + "  ");
                System.out.print("Pharmacy Name: " + pharmacyUser.getPharmacy_Name() + "  ");
                System.out.print("Pharmacy Email: " + pharmacyUser.getEmail() + "  ");
                System.out.print("Pharmacy Address: " + pharmacyUser.getAddress() + "  ");
                System.out.print("Pharmacy Phone: " + pharmacyUser.getPhone_number() + "  ");
                System.out.println();
            }
        }
    }
}