package controller_manager;

import Menu_account.MenuClient;
import handle_account.HandleAccount;
import handle_cart_product.HandleCartProduct;
import handle_cart_product.HandleProductSold;
import handle_product.HandleProduct;

import java.util.Scanner;

public class ControllerClient {
    Scanner inputInt = new Scanner(System.in);
    MenuClient menuClient = new MenuClient();
    HandleProduct handleProduct = new HandleProduct();
    HandleAccount handleAccount = new HandleAccount();
    HandleCartProduct handleCartProduct = new HandleCartProduct();
    HandleProductSold handleProductSold = new HandleProductSold();

    public void controllerMenuClient(String name, String pass){
        while (true){
            handleProduct.displayProductByClient();
            menuClient.MenuClients();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        cart(name,pass);
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        handleProduct.displayProductByClient();
                        handleCartProduct.addCartProduct(name,pass);
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        handleProduct.findProduct();
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        handleAccount.editPasswordAccount();
                        break;
                    case 5:
                        System.out.println("------------------------------------------------");
                        handleProduct.arangeProduct();
                        break;
                    case 6:
                        System.out.println("------------------------------------------------");
                        handleProduct.arrangeProductMax();
                        break;
                    case 7:
                        System.out.println("------------------------------------------------");
                        handleProduct.arrangeProductMin();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("------------------------------------------------");
                        System.out.println("----- Vui lòng nhập lại -----");
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void cart(String name , String pass){
        handleCartProduct.displayCart(name,pass);
        menuClient.MenuProducts();
        try {
            switch (choice()){
                case 1:
                    System.out.println("------------------------------------------------");
                    handleCartProduct.payProduct(name,pass);
                    break;
                case 2:
                    System.out.println("------------------------------------------------");
                    handleCartProduct.removeCartProduct();
                    break;
                case 3:
                    System.out.println("------------------------------------------------");
                    handleProductSold.displayProductClient(name,pass);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("----- Vui lòng nhập lại -----");
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int choice(){
        int choice;
        try {
            choice = inputInt.nextInt();
            return choice;
        } catch (Exception e){
            inputInt.nextLine();
            return -1;
        }
    }
}
