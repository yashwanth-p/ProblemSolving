package DSA.Incomplete;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.List;

public class UserTransactionJson {
    public static void main(String[] args) throws Exception {

        int uid = 3;
        String txnType = "debit";
        String monthYear = "";
        List<Integer> transactions = getUserTransaction(uid, txnType, monthYear);

        long millis = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millis);
        String monthVal = String.valueOf(c.get(Calendar.MONTH));
        String month =  monthVal.length() == 2 ? monthVal : "0"+monthVal;
        String year = String.valueOf(c.get(Calendar.YEAR));
        System.out.println(month + "-" + year);

        double amount1 = Double.parseDouble("$1234.33".replaceAll("\\$", ""));
        double amount2 = Double.parseDouble("$1234.33".replaceAll("\\$", ""));
        System.out.println(amount1 + amount2);

    }

    private static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) throws Exception{
        String urlString = String.format("https://jsonmock.hackerrank.com/api/transactions/search?userId=%d&txnType=%s&page=2", uid, txnType);
        System.out.println(urlString);
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        System.out.println(builder);

        return null;
    }
}
