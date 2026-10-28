import java.util.Objects;

public class Goods {
    private String name;          
    private String date;          
    private double price;          
    private int quantity;         
    private String invoiceNumber; 

    public static int count = 0;

    {
        count++;
    }

    public Goods() {
        this.name = "Невідомо";
        this.date = "01.01.2026";
        this.price = 0.0;
        this.quantity = 0;
        this.invoiceNumber = "000";
    }

    public Goods(String name, String date, double price, int quantity, String invoiceNumber) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.invoiceNumber = invoiceNumber;
    }

    public static int getCount() {
        return count;
    }

    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    public void changeQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public double getCost() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "Товар: " + name + ", Дата: " + date + ", Ціна: " + price + 
               ", Кількість: " + quantity + ", Накладна №: " + invoiceNumber + 
               ", Загальна вартість: " + getCost();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Goods goods = (Goods) obj;
        return Double.compare(goods.price, price) == 0 &&
               quantity == goods.quantity &&
               Objects.equals(name, goods.name) &&
               Objects.equals(date, goods.date) &&
               Objects.equals(invoiceNumber, goods.invoiceNumber);
    }
}