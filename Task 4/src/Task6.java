import java.util.HashSet;
import java.util.Scanner;
public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку:");
        String str = in.nextLine();
        System.out.println(toStarShorthand(str));

        System.out.println("Введите две строки:");
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(doesRhyme(str1, str2));

        System.out.println("Введите последовательность символов и символ, обозначающий начало/конец книги:");
        String str11 = in.nextLine();
        String endChar = in.nextLine();
        System.out.println(countUniqueBooks(str11, endChar));

        System.out.println("Введите два числа:");
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(trouble(a, b));

        System.out.println("Введите число:");
        int n = in.nextInt();
        System.out.println(bugger(n));
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
