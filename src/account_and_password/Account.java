package account_and_password;

public class Account {
    private String id;
    private String name;
    private String password;
    private String userName;
    private String email;
    private String quest1;
    private String quest2;

    public Account(){}

    public Account(String id, String name, String password, String userName, String email, String quest1, String quest2) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.quest1 = quest1;
        this.quest2 = quest2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuest1() {
        return quest1;
    }

    public void setQuest1(String quest1) {
        this.quest1 = quest1;
    }

    public String getQuest2() {
        return quest2;
    }

    public void setQuest2(String quest2) {
        this.quest2 = quest2;
    }

    @Override
    public String toString() {
        return "Account{" +
                "người dùng = " + id +
                ", tên đăng nhập ='" + name + '\'' +
                ", mật khẩu ='" + password + '\'' +
                ", tên người dùng ='" + userName + '\'' +
                ", email ='" + email + '\'' +
                ", câu hỏi 1 ='" + quest1 + '\'' +
                ", câu hỏi 2 ='" + quest2 + '\'' +
                '}';
    }
}
