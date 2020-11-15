import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //задача 2
        System.out.println("Введите строку:");
        String str = in.nextLine();
        System.out.println(findZip(str));

        //задача 4
        System.out.println("Введите строку:");
        String str1 = in.nextLine();
        System.out.println(flipEndChars(str1));

        //задача 5
        System.out.println("Введите шестнадцатеричный код:");
        String str2 = in.nextLine();
        System.out.println(isValidHexCode(str2));

        //задача 6
        System.out.println("Введите два массива:");
        String[] strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas1 = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++)
        {
            mas1.add(Integer.parseInt(strArr[i]));
        }
        strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas2 = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++)
        {
            mas2.add(Integer.parseInt(strArr[i]));
        }
        System.out.println(same(mas1, mas2));

        //задача 8
        System.out.println("Введите двоичное число:");
        String str11 = in.nextLine();
        System.out.println(longestZero(str11));

        //задача 7
        System.out.println("Введите число:");
        int n11 = in.nextInt();
        System.out.println(isKaprekar(n11));

        //задача 9
        System.out.println("Введите число:");
        int number1 = in.nextInt();
        System.out.println(nextPrime(number1));

        //задача 10
        System.out.println("Введите стороны треугольника:");
        ArrayList<Integer> mas111 = new ArrayList<>(3);
        mas111.add(in.nextInt());
        mas111.add(in.nextInt());
        mas111.add(in.nextInt());
        System.out.println(rightTriangle(mas111));

        //задача 1
        System.out.println("Введите значения a, b и c:");
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        int c1 = in.nextInt();
        System.out.println(solutions(a1, b1, c1));

        //задача 3
        System.out.println("Введите число:");
        int num11 = in.nextInt();
        System.out.println(checkPerfect(num11));
    }

    public static int solutions(int a, int b, int c)
    {
        //квадратное уравнение количество решений
        double d = b*b - 4*a*c;
        if (d < 0)
        {
            return 0;
        }
        else if (d == 0)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    public static int findZip(String str)
    {
        // найти второе вхождение зип
        return str.indexOf("zip", str.indexOf("zip")+3);
    }

    public static boolean checkPerfect(int num)
    {
        // находим делители и проверяем являетс ли их сумма числом
        int sum = 1;
        int n = (int)Math.ceil(Math.sqrt(num)); // округление вверх

        for (int i = 2; i < n; i++)
        {
            if (num % i == 0)
            {
                n = num / i;
                sum += i;
                sum += n;

                if (sum > num)
                {
                    return false;
                }
            }
        }

        if (sum != num)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static String flipEndChars(String str)
    {
        //– Если длина строки меньше двух, верните "несовместимо".".
        //– Если первый и последний символы совпадают, верните "два-это пара.".
        if (str.length() < 2)
        {
            return "Incompatible.";
        }

        char cBegin = str.charAt(0);
        char cEnd = str.charAt(str.length()-1);
        if (cBegin == cEnd)
        {
            return "Two's a pair.";
        }

        return cEnd + str.substring(1, str.length()-1) + cBegin;
    }

    public static boolean isValidHexCode(String str)
    {
        //начало с # , длина 6, числа, буквы
        if (str.length() != 7 || str.charAt(0) != '#')
        {
            return false;
        }

        for (int i = 1; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F') && (ch < 'a' || ch > 'f'))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean same(ArrayList<Integer> mas1, ArrayList<Integer> mas2)
    {
        // сравниваем количество уникальных элементов массивов
        // hashset -уникальные элементы
        if ((new HashSet<Integer>(mas1)).size() == (new HashSet<>(mas2)).size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isKaprekar(int n)
    {
        //которое после возведения в квадрат и разбиения на две лексикографические
        // части равно сумме двух полученных новых чисел:
        String nn = Integer.toString(n*n);
        String str = "";
        //добавляем 0 если число из 1 цифры
        if (nn.length() == 1)
        {
            str += "0";
        }
        str += nn;
        //находим центр
        int end = str.length()/2;
        // разбиваем
        int n1 = Integer.parseInt(str.substring(0, end));
        int n2 = Integer.parseInt(str.substring(end, str.length()));

        if (n1 + n2 == n)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String longestZero(String str)
    {
        // самая длинная последовательность нулей
        String[] strArr = str.split("1");// разбиваем на массив групп нулей
        //находим самню большую группу
        String res = "";
        for (String val : strArr)
        {
            if (val.length() > res.length())
            {
                res = val;
            }
        }

        return res;
    }

    public static int nextPrime(int n)
    {
        //следующее простое число
        if (n == 2)
        {
            return n;
        }
//рассматриваем только четные числа
        if (n % 2 == 0)
        {
            n++;
        }

        while (true)
        {
            int end = (int)Math.ceil(Math.sqrt(n));
            int i;
            for (i = 2; i <= end; i++)
            //проверяем на наличие делителей
            {
                if (n % i == 0)
                {
                    break;
                }
            }

            if (i == end+1)
            {
                break;
            }
            else//следующее четное
            {
                n += 2;
            }
        }

        return n;
    }

    public static boolean rightTriangle(ArrayList<Integer> mas)
    {
        // проверка по формуле
        //являются ли сторонами прямоугольного треугольника
        Collections.sort(mas);
        int a = mas.get(0);
        int b = mas.get(1);
        int c = mas.get(2);

        if (a*a + b*b == c*c)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
