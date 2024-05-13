package handle_account;

import account_and_password.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HandleAccount {
    Scanner inputString = new Scanner(System.in);
    public List<Account> accounts = new ArrayList<>();
    Pattern pass = Pattern.compile("^([A-Z]+)(?=.*\\d)(?=.*[a-z])(?=.*[@#$%^&+=])[a-zA-Z\\d@#$%^&+=]{6,15}$");
    Pattern mail = Pattern.compile("^.*[a-zA-Z\\d](@gmail.com)+$");
    Pattern nameAccount = Pattern.compile("^.*\\w{6,10}$");

    public boolean creatNewName(String name) {
        readAccount();
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals(accounts.get(i).getName())) {
                return false;
            }
        }
        return true;
    }

    public Account signInAccount(String name, String pass) {
        readAccount();
        for (Account account : accounts) {
            if (account.getName().equals(name) && account.getPassword().equals(pass)) {
                return account;
            }
        }
        return null;
    }

    public String creatNewPassword() {
        try {
            System.out.print("\nTạo mật khẩu: ");
            String password = inputString.nextLine();
            if (!password.matches(String.valueOf(pass))) {
                throw new Exception();
            }
            return password;
        } catch (Exception e) {
            System.out.println("----- Nhập sai định dạng -----");
            System.out.println(" Mật khẩu của bận cần có từ 6-15 ký tự và k tự đầu tiên phải viết hoa và các ký tự sau câ có ít nhất 1 ký tự chữ viết thường và 1 ký tự số và 1 ký tự đặc biệt");
            return creatNewPassword();
        }
    }

    public String creatNewMail() {
        try {
            System.out.print("\nNhập email đăng ký: ");
            String email = inputString.nextLine();
            if (!email.matches(String.valueOf(mail))) {
                throw new Exception();
            }
            return email;
        } catch (Exception e) {
            System.out.println("----- Nhập sai định dạng -----");
            System.out.println("--- email của bạn cần có đuôi @gmail.com ở cuối và không được phép có ký tự đặc biệt ---");
            return creatNewMail();
        }
    }

    public void creatAccountStaff() {
        readAccount();
        while (true) {
            try {
                System.out.print("\nTạo tên đăng nhập: ");
                String name = inputString.nextLine();
                if (!name.matches(String.valueOf(nameAccount))) {
                    throw new Exception();
                }
                if (creatNewName(name)) {
                    String pass = creatNewPassword();
                    System.out.print(" Nhập tên người dùng: ");
                    String userName = inputString.nextLine();
                    String email = creatNewMail();
                    System.out.println("--- Câu hỏi bảo mật thứ 1 ---");
                    System.out.print(" Bạn sống ở đâu: ");
                    String quest1 = inputString.nextLine();
                    System.out.println("--- Câu hỏi bảo mật thứ 2 ---");
                    System.out.print(" Bạn thích làm gì: ");
                    String quest2 = inputString.nextLine();
                    accounts.add(new Account("UserStaff", name, pass, userName, email, quest1, quest2));
                    writeAccount();
                    System.out.println("--- Tạo thành công ---");
                    break;
                } else {
                    System.out.println("--- Tên đăng nhập đã tồn tại ---");
                    System.out.println("--- Vui lòng nhập lại ---");
                }
            } catch (Exception e) {
                System.out.println(" --- Tài khoản của bạn cần có ít nhất từ 6 đến 10 ký tự ---");
            }
        }
    }

    public void creatAccountClient() {
        readAccount();
        while (true) {
            try {
                System.out.print("\nTạo tên đăng nhập: ");
                String name = inputString.nextLine();
                if (!name.matches(String.valueOf(nameAccount))) {
                    throw new Exception();
                }
                if (creatNewName(name)) {
                    String pass = creatNewPassword();
                    System.out.print(" Nhập tên người dùng: ");
                    String userName = inputString.nextLine();
                    String email = creatNewMail();
                    System.out.println("--- Câu hỏi bảo mật thứ 1 ---");
                    System.out.print(" Bạn sống ở đâu: ");
                    String quest1 = inputString.nextLine();
                    System.out.println("--- Câu hỏi bảo mật thứ 2 ---");
                    System.out.print(" Bạn thích làm gì: ");
                    String quest2 = inputString.nextLine();
                    accounts.add(new Account("UserClient", name, pass, userName, email, quest1, quest2));
                    writeAccount();
                    System.out.println("--- Tạo thành công ---");
                    break;
                } else {
                    System.out.println("--- Tên đăng nhập đã tồn tại ---");
                    System.out.println("--- Vui lòng nhập lại ---");
                }
            } catch (Exception e) {
                System.out.println("--- Tài khoản của bạn cần có ít nhất từ 6 đến 10 ký tự ---");
            }
        }
    }

    public Account findByName(String name) {
        readAccount();
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals(accounts.get(i).getName())) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void displayAccountStaff() {
        readAccount();
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals("UserStaff")) {
                accountList.add(accounts.get(i));
                System.out.println("--- Danh sách các tài khoản nhân viên ---");
                System.out.println(" Tên đăng nhập của nhân viên: " + accounts.get(i).getName() + " -Tên người dùng cảu nhân viên: " + accounts.get(i).getUserName());
            }
        }
    }

    public void removeAccount() {
        readAccount();
        try {
            System.out.print(" Nhập tên cần xóa: ");
            String name = inputString.nextLine();
            if (findByName(name) != null && findByName(name).getId().equals("UserStaff")) {
                accounts.remove(findByName(name));
                System.out.println("--- Xóa thành công ---");
            } else {
                System.out.println("--- Tài khoản không tồn tại ---");
            }
        } catch (Exception e) {
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeAccount();
    }

    public void editPasswordAccount() {
        readAccount();
        try {
            System.out.print(" Nhập tên đăng nhập cần sửa: ");
            String name = inputString.nextLine();
            System.out.print(" Nhập mật khẩu cũ: ");
            String passwordOld = inputString.nextLine();
            if (findByName(name) != null && findByName(name).getPassword().equals(passwordOld)) {
                System.out.print(" Nhập mật khẩu mới: ");
                String passwordNew = inputString.nextLine();
                if (!passwordNew.matches(String.valueOf(pass))){
                    throw new Exception();
                }
                findByName(name).setPassword(passwordNew);
                System.out.println("--- Sửa thành công ---");
            } else {
                System.out.println("--- Sai tên đăng nhập hoặc mật khẩu ---");
            }
        } catch (Exception e) {
            System.out.println("--- Nhập sai định dạng ---");
        }
        writeAccount();
    }

    public void findByNameStaff() {
        readAccount();
        List<Account> findAccountStaff = new ArrayList<>();
        System.out.print(" Nhập tên đăng nhập của nhân viên cần tìm: ");
        try {
            String name = inputString.nextLine().toLowerCase();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getId().equals("UserStaff") && accounts.get(i).getName().toLowerCase().contains(name)) {
                    findAccountStaff.add(accounts.get(i));
                }
            }
            if (findAccountStaff.isEmpty()) {
                System.out.println("--- Không tìm thấy tài khoản nhân viên ---");
            } else {
                System.out.println("--- Danh sách nhân viên tìm thấy ---");
                for (Account account : findAccountStaff) {
                    System.out.println("Tên đăng nhập của nhân viên: " + account.getName() + " -Tên người dùng của nhân viên: " + account.getUserName());
                }
            }
        } catch (Exception e) {
            System.out.println("--- Nhập sai đinnh dạng ---");
        }
    }

    public void findByNameClient() {
        readAccount();
        List<Account> findAccountStaff = new ArrayList<>();
        System.out.print(" Nhập tên đăng nhập của khách hàng cần tìm: ");
        try {
            String name = inputString.nextLine().toLowerCase();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getId().equals("UserClient") && accounts.get(i).getName().toLowerCase().contains(name)) {
                    findAccountStaff.add(accounts.get(i));
                }
            }
            if (findAccountStaff.isEmpty()) {
                System.out.println("--- Không tìm thấy tài khoản khách hàng ---");
            } else {
                System.out.println("--- Danh sách khách hàng tìm thấy ---");
                for (Account account : findAccountStaff) {
                    System.out.println("Tên đăng nhập của khách hàng: " + account.getName() + " -Tên người dùng của khách hàng: " + account.getUserName());
                }
            }
        } catch (Exception e) {
            System.out.println("Nhập sai định dạng");
        }
    }

    public Account forgotPass() {
        readAccount();
        try {
            System.out.print(" Nhập tên đăng nhập: ");
            String name = inputString.nextLine();
            System.out.println("--- Câu gỏi bảo mật 1 ---");
            System.out.println("- Bạn sống ở đâu -");
            System.out.print(" Nhập câu trả lời của câu hỏi bảo mật 1: ");
            String quest1 = inputString.nextLine();
            System.out.println("--- Câu hỏi bảo mật 2 ---");
            System.out.println("- Bạn thích làm gì -");
            System.out.print(" Nhập câu trả lời của câu hỏi bảo mật 2: ");
            String quest2 = inputString.nextLine();
            for (Account account : accounts) {
                if (account.getName().equals(name) && account.getQuest1().equals(quest1) && account.getQuest2().equals(quest2)) {
                    return account;
                }
            }
        } catch (Exception e) {
            System.out.println("--- Nhập sai định dạng ---");
        }
        return null;
    }

    public void findPassWord(){
        Account account = forgotPass();
        if (account != null){
            System.out.println(" Mật khẩu của bạn là: " + account.getPassword());
        } else {
            System.out.println(" Tài khoản không tồn tại ");
        }
    }

    public void readAccount() {
        accounts.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("account.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");
                String id = tokens[0].trim();
                String name = tokens[1].trim();
                String password = tokens[2].trim();
                String userName = tokens[3].trim();
                String email = tokens[4].trim();
                String quest1 = tokens[5].trim();
                String quest2 = tokens[6].trim();
                accounts.add(new Account(id, name, password, userName, email, quest1, quest2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeAccount() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("account.txt"))) {
            for (Account account : accounts) {
                bufferedWriter.write(account.getId() + "," + account.getName() + "," + account.getPassword() + "," +
                        account.getUserName() + "," + account.getEmail() + "," + account.getQuest1() + "," + account.getQuest2());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
