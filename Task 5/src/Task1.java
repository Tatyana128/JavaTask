import java.security.MessageDigest;
import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);



        // задача 4
        System.out.println("Введите последовательность чисел:");
        String[] strArr = in.nextLine().split(" ");
        ArrayList<Integer> mas = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++)
        {
            mas.add(Integer.parseInt(strArr[i]));
        }
        System.out.println(sumDigProd(mas));

        // задача 1
        System.out.println("Введите сообщение:");
        String str = in.nextLine();
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9')
        {
            System.out.println(decrypt(str));
        }
        else
        {
            System.out.println(encrypt(str));
        }

        // задача 2
        System.out.println("Введите фигуру (пешка, конь, ладья, слон, ферзь, король), ее положение и целевую позицию. (Вы играете за белых)");
        String figure = in.nextLine();
        String pos = in.nextLine();
        String dest = in.nextLine();
        System.out.println(canMove(figure, pos, dest));

        // задача 3
        System.out.println("Введите входную строку и ее итоговую версию:");
        String str22 = in.nextLine();
        String fullStr = in.nextLine();
        System.out.println(canComplete(str22, fullStr));

        // задача 5
        System.out.println("Введите последовательность слов:");
        String str313 = in.nextLine();
        System.out.println(sameVowelGroup(str313));

        // задача 6
        System.out.println("Введите номер карты:");
        String str15 = in.nextLine();
        System.out.println(validateCard(str15));

        // задача 8
        System.out.println("Введите строку:");
        String str445= in.nextLine();
        System.out.println(getSha256Hash(str445));


        // задача 9
        System.out.println("Введите строку:");
        String str555 = in.nextLine();
        System.out.println(correctTitle(str555));


        // задача 7
        System.out.println("Введите число:");
        int n55 = in.nextInt();
        System.out.println(numToEng(n55));

        // задача 10
        System.out.println("Введите число:");
        int n23 = in.nextInt();
        System.out.println(hexLattice(n23));
    }

    public static String encrypt(String str)
    {
        String res = "";
        char oldCh = str.charAt(0);
        res += (int)oldCh;
        res += " ";

        for (int i = 1; i < str.length(); i++)//добавляем разности между кодами символов
        {
            char newCh = str.charAt(i);
            res += newCh - oldCh;
            res += " ";
            oldCh = newCh;
        }

        return res;
    }

    public static String decrypt(String str)
    {
        String res = "";
        String[] code = str.split(" ");
        int symbol = Integer.parseInt(code[0]);
        res += (char)symbol;

        for (int i = 1; i < code.length; i++)//записываем числа по коду
        {
            symbol += Integer.parseInt(code[i]);
            res += (char)(symbol);
        }

        return res;
    }

    public static boolean canMove(String figure, String pos, String dest)
    {
        //проверка возможности ходить
        switch (figure)
        {
            case "пешка":
                if (pos.charAt(0) == dest.charAt(0) &&
                        (pos.charAt(1) == dest.charAt(1)-1 || (pos.charAt(1) == '2' && pos.charAt(1) == dest.charAt(1)-2)))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            case "конь":
                if ((Math.abs(pos.charAt(0) - dest.charAt(0)) == 2 && Math.abs(pos.charAt(1) - dest.charAt(1)) == 1) ||
                        (Math.abs(pos.charAt(0) - dest.charAt(0)) == 1 && Math.abs(pos.charAt(1) - dest.charAt(1)) == 2))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            case "ладья":
                if (pos.charAt(0) == dest.charAt(0) || pos.charAt(1) == dest.charAt(1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            case "слон":
                if (Math.abs(pos.charAt(0) - pos.charAt(1)) == Math.abs(dest.charAt(0) - dest.charAt(1)))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            case "ферзь":
                if ((pos.charAt(0) == dest.charAt(0) || pos.charAt(1) == dest.charAt(1)) ||
                        (Math.abs(pos.charAt(0) - pos.charAt(1)) == Math.abs(dest.charAt(0) - dest.charAt(1))))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                if ((pos.charAt(0) == dest.charAt(0) && Math.abs(pos.charAt(1) - dest.charAt(1)) == 1) ||
                        (pos.charAt(1) == dest.charAt(1) && Math.abs(pos.charAt(0) - dest.charAt(0)) == 1) ||
                        (Math.abs(pos.charAt(0) - dest.charAt(0)) == 1 && Math.abs(pos.charAt(1) - dest.charAt(1)) == 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
        }
    }

    public static boolean canComplete(String str, String fullStr)
    {
        //проверить является ли одна строка частью другой
        int j = 0;
        for (int i = 0; i < fullStr.length(); i++)
        {
            if (j >= str.length())
            {
                return true;
            }

            char ch = fullStr.charAt(i);
            if (ch == str.charAt(j))
            {
                j++;
            }
        }

        if (j == str.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int sumDigProd(ArrayList<Integer> mas)
    {
        //складываем два числа и перемножаем пока результат не будет одной цифрой
        int sum = 0;

        for (int val : mas)//складываем числа
        {
            sum += val;
        }

        while (sum > 9)//пока не одна цифра
        {
            String sumStr = Integer.toString(sum);
            sum = 1;

            for (int i = 0; i < sumStr.length(); i++)
            {
                sum *= Integer.parseInt(String.valueOf(sumStr.charAt(i)));//перемножаем
            }
        }

        return sum;
    }

    public static String sameVowelGroup(String str)
    {
        //
        String[] strArr = str.split(" ");

        HashSet<Character> pattern = new HashSet<>();
        for (int i = 0; i < strArr[0].length(); i++)//выделяем гласные в первом слове
        {
            char ch = strArr[0].charAt(i);
            if (ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a')
            {
                if (!pattern.contains(ch))
                {
                    pattern.add(ch);
                }
            }
        }

        String res = strArr[0];
        for (int i = 1; i < strArr.length; i++)//перебираем остальные слова
        {
            for (int j = 0; j < strArr[i].length(); j++)//перебираем символы в слове
            {
                char ch = strArr[i].charAt(j);//если это гласная и не соответствует нужному набору
                if (!pattern.contains(ch) &&
                        (ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a'))
                {
                    break;
                }

                if (j == strArr[i].length()-1)//если последний символ и слово прошло проверки списываем в результат
                {
                    res += ' ';
                    res += strArr[i];
                }
            }
        }

        return res;
    }

    public static boolean validateCard(String str)
    {
        //проверка номера карты
        if (str.length() < 14 || str.length() > 19)
        {
            return false;
        }

        char checksum = str.charAt(str.length()-1);//контрольная цифра
        str = str.substring(0, str.length()-1);

        str = new StringBuilder(str).reverse().toString();//переворачиваем

        String doubleStr = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (i % 2 == 0)//на нечетных позициях удваиваем значения
            {
                int val = Integer.parseInt(String.valueOf(str.charAt(i)))*2;
                if (val > 9)//складываем вместе если в числе две цифры
                {
                    val = val/10 + val%10;
                }
                doubleStr += Integer.toString(val);
            }
            else
            {
                doubleStr += str.charAt(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < doubleStr.length(); i++)//все складываем
        {
            sum += Integer.parseInt(String.valueOf(doubleStr.charAt(i)));
        }

        sum = 10 - sum % 10;//вычитаем последнюю цифру суммы
        if (checksum == Integer.toString(sum).charAt(0))//сравниваем с контрольным значением
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String numToEng(int n)
    {
        if (n == 0)
        {
            return "zero\nноль";
        }

        Stack<String> stackEn = new Stack<>();
        Stack<String> stackRu = new Stack<>();

        if (n % 100 / 10 != 1)
        {
            switch (n % 10)
            {
                case 1:
                    stackEn.push("one");
                    stackRu.push("один");
                    break;
                case 2:
                    stackEn.push("two");
                    stackRu.push("два");
                    break;
                case 3:
                    stackEn.push("three");
                    stackRu.push("три");
                    break;
                case 4:
                    stackEn.push("four");
                    stackRu.push("четыре");
                    break;
                case 5:
                    stackEn.push("five");
                    stackRu.push("пять");
                    break;
                case 6:
                    stackEn.push("six");
                    stackRu.push("шесть");
                    break;
                case 7:
                    stackEn.push("seven");
                    stackRu.push("семь");
                    break;
                case 8:
                    stackEn.push("eight");
                    stackRu.push("восемь");
                    break;
                case 9:
                    stackEn.push("nine");
                    stackRu.push("девять");
                    break;
            }
        }

        if (n > 9)
        {
            switch (n % 100 / 10)
            {
                case 1:
                    switch (n % 10)
                    {
                        case 0:
                            stackEn.push("ten");
                            stackRu.push("десять");
                            break;
                        case 1:
                            stackEn.push("eleven");
                            stackRu.push("одиннадцать");
                            break;
                        case 2:
                            stackEn.push("twelve");
                            stackRu.push("двенадцать");
                            break;
                        case 3:
                            stackEn.push("thirteen");
                            stackRu.push("тринадцать");
                            break;
                        case 4:
                            stackEn.push("fourteen");
                            stackRu.push("четырнадцать");
                            break;
                        case 5:
                            stackEn.push("fifteen");
                            stackRu.push("пятнадцать");
                            break;
                        case 6:
                            stackEn.push("sixteen");
                            stackRu.push("шестнадцать");
                            break;
                        case 7:
                            stackEn.push("seventeen");
                            stackRu.push("семнадцать");
                            break;
                        case 8:
                            stackEn.push("eighteen");
                            stackRu.push("восемнадцать");
                            break;
                        case 9:
                            stackEn.push("nineteen");
                            stackRu.push("девятнадцать");
                            break;
                    }
                    break;
                case 2:
                    stackEn.push("twenty");
                    stackRu.push("двадцать");
                    break;
                case 3:
                    stackEn.push("thirty");
                    stackRu.push("тридцать");
                    break;
                case 4:
                    stackEn.push("forty");
                    stackRu.push("сорок");
                    break;
                case 5:
                    stackEn.push("fifty");
                    stackRu.push("пятьдесят");
                    break;
                case 6:
                    stackEn.push("sixty");
                    stackRu.push("шестьдесят");
                    break;
                case 7:
                    stackEn.push("seventy");
                    stackRu.push("семьдесят");
                    break;
                case 8:
                    stackEn.push("eighty");
                    stackRu.push("восемьдесят");
                    break;
                case 9:
                    stackEn.push("ninety");
                    stackRu.push("девяносто");
                    break;
            }
        }

        if (n > 99)
        {
            switch (n / 100)
            {
                case 1:
                    stackEn.push("one hundred");
                    stackRu.push("сто");
                    break;
                case 2:
                    stackEn.push("two hundred");
                    stackRu.push("двести");
                    break;
                case 3:
                    stackEn.push("three hundred");
                    stackRu.push("триста");
                    break;
                case 4:
                    stackEn.push("four hundred");
                    stackRu.push("четыреста");
                    break;
                case 5:
                    stackEn.push("five hundred");
                    stackRu.push("пятьсот");
                    break;
                case 6:
                    stackEn.push("six hundred");
                    stackRu.push("шестьсот");
                    break;
                case 7:
                    stackEn.push("seven hundred");
                    stackRu.push("семсот");
                    break;
                case 8:
                    stackEn.push("eight hundred");
                    stackRu.push("восемсот ");
                    break;
                case 9:
                    stackEn.push("nine hundred");
                    stackRu.push("девятьсот");
                    break;
            }
        }

        String res = "";
        int end = stackEn.size();
        for (int i = 0; i < end; i++) //записываем в строку
        {
            res += stackEn.pop();
            res += ' ';
        }
        res += '\n';

        end = stackRu.size();
        for (int i = 0; i < end; i++)//записываем в строку
        {
            res += stackRu.pop();
            res += ' ';
        }

        return res;
    }

    public static String getSha256Hash(String str)
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");//выбираю функцию хэширования
            // конвертирую строку в байты и вычисляется дайджет сообщение
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < hash.length; ++i) {
                String hex = Integer.toHexString(255 & hash[i]);//Преобразование в шестнадцатиричную систему
                hexString.append(hex);
            }

            return hexString.toString();


        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    public static String correctTitle(String str)
    {
        str = str.toLowerCase();
        String[] words = str.split(" ");
        String res = "";
        for (String word : words)
        {
            String[] subWords = word.split("-");
            String subRes = "";
            for (String subWord : subWords)
            {
                if (!subWord.equals("of") && !subWord.equals("and") && !subWord.equals("the") && !subWord.equals("in"))
                {
                    subRes += (char)(subWord.charAt(0)-32);
                    subRes += subWord.substring(1);
                }
                else
                {
                    subRes += subWord;
                }
            }
            res += subRes;
            res += " ";
        }

        return res;
    }

    public static String hexLattice(int n)
    {
        //рисует шестиугольники
        int mult = 0;
        int val = 1;
        int lines = -1;
        do
        {
            val += mult;
            mult += 6;//каждый раз добавляется по 2 строки и 6 ноликов
            lines += 2;
        } while (val < n);

        if (val != n)
        {
            return "Invalid";
        }

        int mid = lines/2 + 1;//количество ноликов в ребре
        String res = "";
        for (int i = 1; i <= lines; i++)
        {
            if (i <= mid)//вычисляется количество пробелов
            {
                mult = i;
            }
            else
            {
                mult = lines - i + 1;
            }
            //вычисляем начало и конец самой фигуры
            int start = mid - mult + 1;
            int end = lines*2 - start;
            char ch = 'o';
            for (int j = 1; j < lines*2; j++)
            {
                if (j >= start && j <= end)//вывод фигуры а не пустного фона
                {
                    res += ch;
                    ch = ch == ' ' ? 'o' : ' ';// вывод кружочков через пробел
                }
                else
                {
                    res += ' ';
                }
            }
            res += '\n';
        }

        return res;
    }
}
