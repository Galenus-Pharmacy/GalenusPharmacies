public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store Products
        Products prod = new Products();
        Cart cart = new Cart();
        prod.setProductInfo();
        Premium_User pu = new Premium_User();
        System.out.println(prod.productList.get(0).getProduct_id());
        pu.setEmail("a");
        System.out.println(pu.getEmail());
    }
}