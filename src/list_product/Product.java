package list_product;

public class Product {
    private int id;
    private String name;
    private double importPrice;
    private double priceSell;
    private int quantity;
    private int importQuantity;
    private int quantitySold;
    private String userName;

    public Product(){}

    public Product(String userName,int id,String name,double priceSell,int quantity){
        this.userName = userName;
        this.id = id;
        this.name = name;
        this.priceSell = priceSell;
        this.quantity = quantity;
    }
    public Product(int id, String name, double priceSell, int quantity){
        this.id = id;
        this.name = name;
        this.priceSell = priceSell;
        this.quantity = quantity;
    }

    public Product(int id, String name, double importPrice, double priceSell, int quantity, int importQuantity, int quantitySold) {
        this.id = id;
        this.name = name;
        this.importPrice = importPrice;
        this.priceSell = priceSell;
        this.quantity = quantity;
        this.importQuantity = importQuantity;
        this.quantitySold = quantitySold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(double priceSell) {
        this.priceSell = priceSell;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImportQuantity() {
        return importQuantity;
    }

    public void setImportQuantity(int importQuantity) {
        this.importQuantity = importQuantity;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "STT =" + id +
                ", Tên='" + name + '\'' +
                ", Giá nhập =" + importPrice +
                ", Giá bán =" + priceSell +
                ", Số lượng còn lại =" + quantity +
                ", Số lượng hàng đã nhập =" + importQuantity +
                ", Số lượng hàng đã bán =" + quantitySold +
                '}';
    }
}
