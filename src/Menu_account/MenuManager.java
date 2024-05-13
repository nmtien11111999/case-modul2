package Menu_account;

public class MenuManager {
    public void MenuManagers(){
        System.out.println("\n1. Quản lý nhân viên ");
        System.out.println("2. Quản lý khách hàng ");
        System.out.println("3. Quản lý Manager ");
        System.out.println("4. Quản lý sản phẩm ");
        System.out.println("5. Thoát chương trình ");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

    public void ManagerStaffs(){
        System.out.println("\n1. Tạo tài khoản nhân viên ");
        System.out.println("2. Xóa tài khoản nhân viên ");
        System.out.println("3. Danh sách nhân viên ");
        System.out.println("4. Tìm kiếm tài khoản nhân viên");
        System.out.println("5. Quay lại ");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

    public void ManagerClients(){
        System.out.println("\n1. Tạo tài khoản khách hàng ");
        System.out.println("2. Tìm kiếm tài khoản khách hàng");
        System.out.println("3. Lịch sử mua ");
        System.out.println("4. Quay lại ");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

    public void ManagerManager(){
        System.out.println("\n1. Sửa lại tên tài khoản");
        System.out.println("2. Sửa lại mật khẩu");
        System.out.println("3. Quay lại");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

    public void ManagerProduct(){
        System.out.println("\n1. Sửa thông tin sản phẩm ");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Thêm sản phẩm");
        System.out.println("4. Danh sách sản phẩm ");
        System.out.println("5. Quay lại ");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

    public void editProductManager(){
        System.out.println("\n1. Sửa giá nhập");
        System.out.println("2. Sửa giá bán");
        System.out.println("3. Sửa số lượng còn lại");
        System.out.println("4. Sửa số lượng đã nhập");
        System.out.println("5. Sửa số lượng đã bán");
        System.out.println("6. Quay lại");
        System.out.print(" \n Vui lòng nhập lựa chọn: ");
    }

}