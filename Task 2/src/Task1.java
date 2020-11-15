import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //задача 2
        System.out.println("Введите числа:");
        String[] strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++)
        {
            mas.add(Integer.parseInt(strArr[i]));
        }
        System.out.println(differenceMaxMin(mas));


        //задача 3
        System.out.println("Введите массив:");
        String[] stringArray = in.nextLine().split(" ");
        ArrayList<Integer> massiv = new ArrayList<>(stringArray.length);
        for (int i = 0; i < stringArray.length; i++)
        {
            massiv.add(Integer.parseInt(stringArray[i]));
        }
        System.out.println(isAvgWhole(massiv));

        //задача 4
        System.out.println("Введите массив чисел:");
        String[] stringArray1 = in.nextLine().split(" ");
        ArrayList<Integer> massiv1 = new ArrayList<>();
        for (int i = 0; i < stringArray1.length; i++)
        {
            massiv1.add(Integer.parseInt(stringArray1[i]));
        }
        cumulativeSum (massiv1);

        //задача 7
        System.out.println("Введите почтовый индекс:");
        String strr = in.nextLine();
        System.out.println(isValid(strr));

        //задача 5
        System.out.println("Введите число:");
        String str = in.next();
        System.out.println(getDecimalPlaces(str));

        //задача 1
        System.out.println("Введите строку и число:");
        String line = in.next();
        int number = in.nextInt();
        System.out.println(repeat(line, number ));

        //задача 6
        System.out.println("Введите номер числа Фибоначчи:");
        int numberr = in.nextInt();
        System.out.println(fibonacci(numberr));

        //задача 8
        System.out.println("Введите два слова:");
        String word1 = in.next();
        String word2 = in.next();
        System.out.println(isStrangePair(word1, word2));

        //задача 10
        System.out.println("Введите номер шага:");
        int nn = in.nextInt();
        System.out.println(boxSeq(nn));

        //задача 9
        System.out.println("Введите слово и префикс/суффикс:");
        String word11 = in.next();
        String str11 = in.next();
        if (str.charAt(0) == '-')
        {
            System.out.println(isSuffix(word11, str11));
        }
        else
        {
            System.out.println(isPrefix(word11, str11));
        }
    }



    public static String repeat(String str, int n)
    {
        // повторяем символы в строке
        String res = "";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            for (int j = 0; j < n; j++)
            {
                res += ch;
            }
        }

        return res;
    }

    public static int differenceMaxMin(ArrayList<Integer> mas)
    {
        // Разница между мин и мах
        Iterator<Integer> it = mas.iterator();
        int max = it.next();
        int min = max;
        while (it.hasNext())
        {
            int val = it.next();
            if (val > max)
            {
                max = val;
            }
            else if (val < min)
            {
                min = val;
            }
        }

        return max - min;
    }

    public static boolean isAvgWhole(ArrayList<Integer> massiv)
            //Является ли среднее значение целым?
    {
        int sum = 0;
        for (int val : massiv)
        {
            sum += val;
        }

        if (sum % massiv.size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void cumulativeSum (ArrayList<Integer> mas)
    {
        // создание массива из сумм
        int sum = 0;
        String res="";
        ListIterator<Integer> it = mas.listIterator();
        while (it.hasNext())
        {
            sum += it.next();
            it.set(sum);
            System.out.print(sum);
            System.out.print("");
        }
    }

    public static int getDecimalPlaces(String str) {
        // считаем цифры после запятой
        if (str.contains(".")) {
            return str.length() - 1 - str.indexOf('.');
        } else {
            return 0;
        }
    }

    public static int fibonacci(int n)
    {
        // число фиббоначи
        switch (n)
        {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int a = 1;
                int b = 2;
                int res;
                for (int i = 3; i < n; i++)
                {
                    res = a + b;
                    a = b;
                    b = res;
                }
                return a + b;
        }
    }

    public static boolean isValid(String str)
    {
        //проверка длина 5, без пробелов, только цифры
        if (str.length() != 5)
        {
            return false;
        }

        for (int i = 0; i < 5; i++)
        {
            if (str.codePointAt(i) < '0' || str.codePointAt(i) > '9')
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isStrangePair(String str1, String str2)
    {
        //Первая буква 1-й строки = последняя буква 2-й строки.
        //Последняя буква 1-й строки = первая буква 2-й строки.

        if (str1.charAt(0) == str2.charAt(str2.length()-1) && str1.charAt(str1.length()-1) == str2.charAt(0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isPrefix(String word, String str)
    {
        str = str.substring(0, str.length()-1);
        if (word.startsWith(str))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isSuffix(String word, String str)
    {
        str = str.substring(1);
        if (word.endsWith(str))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int boxSeq(int n)
    {
        if (n % 2 == 0)
        {
            return n;
        }
        else
        {
            return n+2;
        }
    }
}
