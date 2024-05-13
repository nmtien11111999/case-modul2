package handle_cart_product;

import handle_account.HandleAccount;
import list_product.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleProductSold {
    List<Product> cartSold = new ArrayList<>();
    HandleAccount handleAccount = new HandleAccount();

    public void displayProductSoldManager(){
        readCartSold();
        System.out.println("\n--- Danh sách khách hàng đã mua sản phẩm ---");
        for (Product products : cartSold){
            double total = products.getPriceSell()*products.getQuantity();
            System.out.println(" Tên tài khoản đăng nhập của người dùng: " + products.getUserName()+ " -Mã sản phẩm: " + products.getId() + " -Tên sản phẩm: " + products.getName() + " -Giá sản phẩm: " + products.getPriceSell() + " -Số lượng đã mua: " + products.getQuantity() + " -Tổng số tiền: " +total);
        }
    }

    public void displayProductClient(String name,String pass){
        readCartSold();
        System.out.println("\n--- Danh sách sản phẩm bạn đã mua ---");
        for (Product product : cartSold){
            if (product.getUserName().equals(handleAccount.signInAccount(name,pass).getName())){
                double total = product.getPriceSell()*product.getQuantity();
                System.out.println("Mã sản phẩm: " + product.getId() + " -Tên sản phẩm: " + product.getName() + " -Giá tiền: " + product.getPriceSell() + " -Số lượng đã mua: " + product.getQuantity() + " -Tổng số tiền: " +total);
            }
        }
    }

    public void readCartSold(){
        cartSold.clear();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("productSold.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",");
                String userName = tokens[0];
                int id = Integer.parseInt(tokens[1]);
                String name = tokens[2];
                double price = Double.parseDouble(tokens[3]);
                int quantity = Integer.parseInt(tokens[4]);
                cartSold.add(new Product(userName,id,name,price,quantity));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeCartSold(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("productSold.txt"))) {
            for (Product product : cartSold){
                bufferedWriter.write(product.getUserName()+","+product.getId()+","+product.getName()+","+product.getPriceSell()+","+product.getQuantity());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
