
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private static List<CartItem> cartProducts = new ArrayList<>();

    public static List<CartItem> getCartProducts() {
        return Collections.unmodifiableList(cartProducts);
    }

    public static boolean addProductToCart(String code) {
        Scanner scanner = new Scanner(System.in);
        Product product = Product.findProductByCode(code);
        if(product == null) {
            return false;
        }else {
            int cant = 0;
            while (true) {          
                System.out.println("Digite la cantidad de unidades para este producto: ");
                cant = scanner.nextInt();
                if(cant > 0) {
                    break;
                }
            }
            float totalValue = product.getProductValue() * cant;
            CartItem itemToAdd = new CartItem(cant, product, totalValue);
            cartProducts.add(itemToAdd);
            return true;
        }
    }

    public static void deleteProduct(int index) {
        cartProducts.remove(index-1);
    }

    public static void clearShoppingCart() {
        cartProducts.clear();
    }

    public static float getTotalAmountToPay() {
        float total = 0;
        for (CartItem elem : cartProducts) {
            total = total + elem.getTotalMount();
        }
        return total;
    }
}
