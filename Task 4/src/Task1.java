import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Task1 {
    public static final int G_START = 9;
    public static final int G_FINISH = 17;
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        // Задача 2
        System.out.println("Введите строку:");
        String str = in.nextLine();
        System.out.println(split(str));

        // Задача 7
        System.out.println("Введите строку:");
        String str2 = in.nextLine();
        System.out.println(toStarShorthand(str2));

        // Задача 8
        System.out.println("Введите две строки:");
        String str11 = in.nextLine();
        String str22 = in.nextLine();
        System.out.println(doesRhyme(str11, str22));

        // Задача 10
        System.out.println("Введите последовательность символов и символ, обозначающий начало/конец книги:");
        String str111 = in.nextLine();
        String endChar = in.nextLine();
        System.out.println(countUniqueBooks(str111, endChar));

        // Задача 3
        System.out.println("Введите строку:");
        String str14 = in.next();
        if (str.indexOf('_') != -1)
        {
            System.out.println(toCamelCase(str14));
        }
        else
        {
            System.out.println(toSnakeCase(str14));
        }

        // Задача 9
        System.out.println("Введите два числа:");
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(trouble(a, b));

        // Задача 6
        System.out.println("Введите число:");
        int n = in.nextInt();
        System.out.println(bugger(n));

        // Задача 1
        System.out.println("Введите количество слов и размер строки:");
        int nn = in.nextInt();
        int k = in.nextInt();
        ArrayList<String> strArr = new ArrayList<>(nn);
        System.out.println("Введите текст:");
        for (int i = 0; i < nn; i++)
        {
            strArr.add(in.next());
        }
        System.out.println(essay(k, strArr));

        // Задача 4
        System.out.println("Введите 4 значения:");
        double start = in.nextDouble();
        double finish = in.nextDouble();
        double rate = in.nextDouble();
        double mult = in.nextDouble();
        System.out.println(overTime(start, finish, rate, mult));

        // Задача 5
        System.out.println("Введите рост и вес:");
        double h = in.nextDouble();
        double w = in.nextDouble();
        System.out.println(BMI(h, w));
    }

    public static String essay(int k, ArrayList<String> strArr)
    {
        //разбить строку на строчки с заданной длиной
        String res = "";
        int count = k;
        Iterator<String> it = strArr.iterator();

        String val = it.next();//добавляем первое слово
        res += val + " ";
        count -= val.length();//вычистаем его длину
        while (it.hasNext())
        {
            val = it.next();
            if (count < val.length())//если следубщее слово не умещается
            {
                res += '\n';//переходим на новую строку
                count = k;
            }
            res += val + " ";
            count -= val.length();
        }

        return res;
    }

    public static String split(String str)
    {
        //разделяем на кластеры скобок
        String res = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            //считаем количество ( и ) , когда одинаково ставим пробел
            char ch = str.charAt(i);
            res += ch;

            if (ch == '(')
            {
                count++;
            }
            else
            {
                count--;
            }

            if (count == 0)
            {
                res += ' ';
            }
        }

        return res;
    }

    public static String toSnakeCase(String str)
    {
        //добавить _ перед большой буквой
        String res = "";

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')//находим большую букву
            {
                res += '_';
                res += (char)(ch+32);
            }
            else
            {
                res += ch;
            }
        }

        return res;
    }

    public static String toCamelCase(String str)
    {
        String res = "";
        boolean newWord = false;

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '_')
            {
                newWord = true;
            }
            else if (newWord)
            {
                newWord = false;
                res += (char)(ch-32);
            }
            else
            {
                res += ch;
            }
        }

        return res;
    }

    public static String overTime(double start, double finish, double rate, double mult)
    {
        double reg = 0;
        double over = 0;

        if (start < G_START && finish < G_START)
        {
            over = finish - start;
        }
        else if (start < G_START && finish >= G_START && finish <= G_FINISH)
        {
            over = G_START - start;
            reg = finish - G_START;
        }
        else if (start < G_START && finish > G_FINISH)
        {
            over = G_START - start + finish - G_FINISH;
            reg = G_START + G_FINISH;
        }
        else if (start >= G_START && start <= G_FINISH && finish >= G_START && finish <= G_FINISH)
        {
            reg = finish - start;
        }
        else if (start >= G_START && start <= G_FINISH && finish > G_FINISH)
        {
            reg = G_FINISH - start;
            over = finish - G_FINISH;
        }
        else
        {
            over = finish - start;
        }

        return "$" + String.format("%.2f", reg*rate + over*rate*mult);
    }

    public static String BMI(double h, double w)
    {
        //сравнивается индекс массы с нормами
        double val = w / (h*h); //индекс массы
        String res = String.format("%.1f", val);
        if (val < 18.5)
        {
            res += " Underweight";
        }
        else if (val >= 18.5 && val < 25)
        {
            res += " Normal weight";
        }
        else
        {
            res += " Overweight";
        }

        return res;
    }

    public static int bugger(int n)
    {
        //найти количество раз, которое вы должны умножать цифры в num, пока не достигнете одной цифры
        int count = 0;
        String str = Integer.toString(n);

        while (str.length() > 1)
        {
            count++;

            int val = 1;
            for (int i = 0; i < str.length(); i++)
            {
                val *= Integer.parseInt((str.substring(i, i+1)));//вырезаем цифру и умножаем
            }

            str = Integer.toString(val);//берем новое число
        }

        return count;
    }

    public static String toStarShorthand(String str)
    {
        //если символы повторяются заменяем на звездочку и колво повторений
        String res = "";
        int count = 1;
        char ch = '\0';

        for (int i = 0; i < str.length(); i++)
        {
            char newCh = str.charAt(i);

            if (newCh == ch)//если символ повторился считаем сколько раз
            {
                count++;
            }
            else//если символ не повторился
            {
                if (count != 1)//если надо указать колво
                {
                    res += '*';
                    res += Integer.toString(count);
                    count = 1;
                }
                res += newCh;
                ch = newCh;
            }
        }
        if (count != 1)
        {
            res += '*';
            res += Integer.toString(count);
        }

        return res;
    }

    public static boolean doesRhyme(String str1, String str2)
    {
        //рифмуется ли?
        //если в последних словах одинаковые гласные
        int index;
        //вырезаем первое и последнее слово
        index = str1.lastIndexOf(' ');
        if (index == -1)
        {
            index = 0;
        }
        String word1 = str1.substring(index+1).toUpperCase();

        index = str2.lastIndexOf(' ');
        if (index == -1)
        {
            index = 0;
        }
        String word2 = str2.substring(index+1).toUpperCase();
        //вырезаем гласные первого слова
        String check = "";
        for (int i = 0; i < word1.length(); i++)
        {
            char ch = word1.charAt(i);
            if (ch == 'E' || ch == 'Y' || ch == 'U' || ch == 'O' || ch == 'A' || ch == 'I')
            {
                check += ch;
            }
        }
        //сравниваем с гласными второго слова
        int count = 0;
        for (int i = 0; i < word2.length(); i++)
        {
            char ch = word2.charAt(i);
            if (ch == 'E' || ch == 'Y' || ch == 'U' || ch == 'O' || ch == 'A' || ch == 'I')
            {
                if (count >= check.length())
                {
                    return false;
                }
                else if (ch != check.charAt(count))
                {
                    return false;
                }
                count++;
            }
        }

        return true;
    }

    public static boolean trouble(int a, int b)
    {
        //если слово повторяемся 3 раза подряд в 1 и 2 раза в 2
        String str1 = Integer.toString(a);
        String str2 = Integer.toString(b);
        char number = '\0';
        int count = 0;

        for (int i = 0; i < str1.length(); i++)
        {
            char ch = str1.charAt(i);
            if (ch == number)
            {
                count++;
            }
            else
            {
                number = ch;
                count = 0;
            }
            if (count == 2)
            {
                if (str2.indexOf(String.copyValueOf(new char[] {number, number})) != -1)
                {
                    return true;
                }
                else
                {
                    count = 0;
                }
            }
        }

        return false;
    }

    public static int countUniqueBooks(String str, String endChar)
    {
        //найти количество ун. символов между двумя endChar
        int count = 0;
        boolean open = false;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (!open && ch == endChar.charAt(0))
            {
                open = true;
            }
            else if (open)
            {
                if (ch != endChar.charAt(0))
                {
                    if (!set.contains(ch))
                    {
                        set.add(ch);
                        count++;
                    }
                }
                else
                {
                    open = false;
                    set.clear();
                }
            }
        }

        return count;
    }
}
