
import java.util.Scanner;

public class Class1 {
    public static int remainder(int a, int b)
    {
        return a % b;
    }

    public static double triArea(double a, double b)
    {
        return a * b / 2;
    }

    public static int animals(int a, int b, int c) {
        return (2 * a) + (4 * (b + c));
    }

    public static boolean profitableGamble(double prob, double prize, double pay)
    {
        return (prob * prize > pay);
    }

    public static String operation(int N, int a, int b)
    {
        if (N == a + b)
            return "added";
        else if (N == a - b)
            return "substracted";
        else if (N == a * b)
            return "multiplied";
        else if (N == a / b)
            return "divided";
        else return "None";
    }

    public static int ctoa(String a)
    {
        char ans = a.charAt(0);
        return (int) ans;
    }

    public static int addUpTo(int n) {
        int a = 0;
        for (int i = 1; i <= n; i++)
            a = a + i;
        return a;
    }

    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }

    public static double sumOfCubes(int[] cubes) {
        double sum = 0;
        for (int i = 0; i < cubes.length; i++) {
            System.out.println(cubes[i]);
            sum += Math.pow(cubes[i], 3);
        }
        return sum;
    }

    public static boolean abcmath(int a, int b, int c){
        int result = a;
        for (int i = 0; i < b; i++) {
            result += result;
        }
        if (result % c == 0)
            return true;
        else return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 1
        System.out.println("Введите числа a и b");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(remainder(a, b));

        //task 2
        //System.out.println("Введите высоту и основание треугольника");
        //double c = scanner.nextInt();
        //double d = scanner.nextInt();
        //double ans = triArea(c, d);
        //System.out.println(ans);

        //task 3
        //System.out.println("Введите количество куриц, коров и свиней");
        //int a12 = scanner.nextInt();
        //int b12 = scanner.nextInt();
        //int c12 = scanner.nextInt();
        //int ans1 = animals(a12, b12, c12);
        // System.out.println(ans1);

        //task 4

        // System.out.println("Введите prob, prize,  pay");
        // double prob = scanner.nextDouble();
        //double prize = scanner.nextDouble();
        //double pay = scanner.nextDouble();
        //System.out.println(profitableGamble(prob, prize, pay));

        //task 5

        //System.out.println("Введите числа N, a, b");
        //int N = scanner.nextInt();
        //int a2 = scanner.nextInt();
        //int b2 = scanner.nextInt();
        //System.out.println(operation(N, a2, b2));



        //task 7

        //System.out.println("Введите последнее число массива");
        //int n = scanner.nextInt();
        //System.out.println(addUpTo(n));

        //task 8

        // System.out.println("Введите две стороны треугольника");
        //int aa = scanner.nextInt();
        //int bb = scanner.nextInt();
        //System.out.println(nextEdge(aa, bb));

        //task 9

        //System.out.println("Введите размер массива");
        //int size = scanner.nextInt();
        //int cubes[] = new int[size];
        //System.out.println("Введите числа массива");
        //for (int i = 0; i < size; i++) {
        //cubes[i] = scanner.nextInt();
        //}
        //System.out.println((int)sumOfCubes(cubes));

        //task 10

        //System.out.println("Введите a, b и c");

        //int as = scanner.nextInt();
        //int bs = scanner.nextInt();
        //int cs = scanner.nextInt();

        //System.out.println(abcmath(as, bs, cs));

        //task 6

        //System.out.println("Введите символ");
        //String a35 = scanner.nextLine();
        //System.out.println(ctoa(a35));
    }
}
