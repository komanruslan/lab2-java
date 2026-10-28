import java.util.Objects;

public class Cone {
    // Поля класу
    private double height; 
    private double radius; 

    private static int coneCount = 0;

    {
        coneCount++;
    }

    public Cone() {
        this.height = 1.0;
        this.radius = 1.0;
    }

    public Cone(double height, double radius) {
        if (height <= 0 || radius <= 0) {
            System.out.println("Помилка: Висота та радіус мають бути більшими за 0! Встановлено значення за замовчуванням (1.0).");
            this.height = 1.0;
            this.radius = 1.0;
        } else {
            this.height = height;
            this.radius = radius;
        }
    }

    public static int getConeCount() {
        return coneCount;
    }

    public double getLateralArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * slantHeight;
    }

    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return String.format("Конус [Висота: %.2f, Радіус: %.2f | Площа бічна: %.2f, Об'єм: %.2f]",
                height, radius, getLateralArea(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cone cone = (Cone) obj;
        return Double.compare(cone.height, height) == 0 &&
               Double.compare(cone.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, radius);
    }
}