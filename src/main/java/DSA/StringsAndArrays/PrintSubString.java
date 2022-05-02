package DSA.StringsAndArrays;

public class PrintSubString {
    public static void main(String[] args) {
        String string = "abacdefab";
        printSubString(string);
    }

    private static void printSubString(String string) {
        int n = string.length();
        char[] array = string.toCharArray();
        for(int i=0;i <n-1 ;i++) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(array[i]);
            for(int j=i+1; j<n; j++) {
                buffer.append(array[j]);
                System.out.println(buffer.toString());
            }
        }
    }
}
