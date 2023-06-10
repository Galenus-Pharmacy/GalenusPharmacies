public class Order {
    Cart cart;
    private int orderId = 0;
    private double totalPrice;

    public Order() {
    }

    public Order(Cart cart) {
        this.cart = cart;
    }

    public Order(Cart cart, int orderId, double totalPrice) {
        this.cart = cart;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
