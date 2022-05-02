package DSA.StringsAndArrays;

import java.util.Stack;

public class BackSpaceCompareNaive {
    public static void main(String[] args) {
        System.out.println(backspaceCompareNaive("baf##tw", "bxo#j##tw"));
    }


    private static boolean backspaceCompareNaive(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        String x = getRippedString(s).replace("#", "").trim();
        String y = getRippedString(t).replace("#", "").trim();

        System.out.println(x+ " "+ y);
        return x.equals(y);

    }

    private static String getRippedString(char[] s) {
        int backSpaces = 0;
        for(int i = s.length-1 ; i>=0;) {

            if(s[i] == '#') {
                while(i>=0 && s[i]=='#') {
                    i--;
                    backSpaces++;
                }
                while(i>=0 && backSpaces>0 && s[i]!='#') {
                    s[i] = '#';
                    i--;
                    backSpaces--;
                }
            } else {
                i--;
            }


        }

        return String.valueOf(s);

    }


}


