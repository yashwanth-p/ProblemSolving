package DSA.StringsAndArrays;

public class CompressString {
    public static void main(String[] args) {
        compressStringWithCount("aaaaabbbbbcccdzzzzppzzzAAANNN");
        compressStringWithCount("qwertyuiop");
    }

    public static void compressStringWithCount(String string) {
        char[] str = string.toCharArray();
        boolean atleastOneCompression = false;
        StringBuilder compressedString = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == str[i + 1]) {
                atleastOneCompression = true;
                count++;
            } else {
                compressedString.append(str[i]);
                compressedString.append(count);
                count = 1;
            }
        }
        compressedString.append(str[str.length - 1]);
        compressedString.append(count);
        if (atleastOneCompression) {
            System.out.println(compressedString);
        } else {
            System.out.println(string);
        }

    }
}

