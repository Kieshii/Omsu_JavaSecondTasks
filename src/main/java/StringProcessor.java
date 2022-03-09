public class StringProcessor {

    public static String CopyStringNTime(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Отрицательное количество повторений строки.");
        }
        String str = "";
        for (int i = 0; i < n; i++) {
            str += s;
        }
        return str;
    }


    public static int CountIncludeStringToString(String str1, String str2) {
        int count = 0;
        if (str1 == null || str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("Строка пустая или имеет значение null.");
        }
        if (str1.length() < str2.length())
            throw new IllegalArgumentException("Вторая строка не может быть длиннее первой.");
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str2.equals(str1.subSequence(i, str2.length() + i).toString())) count++;
        }
        return count;
    }


    public static String ParseStringOneTwoThree(String str) {
        if (str == null) throw new IllegalArgumentException("Строка имеет значение null.");
        if (str.isEmpty()) return "";
        str = str.replace("1", "один");
        str = str.replace("2", "два");
        str = str.replace("3", "три");
        return str;
    }


    public static StringBuilder DeleteEverySecondInStringBuilder(StringBuilder str) {
        int len = str.length();
        for (int i = 1; i < len; i++) {
            str.delete(i, i + 1);
            len--;
        }
        return str;
    }
}