import java.util.ArrayList;
import java.util.Scanner;

public class Products {

        private int Product_id;
        private String Product_Name;
        private double Product_Price;
        private int Product_Amount;
        ArrayList<Products> productList = new ArrayList<>();
        public  Products() {};
        public Products(int product_id, String product_Name, double product_Price, int product_Amount) {
                Product_id = product_id;
                Product_Name = product_Name;
                Product_Price = product_Price;
                Product_Amount = product_Amount;
        }

        public int getProduct_id() {
                return Product_id;
        }

        public void setProduct_id(int product_id) {
                Product_id = product_id;
        }

        public String getProduct_Name() {
                return Product_Name;
        }

        public void setProduct_Name(String product_Name) {
                Product_Name = product_Name;
        }

        public double getProduct_Price() {
                return Product_Price;
        }

        public void setProduct_Price(double product_Price) {
                Product_Price = product_Price;
        }

        public int getProduct_Amount() {
                return Product_Amount;
        }

        public void setProduct_Amount(int product_Amount) {
                Product_Amount = product_Amount;
        }

        public void setProductInfo(){
                Scanner scanner = new Scanner(System.in);
                int productCount;

                System.out.print("Enter the number of products: ");
                productCount = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                for (int i = 0; i < productCount; i++) {
                        System.out.println("Enter details for Product " + (i + 1) + ":");

                        System.out.print("Product ID: ");
                        int productId = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Product Name: ");
                        String productName = scanner.nextLine();

                        System.out.print("Product Price: ");
                        double productPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Product Amount: ");
                        int productAmount = scanner.nextInt();

                        // Create a new Products object and add it to the productList
                        Products product = new Products(productId, productName, productPrice, productAmount);
                        productList.add(product);

                        System.out.println();
                }

                // Display the products in the list
                System.out.println("Product List:");
                for (Products product : productList) {
                        System.out.println("Product ID: " + product.getProduct_id());
                        System.out.println("Product Name: " + product.getProduct_Name());
                        System.out.println("Product Price: " + product.getProduct_Price());
                        System.out.println("Product Amount: " + product.getProduct_Amount());
                        System.out.println();
                }

                scanner.close();
        }
}