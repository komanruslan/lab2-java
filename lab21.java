import java.util.Scanner;

 public class lab21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Введення даних про товар ");
        System.out.print("Введіть назву товару: ");
        String name = scanner.nextLine();

        System.out.print("Введіть дату оформления (наприклад, xx.xx.xxxx): ");
        String date = scanner.nextLine();

        System.out.print("Введіть ціну товару: ");
        double price = scanner.nextDouble();

        System.out.print("Введіть кількість одиниць: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Введіть номер накладної: ");
        String invoiceNumber = scanner.nextLine();

        Goods item1 = new Goods(name, date, price, quantity, invoiceNumber);
        
        System.out.println("\n Інформація про створений товар ");
        System.out.println(item1.toString());

        System.out.println("\n Оновлення даних про товар ");
        System.out.print("Введіть нову ціну товару: ");
        double newPrice = scanner.nextDouble();
        item1.changePrice(newPrice);

        System.out.print("Введіть нову кількість товару: ");
        int newQuantity = scanner.nextInt();
        item1.changeQuantity(newQuantity);

        System.out.println("\n Оновлена інформація про товар ");
        System.out.println(item1.toString());
        System.out.println("Розрахована загальна вартість: " + item1.getCost());

        Goods item2 = new Goods(); 
        System.out.println("\nВсього створено об'єктів Goods: " + Goods.getCount());

        scanner.close();
    }
}