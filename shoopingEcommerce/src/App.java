import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean activeMenu = true;
        while (activeMenu) { 
            System.out.println("Escoja una de las siguientes opciones");
            System.out.println("1. Crear producto");
            System.out.println("2. Ver listado de productos creados");
            System.out.println("3. Ver carrito de compras");
            System.out.println("5. Salir del menu");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 ->  {
                    Product newProduct = Product.createNewProduct();
                    System.out.println("-------------------------------------");
                    newProduct.getProductInfo();
                    System.out.println("-------------------------------------");
                    break;
                }
                case 2 -> {
                    List<Product> productsCrated = Product.getProductsCreated();
                    System.out.println("-------------------------------------------------");
                    System.out.println("Listado de productos creados en el sistema.");
                    for (Product elem : productsCrated) {
                        System.out.println("Codigo: " + elem.getProductCode());
                        System.out.println("Producto: " + elem.getProductName());
                        System.out.println("Precio: " + elem.getProductValue());
                        System.out.println("-----------------------------------");
                    }
                    while (true) { 
                        System.out.println("¿Desea agregar algun producto al carrito de compras? s/n");
                        String answer = scanner.nextLine();
                        if(answer.equals("s") || answer.equals("y")){
                            System.out.println("Digite el codigo del producto que desea agregar: ");
                            String productCode = scanner.nextLine();
                            boolean productWasAdded = ShoppingCart.addProductToCart(productCode);
                            if(productWasAdded) {
                                System.out.println("Producto agregado al carrito de compras.");
                            }else {
                                System.out.println("El producto no existe.");
                            }
                        } else{
                            break;
                        }
                    }
                    break;
                }
                case 3 -> {
                    List<CartItem> productsCart = ShoppingCart.getCartProducts();
                    for (CartItem prod : productsCart) {
                        System.out.println("--------------------------------------");
                        System.out.println("Informacion del producto");
                        System.out.println("Codigo del producto: " + prod.getProduct().getProductCode());
                        System.out.println("Producto: " + prod.getProduct().getProductName());
                        System.out.println("Precio unitario: " + prod.getProduct().getProductValue());
                        System.out.println("Cantidad: " + prod.getItemQuantitiy());
                        System.out.println("--------------------------------------");
                    }
                    System.out.println("Total a pagar: " + ShoppingCart.getTotalAmountToPay());
                    break;
                }
                case 5 -> {
                    activeMenu = false;
                    break;
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
        }
        scanner.close();
    }
}
