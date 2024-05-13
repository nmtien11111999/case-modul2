package Menu_account;

import controller_manager.ControllerClient;
import controller_manager.ControllerManager;
import controller_manager.ControllerStaff;
import handle_account.HandleAccount;
import handle_product.HandleProduct;

import java.util.Scanner;

public class Menu {
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ControllerManager controllerManager = new ControllerManager();
    ControllerClient controllerClient = new ControllerClient();
    ControllerStaff controllerStaff = new ControllerStaff();

    HandleAccount handleAccount = new HandleAccount();
    HandleProduct handleProduct = new HandleProduct();

    public void MainMenu(){
        while (true){
            ListChoice();
            try {
                switch (choice()){
                    case 1:
                        System.out.println("------------------------------------------------");
                        handleProduct.displayProductByClient();
                        break;
                    case 2:
                        System.out.println("------------------------------------------------");
                        handleAccount.creatAccountClient();
                        break;
                    case 3:
                        System.out.println("------------------------------------------------");
                        System.out.print(" Nhập tên đăng nhập: ");
                        String name = inputString.nextLine();
                        System.out.print(" Nhập mật khẩu: ");
                        String pass = inputString.nextLine();
                        signAccount(name , pass);
                        break;
                    case 4:
                        System.out.println("------------------------------------------------");
                        handleAccount.findPassWord();
                        break;
                    case 5:
                        System.out.println("------------------------------------------------");
                        return;
                    default:
                        System.out.println("--- Nhập sai định dạng ---");
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void ListChoice(){
        System.out.println("\n1. Danh sách sản phẩm");
        System.out.println("2. Đăng ký tài khoản");
        System.out.println("3. Đăng nhập");
        System.out.println("4. Quên mật khẩu");
        System.out.println("5. Thoát chương trình");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

    public void signAccount(String name , String pass){
        if (handleAccount.signInAccount(name,pass) != null){
            if (handleAccount.signInAccount(name,pass).getId().equals("UserManager")){
                controllerManager.controllerMenuManager();
            } else if (handleAccount.signInAccount(name,pass).getId().equals("UserStaff")) {
                controllerStaff.controllerMenuStaff();
            } else if (handleAccount.signInAccount(name,pass).getId().equals("UserClient")) {
                controllerClient.controllerMenuClient(name,pass);
            }
        } else {
            System.out.println("--- Sai mật khẩu hoặc tài khoản ---");
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
