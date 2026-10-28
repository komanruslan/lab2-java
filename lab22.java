import java.util.Locale;
import java.util.Scanner;

public class lab22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); 

        System.out.println(" Завдання 2 (Варіант 8: Конус) ");
        
        System.out.print("Введіть висоту конуса: ");
        double height = scanner.nextDouble();

        System.out.print("Введіть радіус основи конуса: ");
        double radius = scanner.nextDouble();

        Cone cone = new Cone(height, radius);

        System.out.println("\n Результати ");
        System.out.println(cone.toString());
        System.out.printf("Площа бічної поверхні: %.2f\n", cone.getLateralArea());
        System.out.printf("Об'єм конуса: %.2f\n", cone.getVolume());
        System.out.println("Всього створено конусів: " + Cone.getConeCount());

        scanner.close();
    }
}