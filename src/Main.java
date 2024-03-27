import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<char[]> list = new ArrayList<>();
        while (true) {
            String src = br.readLine();
            if (src.length() < 2) break;

            char[] mem = new char[]{ src.charAt(0), src.charAt(1) };
            list.add(mem);
        }

        boolean[] isUsed = new boolean[list.size()];
        while (isAllFilled(isUsed)) {
            int a = (int) Math.floor(Math.random() * list.size());
            while (isUsed[a]) a = (int) Math.floor(Math.random() * list.size());
            isUsed[a] = true;
            System.out.print("" + list.get(a)[0] + list.get(a)[1] + " vs ");

            if (!isAllFilled(isUsed)) break;

            int b = (int) Math.floor(Math.random() * list.size());
            while (isUsed[b] || list.get(a)[0] == list.get(b)[0]) {
                b = (int) Math.floor(Math.random() * list.size());
            }
            isUsed[b] = true;
            System.out.println("" + list.get(b)[0] + list.get(b)[1]);
        }

        br.close();
    }

    private static boolean isAllFilled(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) return true;
        }
        return false;
    }
}