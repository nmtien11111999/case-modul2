package handle_cart_product;

import handle_account.HandleAccount;
import handle_product.HandleProduct;
import list_product.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class HandleCartProduct {
    Scanner inputInt = new Scanner(System.in);
    HandleProduct handleProduct = new HandleProduct();
    HandleAccount handleAccount = new HandleAccount();
    public static List<Product> cartProduct = new ArrayList<>();
    HandleProductSold handleProductSold = new HandleProductSold();

    public void displayCart(String name , String pass){
        readCartProduct();
        for (Product product : cartProduct){
            if (product.getUserName().equals(handleAccount.signInAccount(name,pass).getName())){
                System.out.println("Mã sản phẩm: " + product.getId() + " -Tên sản pẩm: " + product.getName() + " -Số lượng: " + product.getQuantity());
            }
        }
    }

    public void addCartProduct(String name , String pass){
        readCartProduct();
        Product product = handleProduct.findProductById();
        if (product != null){
            for (Product cart : cartProduct){
                if (cart.getUserName().equals(handleAccount.signInAccount(name,pass).getName()) && cart.getId() == product.getId()){
                    System.out.println(" Sản phẩm đã có trong giỏ hàng ");
                    return;
                }
            }
            cartProduct.add(new Product(handleAccount.signInAccount(name , pass).getName(),product.getId(), product.getName(), product.getPriceSell(), product.getQuantity()));
            writeCartProduct();
            System.out.println(" Thêm thành công ");
        } else {
            System.out.println("--- Không tồn tại id sản phẩm ---");
        }
    }

    public void removeCartProduct(){
        readCartProduct();
        try {
            System.out.print(" Nhập id sản phẩm bạn muốn xóa: ");
            int id = inputInt.nextInt();
            for (Product product : cartProduct){
                if (id == product.getId()){
                    cartProduct.remove(product);
                    writeCartProduct();
                    System.out.println(" Xóa thành công ");
                    return;
                }
            }
            System.out.println(" Sản phẩm không có trong giỏ hàng ");
        } catch (Exception e){
            System.out.println(" Nhập sai định dạng ");
        }
        writeCartProduct();
    }

    public void payProduct(String name,String pass){
        readCartProduct();
        handleProduct.readProduct();
        handleProductSold.readCartSold();
        try {
            System.out.print(" Nhập id cần mua: ");
            int id = inputInt.nextInt();
            for (Product productlist : cartProduct){
                if (id == productlist.getId()){
                    System.out.print(" Nhập số lượng bạn muốn mua: ");
                    int quantity = inputInt.nextInt();
                    if (quantity <= productlist.getQuantity()){
                        for (Product products : handleProduct.products){
                            if (id == products.getId()){
                                products.setQuantity(products.getQuantity()-quantity);
                                products.setQuantitySold(products.getQuantitySold() + quantity);
                                handleProduct.writeProduct();
                            }
                        }
                        productlist.setQuantity(productlist.getQuantity()-quantity);
                        handleProductSold.cartSold.add(new Product(handleAccount.signInAccount(name,pass).getName(),productlist.getId(),productlist.getName(),productlist.getPriceSell(),quantity));
                        handleProductSold.writeCartSold();
                        writeCartProduct();
                    } else {
                        System.out.println("--- Sản phẩm không đủ ---");
                    }
                } else {
                    System.out.println("--- Bạn chưa thêm sản phẩm vào giỏ hàng ---");
                }
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
    }

    public static void readCartProduct(){
        cartProduct.clear();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("cartProduct.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",");
                String userName = tokens[0];
                int id = Integer.parseInt(tokens[1]);
                String name = tokens[2];
                double price = Double.parseDouble(tokens[3]);
                int quantity = Integer.parseInt(tokens[4]);
                cartProduct.add(new Product(userName,id,name,price,quantity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeCartProduct(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cartProduct.txt"))) {
            for (Product products : cartProduct){
                bufferedWriter.write(products.getUserName()+","+products.getId()+","+products.getName()+","+products.getPriceSell()+","+products.getQuantity());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
