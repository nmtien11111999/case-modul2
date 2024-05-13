import handle_product.HandleProduct;
import list_product.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test extends HandleProduct {

    Scanner inputInt = new Scanner(System.in);
    static ArrayList<Product> testProducts = new ArrayList<>();

    @Override
    public void removeProduct() {
        System.out.print("Nhập id sản phẩm bạn muốn xóa: ");
        try {
            int id = inputInt.nextInt();
            for (Product product : new ArrayList<>(testProducts)) {
                if (id == product.getId()) {
                    testProducts.remove(product);
                    System.out.println("Sản phẩm đã được xóa thành công.");
                    return;
                }
            }
            System.out.println("Không tìm thấy sản phẩm với id " + id + ".");
        } catch (InputMismatchException e) {
            System.out.println("--- Nhập sai định dạng ---");
            inputInt.nextLine();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Product product1 = new Product(1,"Sữa chua",4000,40);
        Product product2 = new Product(2, "Cà phê",10000,20);
        testProducts.add(product1);
        testProducts.add(product2);
        test.removeProduct();
    }
}