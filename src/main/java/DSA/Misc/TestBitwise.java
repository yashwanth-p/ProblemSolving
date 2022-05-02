package DSA.Misc;

import java.util.Random;
import java.util.UUID;

public class TestBitwise {

    static final int SIZE = (2 << 14);

    static final Random random = new Random();
    private static final int SIZE_MAX = 1;
    private static final int MASK = SIZE_MAX - 1;
    static int index = random.nextInt();
    public static void main(String[] args) {
        System.out.println(MASK);
        System.out.println(Math.pow(2, 15));
        System.out.println("Bellll... " + (++index&MASK));
        System.out.println("Bellll... " + (++index&MASK));
        System.out.println("Bellll... " + (++index&MASK));

        UUID uid = UUID.randomUUID();
        System.out.println(uid.toString().replaceAll("-", "").length());

        for(int i=0; i<10000; i++) {
            uid.toString().replaceAll("-", "").length();
        }

    }

    private String getRandomString() {
        char buf[] = new char[1];
        Random r = new Random();
        for (int i=0;i<buf.length;i++) {
            int index = r.nextInt(1);
        }

        return new String(buf);
    }


    public enum DAY {
        SUNDAY_1, MONDAY_2;
    }
}
