public class CartItem {
    private int quantity = 1;
    private Product product;
    private float totalMount;

    public CartItem(int quantity, Product product, float totalMount) {
        this.quantity = quantity;
        this.product = product;
        this.totalMount = totalMount;
    }

    public int getItemQuantitiy() {
        return quantity;
    }

    public float getTotalMount() {
        return totalMount;
    }

    public Product getProduct() {
        return product;
    }

    public void setItemQuantity(int cant) {
        this.quantity = cant;
    }
}
