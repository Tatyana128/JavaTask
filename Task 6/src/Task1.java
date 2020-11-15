import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Задание 9
        System.out.println("Введите выражение:");
        String ss = in.nextLine();
        System.out.println(formula(ss));

        // Задание 4
        System.out.println("Введите url:");
        String str33 = in.nextLine();
        String[] strs = str33.split(" ", 2);
        if (strs.length == 1)
        {
            System.out.println(stripUrlParams(str33));
        }
        else
        {
            System.out.println(stripUrlParams(strs[0], strs[1].split(" ")));
        }

        // Задание 2
        System.out.println("Введите строку:");
        String str = in.nextLine();
        System.out.println(translateSentence(str));

        // Задание 3
        System.out.println("Введите строку:");
        String str22 = in.next();
        System.out.println(validColor(str22));

        // Задание 5
        System.out.println("Введите заголовок:");
        String str55 = in.nextLine();
        System.out.println(getHashTags(str55));


        // Задание 7
        System.out.println("Введите строку:");
        String str88 = in.nextLine();
        System.out.println(longestNonrepeatSubstring(str88));

        // Задание 6
        System.out.println("Введите число:");
        int n8 = in.nextInt();
        System.out.println(ulam(n8));

        // Задание 8
        System.out.println("Введите число:");
        int n485 = in.nextInt();
        System.out.println(convertToRoman(n485));

        // Задание 10
        System.out.println("Введите число:");
        int n439 = in.nextInt();
        System.out.println(palindromeDescendant(n439));

        // Задание 1
        System.out.println("Введите число:");
        int n99 = in.nextInt();
        System.out.println(bell(n99));
    }


    public static BigInteger bell(int val)
    {
        //принимает число n и возвращает соответствующее число Белла
        ArrayList<BigInteger> listBell = new ArrayList<>();
        listBell.add(BigInteger.ONE);
        for (int n = 0; n < val; n++)
        {
            BigInteger sum = BigInteger.ZERO;
            for (int k = 0; k <= n; k++)
            {
                //считаем по формуле ?
                BigInteger coef = fact(n).divide(fact(k).multiply(fact(n-k)));
                sum = sum.add(coef.multiply(listBell.get(k)));
            }
            listBell.add(sum);
        }

        return listBell.get(listBell.size()-1);//последнее число возвраащем
    }

    public static BigInteger fact(int n)//находит факториал числа
    {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
        {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }


    public static String translateSentence(String str)
    {
        //перевод каждого слова в предложении
        String[] sent = str.split(" ");
        String res = "";
        for (int i=0;i<sent.length;i++)
        {
            char chh=sent[i].charAt(sent[i].length()-1);
            if(i== sent.length-1 && !(chh >= 'a' && chh <= 'z')){//если последнее слово то обрезаем его до знака препинания

                res += translateWord(sent[i].substring(0,sent[i].length()-2)) + chh;

            }
            else{res += translateWord(sent[i]) + " ";}
        }

        return res;
    }

    public static String translateWord(String word)
    {
        //перевод на поросячий
        word=word.toLowerCase();
        char ch = word.charAt(0);
        if ((ch == 'e' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'a'))//проверка начинается с согласной или гласной
        {
            //если начинается с гласной добавляем в конец "yay"
           word+="yay";
        }
        else
        {
            // если с согласной, вырезаем сокласные до первой гласной, ставим в коне и + "ay"
            String perestanovka="";
            for(int i=0;i<word.length();i++){
                char char1=word.charAt(i);
                if((char1 == 'e' || char1 == 'y' || char1 == 'u' || char1 == 'i' || char1 == 'o' || char1 == 'a')){
                    perestanovka=word.substring(0,word.indexOf(char1));
                    word=word.substring(word.indexOf(char1));
                    break;
                }
            }
            word+=perestanovka+"ay";

        }
        return word;
    }

    public static boolean validColor(String str)
    {
        String pattern = "rgb\\(\\d+,\\d+,\\d+\\)";//создаем нужное рег.выражение
        Pattern pat = Pattern.compile(pattern);//компилируем его как обьект Pattern
        Matcher mat = pat.matcher(str);
        if (!mat.find()) //проверяем соответствует ли строка образцу
        {
            //если не соответствует проверяем на другое рег.выражение
            pattern = "rgba\\(\\d+,\\d+,\\d+,(1|(0(\\.\\d+)?))\\)";
            pat = Pattern.compile(pattern);
            mat = pat.matcher(str);
            if (!mat.find())
            {
                //если ничему не соответствуем возвращаем false
                return false;
            }
        }

        pattern = "\\d+";//число
        pat = Pattern.compile(pattern);
        mat = pat.matcher(str);
        for (int i = 0; i < 3; i++)
        {
            mat.find();
            int val = Integer.parseInt(mat.group(0));//подстрока совпавшая с выражением
            if (val < 0 || val > 255)//ели число не совпааем условию возвращаем false
            {
                return false;
            }
        }

        return true;
    }

    public static String stripUrlParams(String str)//если нет второго аргумента передаем его в другую функцию как пустоту
    {
        return stripUrlParams(str, new String[] {""});
    }

    public static String stripUrlParams(String str, String[] block)
    {
        //принимает Url, удаляем повторяющиеся параметры и указанные параметры
        HashSet<String> blockKeys = new HashSet<>(block.length);
        for (String val : block)
        {
            blockKeys.add(val);
        }

        String[] urlParts = str.split("\\?", 2);//разделяем на часть с параметрами и все остальное
        if (urlParts.length > 1)//если параметры есть
        {
            String[] params = urlParts[1].split("&");//разделяем параметры
            HashMap<String, String> map = new HashMap<>();
            for (String param : params)
            {
                String[] paramParts = param.split("=", 2);//разделяем на имя параметра и значение
                map.put(paramParts[0], paramParts[1]);//добавляем в map
            }

            String res = urlParts[0] + "?";// в строку результата добавляем все кроме параметров

            Set<String> keys = map.keySet();//коллекция неодинаковых ключей
            for (String key : keys)//если эти параметры не подлежат удалению,добавляем в результат
            {
                if (!blockKeys.contains(key))
                {
                    res += key + "=" + map.get(key) + "&";
                }
            }

            return res.substring(0, res.length()-1);
        }
        else
        {
            return str;
        }
    }

    public static String getHashTags(String str)
    {
        //находим максимаьнодлинные три слова и пишем в виде хэштегов
        String[] words = str.split(" |\\W ");
        ArrayList<String> res = new ArrayList<>(3);
        res.add("");
        res.add("");
        res.add("");

        for (String word : words)
        {
            if (!res.contains(word))
            {
                if (word.length() > res.get(2).length())
                {
                    if (word.length() > res.get(1).length())
                    {
                        if (word.length() > res.get(0).length())
                        {
                            res.set(2, res.get(1));
                            res.set(1, res.get(0));
                            res.set(0, word);
                        }
                        else
                        {
                            res.set(2, res.get(1));
                            res.set(1, word);
                        }
                    }
                    else
                    {
                        res.set(2, word);
                    }
                }
            }
        }

        String result = "";
        Iterator<String> it = res.iterator();
        while (it.hasNext())
        {
            String val = it.next();
            if (!val.equals(""))
            {
                result += "#"+val.toLowerCase()+" ";
            }
        }

        return result;
    }

    public static int ulam(int n)
    {
        //ряд где каждое следующее это уникаьная наименьшая сумма
        ArrayList<Integer> mas = new ArrayList<>(n);
        PriorityQueue<Integer> sumArr = new PriorityQueue<>();
        HashSet<Integer> ban = new HashSet<>();
        mas.add(1);
        mas.add(2);
        sumArr.add(mas.get(0) + mas.get(1));

        while (mas.size() < n)
        {
            int sum = sumArr.poll();//верхнее число массива
            for (int val : mas)//
            {
                //перебираем все суммы от самой меньшей
                val += sum;
                if (!ban.contains(val))
                {
                    if (!sumArr.contains(val))
                    {
                        sumArr.add(val);
                    }
                    else//если повторяется сумма то удаляем ее
                    {
                        sumArr.remove(val);
                        ban.add(val);
                    }
                }
            }
            mas.add(sum);
        }

        return mas.get(n-1);
    }



    public static String longestNonrepeatSubstring(String str)
    {
        //находим самое длинную подстроку, в которой символы не повторяются
        ArrayList<String> list = new ArrayList<>();
        String subStr = "";
        //находим все такие подстроки
        for (int i = 0; i < str.length(); i++)
        {
            //перебираем строку
            char ch = str.charAt(i);

            if (!subStr.contains(Character.toString(ch)))//если не повторяется символ,добавляем
            {
                subStr += ch;
            }
            else//если повторяемся
            {
                list.add(subStr);//добавляем в список результатов
                int index = subStr.indexOf(ch);
                if (index == subStr.length()-1)//если последний чистим
                {
                    subStr = "";
                }
                else//если не последний, берем из подстроки все символы кроме одинакового с текущим
                {
                    subStr = subStr.substring(index+1);//??
                }
                subStr += ch;//добавляем и получаем новую подстроку
            }
        }
        list.add(subStr);

        String res = "";
        for (String val : list)//находим самое длинное неповторяющееся выражение
        {
            if (val.length() > res.length())
            {
                res = val;
            }
        }

        return res;
    }

    public static String convertToRoman(int n)
    {
        //перевод арабских в римские
        if (n > 3999)
        {
            return "";
        }

        Stack<String> res = new Stack<>();
        for (int i = 0; i < 4 && n > 0; i++)
        {
            char ch1, ch2, ch3;
            switch (i)
            {
                case 0:
                    ch1 = 'I';
                    ch2 = 'V';
                    ch3 = 'X';
                    break;
                case 1:
                    ch1 = 'X';
                    ch2 = 'L';//50
                    ch3 = 'C';//100
                    break;
                case 2:
                    ch1 = 'C';
                    ch2 = 'D';//500
                    ch3 = 'M';//1000
                    break;
                default:
                    ch1 = 'M';
                    ch2 = 'M';
                    ch3 = 'M';
            }

            switch (n % 10)//перебираем каждую цифру
            {
                case 1:
                    res.push(Character.toString(ch1));
                    break;
                case 2:
                    res.push(Character.toString(ch1) + Character.toString(ch1));
                    break;
                case 3:
                    res.push(Character.toString(ch1) + Character.toString(ch1) + Character.toString(ch1));
                    break;
                case 4:
                    res.push(Character.toString(ch1) + Character.toString(ch2));
                    break;
                case 5:
                    res.push(Character.toString(ch2));
                    break;
                case 6:
                    res.push(Character.toString(ch2) + Character.toString(ch1));
                    break;
                case 7:
                    res.push(Character.toString(ch2) + Character.toString(ch1) + Character.toString(ch1));
                    break;
                case 8:
                    res.push(Character.toString(ch2) + Character.toString(ch1) + Character.toString(ch1) + Character.toString(ch1));
                    break;
                case 9:
                    res.push(Character.toString(ch1) + Character.toString(ch3));
                    break;
            }
            n /= 10;
        }

        String str = "";
        while (res.size() > 0)
        {
            str += res.pop();
        }

        return str;
    }

    public static boolean formula(String str)
    {
        //дано выражение, проверить его правильность
        //вырезаем до = и после
        //вырезаем два числа
        str = str.replaceAll(" ", "");
        if(str.indexOf('=')!=-1) {
            String[] parts = str.split("=");
            if(parts[0].indexOf('*')!=-1 ) {
                int ind=parts[0].indexOf('*');
                try {
                    Integer num1 = Integer.parseInt(parts[0].substring(0, ind));
                    Integer num2 = Integer.parseInt(parts[0].substring(ind+1));
                    Integer num3 = Integer.parseInt(parts[1]);
                    return num1 * num2 == num3;
                }
                catch (NumberFormatException nn){return  false;}
            }
            else if(parts[0].indexOf('/')!=-1 ){
                int ind=parts[0].indexOf('/');
                try {
                    Integer num1 = Integer.parseInt(parts[0].substring(0, ind));
                    Integer num2 = Integer.parseInt(parts[0].substring(ind+1));
                    Integer num3 = Integer.parseInt(parts[1]);
                    return num1 / num2 == num3;
                }
                catch (NumberFormatException nn){return  false;}
            }
            else if( parts[0].indexOf('+')!=-1 ) {
                int ind=parts[0].indexOf('+');
                try {
                    Integer num1 = Integer.parseInt(parts[0].substring(0, ind));
                    Integer num2 = Integer.parseInt(parts[0].substring(ind+1));
                    Integer num3 = Integer.parseInt(parts[1]);
                    return num1 + num2 == num3;
                }
                catch (NumberFormatException nn){return  false;}
            }
            else if( parts[0].indexOf('-')!=-1){
                int ind=parts[0].indexOf('-');
                try {
                    Integer num1 = Integer.parseInt(parts[0].substring(0, ind));
                    Integer num2 = Integer.parseInt(parts[0].substring(ind+1));
                    Integer num3 = Integer.parseInt(parts[1]);
                    return num1 - num2 == num3;
                }
                catch (NumberFormatException nn){return  false;}
            }else return false;
        }
        else return false;
    }




    public static boolean palindromeDescendant(int n)
    {
        // проверяет на палиндром само число и его потомки (путем сложения двух соседних цифр)
        String str = Integer.toString(n);
        while (true)
        {
            if (str.length() < 2)//если число однозначное
            {
                return false;
            }

            if (str.length() % 2 != 0)//если число цифр нечетное
            {
                if (str.substring(0, str.length()/2).equals(new StringBuilder(str.substring(str.length()/2+1)).reverse().toString()))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            //если число цифр четное
            if (str.substring(0, str.length()/2).equals(new StringBuilder(str.substring(str.length()/2)).reverse().toString()))
            {
                return true;
            }
            else
            {
                String buff = "";
                for (int i = 0; i < str.length(); i += 2)
                {
                    //складываем соседние числа
                    buff += Integer.toString(Integer.parseInt(Character.toString(str.charAt(i))) +
                            Integer.parseInt(Character.toString(str.charAt(i+1))));
                }
                str = buff;
            }
        }
    }
}
