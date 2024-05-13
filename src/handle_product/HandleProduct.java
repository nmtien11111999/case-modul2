package handle_product;

import account_and_password.Account;
import list_product.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HandleProduct {
    public List<Product> products = new ArrayList<>();
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Scanner inputDouble = new Scanner(System.in);

    public void displayProductByClient(){
        readProduct();
        System.out.println("\n--- Danh sách các sản phẩm ---");
        for (Product product : products){
            System.out.println("Id sản phẩm: " + product.getId() + " -Tên sản phẩm:" + product.getName() + " -Giá sản phẩm:" + product.getPriceSell() + " -Số lượng sản phẩm:" + product.getQuantity());
        }
    }

    public void arrangeProductMin(){
        readProduct();
        products.sort(Comparator.comparingDouble(Product::getPriceSell).reversed());
        products.forEach(System.out::println);
    }

    public void arrangeProductMax(){
        readProduct();
        products.sort(Comparator.comparingDouble(Product::getPriceSell));
        products.forEach(System.out::println);
    }

    public void arangeProduct(){
        readProduct();
        try {
            System.out.println("--- Nhập giá tiền sản phẩm bạn muốn tìm (nhập trong khoảng từ bé đến cao) ---");
            System.out.print(" Nhập giá tiền sản phẩm thấp nhất bạn muốn xem ");
            double min = inputDouble.nextDouble();
            System.out.print(" Nhập giá tiền sản phẩm cao nhất bạn muốn xem ");
            double max = inputDouble.nextDouble();
            boolean check = false;
            for (Product product : products){
                if (product.getPriceSell() > min && product.getPriceSell() < max){
                    System.out.println(" -Id sản phẩm:  " + product.getId() + " -Tên sản phẩm: " + product.getName() + " -Giá tiền: " + product.getPriceSell() + " -Số lượng: " + product.getQuantity());
                    check = true;
                }
            }
            if (!check){
                System.out.println("--- Hiện không có sản phẩm nào thỏa mãn ---");
            }
        } catch (Exception e){
            System.out.println(" Nhập sai định dạng ");
        }
    }

    public void displayProductByManager(){
        readProduct();
        System.out.println("\n--- Danh sách các sản phẩm ---");
        for (Product product : products){
            System.out.println(product);
        }
    }

    public Product newProduct(){
        try {
            System.out.print(" \nNhập id sản phẩm: ");
            int id = inputInt.nextInt();
            if (findById(id) == -1){
                System.out.print(" Nhập tên sản phẩm: ");
                String name = inputString.nextLine();
                System.out.print(" Nhập giá nhập vào: ");
                double importPrice = inputDouble.nextDouble();
                System.out.print(" Nhập giá bán ra: ");
                double priceSell = inputDouble.nextDouble();
                System.out.print(" Nhập số lượng hàng còn lại: ");
                int quantity = inputInt.nextInt();
                System.out.print(" Nhập số lượng hàng đã nhập: ");
                int importQuantity = inputInt.nextInt();
                System.out.print(" Nhập số lượng hàng đã bán: ");
                int quantitysold = inputInt.nextInt();
                return new Product(id,name,importPrice,priceSell,quantity,importQuantity,quantitysold);
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        return null;
    }
    public int findById(int id){
        readProduct();
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()){
                return i;
            }
        }
        return -1;
    }

    public Product findProductById(){
        readProduct();
        try {
            System.out.print(" \nNhập id cần tìm: ");
            int id = inputInt.nextInt();
            for (Product product : products){
                if (id == product.getId()){
                    return product;
                }
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        return null;
    }

    public void findProduct(){
        Product product = findProductById();
        if (product != null){
            System.out.println("Mã sản phẩm: " + product.getId() + " -Tên sản phẩm: " + product.getName() + " -Giá bán: " + product.getPriceSell() + " -Số lượng còn lại: " + product.getQuantity());
        }
    }

    public void addNewProduct(){
        readProduct();
        Product newproduct = newProduct();
        if (newproduct != null){
            products.add(newproduct);
        } else {
            System.out.println("--- Id đã tồn tại ---");
        }
        writeProduct();
    }
    public void editImportPrice(){
        try {
            System.out.print(" Nhập id sản phẩm: ");
            int id = inputInt.nextInt();
            if (findById(id) != -1){
                System.out.println(products.get(findById(id)));
                System.out.print(" Sửa giá nhập: ");
                double importPrice = inputDouble.nextDouble();
                products.get(findById(id)).setImportPrice(importPrice);
            } else {
                System.out.println("--- Không tìm thấy id ---");
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeProduct();
    }
    public void editPriceSell(){
        try {
            System.out.print(" Nhập id sản phẩm: ");
            int id = inputInt.nextInt();
            if (findById(id) != -1){
                System.out.println(products.get(findById(id)));
                System.out.print("Sửa giá bán");
                double pricesell = inputDouble.nextDouble();
                products.get(findById(id)).setPriceSell(pricesell);
            } else {
                System.out.println("--- Không tìm thấy id ---");
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeProduct();
    }
    public void editQuantity(){
        try {
            System.out.print(" Nhập id sản phẩm: ");
            int id = inputInt.nextInt();
            if (findById(id) != -1){
                System.out.println(products.get(findById(id)));
                System.out.print(" Sửa số lượng hàng còn lại: ");
                int quantity = inputInt.nextInt();
                products.get(findById(id)).setQuantity(quantity);
            } else {
                System.out.println("--- Không tìm thấy id ---");
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeProduct();
    }
    public void editImportQuantity(){
        try {
            System.out.print(" Nhập id sản phẩm: ");
            int id = inputInt.nextInt();
            if (findById(id) != -1){
                System.out.println(products.get(findById(id)));
                System.out.print(" Sửa số lượng hàng đã nhập: ");
                int importQuantity = inputInt.nextInt();
                products.get(findById(id)).setImportQuantity(importQuantity);
            } else {
                System.out.println("--- Không tìm thấy id ---");
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeProduct();
    }
    public void editQuantitySold(){
        try {
            System.out.print(" Nhập id sản phẩm: ");
            int id = inputInt.nextInt();
            if (findById(id) != -1){
                System.out.println(products.get(findById(id)));
                System.out.print(" Sửa số lượng đã bán: ");
                int quantitySold = inputInt.nextInt();
                products.get(findById(id)).setQuantity(quantitySold);
            } else {
                System.out.println("--- Không tìm thấy id ---");
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeProduct();
    }

    public void removeProduct(){
        readProduct();
        System.out.print(" Nhập id sản phẩm bạn muốn xóa: ");
        try {
            int id = inputInt.nextInt();
            for (Product product : products){
                if (id == product.getId()){
                    products.remove(product);
                }
            }
        } catch (Exception e){
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeProduct();
    }
    public void readProduct(){
        products.clear();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("product.txt"))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] productList = line.split(",");
                int id = Integer.parseInt(productList[0].trim());
                String name = productList[1];
                double importPrice = Double.parseDouble(productList[2]);
                double priceSell = Double.parseDouble(productList[3]);
                int quantity = Integer.parseInt(productList[4]);
                int importQuantity = Integer.parseInt(productList[5]);
                int quantitySold = Integer.parseInt(productList[6]);
                products.add(new Product(id,name,importPrice,priceSell,quantity,importQuantity,quantitySold));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeProduct(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("product.txt"))) {
            for (Product product : products){
                bufferedWriter.write(product.getId() + "," + product.getName() + "," + product.getImportPrice() + "," + product.getPriceSell() + "," + product.getQuantity() + "," + product.getImportQuantity() + "," + product.getQuantitySold());
                bufferedWriter.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
