public class Main {

    public static void greet(String name) {
        System.out.println("Hello, " + name + "! Welcome to Git Skill Lab.");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        greet("Student");

        int result = add(10, 20);
        System.out.println("Sum of 10 + 20 = " + result);

        int product = multiply(5, 6);
        System.out.println("Product of 5 * 6 = " + product);

        System.out.println("This is the feature-update branch.");
    }
}