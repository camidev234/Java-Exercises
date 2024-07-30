import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {
    private String product_code;
    private String product_name;
    private float product_value;
    private static List<Product> products_created = new ArrayList<>();

    public Product(String product_code, String product_name, float product_value) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_value = product_value;
        products_created.add(this);
    }

    public static List<Product> getProductsCreated() {
        return products_created;
    }
    public String getProductCode() {
        return product_code;
    }

    public static Product createNewProduct() {
        boolean productExists = true;
        String code = "";
        Scanner scanner = new Scanner(System.in);
        while(productExists) {
            int counter = 0;
            System.out.println("Introduzca el codigo del producto: ");
            code = scanner.nextLine();
            for (Product elem : products_created) {
                if(elem.getProductCode().equals(code)) {
                    counter++;
                    break;
                }
            }
            if(counter == 0) {
                productExists = false;
            } else {
                System.out.println("Ya existe un producto con este codigo, por favor.");
            }
        }
        System.out.println("Introduzca el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.println("Digite el valor del producto: ");
        float value = scanner.nextFloat();
        scanner.nextLine();
        Product newProduct = new Product(code, name, value);
        return newProduct;
    }

    public static Product findProductByCode(String code) {
        for (Product elem : products_created) {
            if(elem.product_code.equals(code)) {
                return elem;
            }
        }
        return null;
    }

    public void getProductInfo() {
        System.out.println("Codigo del producto: " + this.product_code);
        System.out.println("Nombre del producto: " + this.product_name);
        System.out.println("Precio del producto: " + this.product_value);
    }

    public String getProductName() {
        return product_name;
    }

    public float getProductValue() {
        return product_value;
    }

    public void setProductCode(String productCode) {
        this.product_code = productCode;
    }

    public void setProductName(String productName) {
        this.product_name = productName;
    }

    public void setProductValue(float productValue) {
        this.product_value = productValue;
    }
}