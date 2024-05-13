package controller_manager;

import Menu_account.MenuStaff;
import handle_account.HandleAccount;
import handle_product.HandleProduct;

import java.util.Scanner;

public class ControllerStaff {
    MenuStaff menuStaff = new MenuStaff();
    Scanner inputInt = new Scanner(System.in);
    HandleProduct handleProduct = new HandleProduct();
    HandleAccount handleAccount = new HandleAccount();
    public void controllerMenuStaff(){
        while (true){
            handleProduct.displayProductByClient();
            menuStaff.MenuStaffs();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        handleAccount.creatAccountClient();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        menuProductStaff();
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        handleAccount.editPasswordAccount();
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
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

    public void menuProductStaff(){
        while (true){
            handleProduct.displayProductByClient();
            menuStaff.MenuProducts();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        handleProduct.findProduct();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        return;
                    default:
                        System.out.println("------------------------------------------------");
                        System.out.println("----- Vui lòng nhập lại -----");
                        break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
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
