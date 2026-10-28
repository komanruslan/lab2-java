import java.util.Scanner;
import java.util.Stack;

public class lab31 {

    public static int evaluate(String expression) {
        expression = expression.replaceAll("\\s+", "");

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--; 
                numbers.push(Integer.parseInt(sb.toString()));
            }
            else if (ch == '+' || ch == '-' || ch == '*') {
                while (!operations.isEmpty() && hasPrecedence(ch, operations.peek())) {
                    numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
                }
                operations.push(ch);
            }
        }


        while (!operations.isEmpty()) {
            numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Завдання 3 (Варіант 8: Обчислення виразу) ===");
        System.out.print("Введіть арифметичний вираз (наприклад, 2+3*4-5): ");
        String input = scanner.nextLine();

        try {
            int result = evaluate(input);
            System.out.println("Результат обчислення: " + result);
        } catch (Exception e) {
            System.out.println("Помилка при обчисленні виразу! Перевірте коректність введення.");
        }

        scanner.close();
    }
}