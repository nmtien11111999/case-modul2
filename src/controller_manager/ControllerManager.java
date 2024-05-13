package controller_manager;

import Menu_account.MenuManager;
import handle_account.HandleAccount;
import handle_cart_product.HandleProductSold;
import handle_product.HandleProduct;

import java.util.Scanner;

public class ControllerManager {
    Scanner inputInt = new Scanner(System.in);
    MenuManager menuManager = new MenuManager();
    HandleAccount handleAccount = new HandleAccount();
    HandleProduct handleProduct = new HandleProduct();
    HandleProductSold handleProductSold = new HandleProductSold();
    public void controllerMenuManager(){
        while (true){
            menuManager.MenuManagers();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        controllerManagerStaffs();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        controllerManagerClient();
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        controllerManagerManager();
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        controllerManagerProduct();
                        break;
                    case 5:
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

    public void controllerManagerStaffs(){
        while (true){
            menuManager.ManagerStaffs();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        handleAccount.creatAccountStaff();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        handleAccount.removeAccount();
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        handleAccount.displayAccountStaff();
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        handleAccount.findByNameStaff();
                        break;
                    case 5:
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

    public void controllerManagerClient(){
        while (true){
            menuManager.ManagerClients();
            try {
                switch (choice()){
                    case 1:
                        handleAccount.creatAccountClient();
                        System.out.println("------------------------------------------------");
                        break;
                    case 2:
                        handleAccount.findByNameClient();
                        System.out.println("------------------------------------------------");
                        break;
                    case 3:
                        handleProductSold.displayProductSoldManager();
                        System.out.println("------------------------------------------------");
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
    }

    public void controllerManagerManager(){
        while (true){
            menuManager.ManagerManager();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        break;
                    case 3:
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

    public void controllerManagerProduct(){
        while (true){
            menuManager.ManagerProduct();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        editProduct();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        handleProduct.removeProduct();
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        handleProduct.addNewProduct();
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        handleProduct.displayProductByManager();
                        break;
                    case 5:
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

    public void editProduct(){
        while (true){
            handleProduct.displayProductByManager();
            menuManager.editProductManager();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        handleProduct.editImportPrice();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        handleProduct.editPriceSell();
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        handleProduct.editQuantity();
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        handleProduct.editImportQuantity();
                        break;
                    case 5:
                        System.out.println("------------------------------------------------");
                        handleProduct.editQuantitySold();
                        break;
                    case 6:
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
