package BaekJoon.Solve2023.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2608 {
    Map<Character, Integer> romeMap = init();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src1 = br.readLine();
        String src2 = br.readLine();

        int num = strToNum(src1) + strToNum(src2);
        System.out.println(num);
        String res = "";
        int ten = 10;
        while (num != 0) {
            res = numToStr(num % ten).concat(res);
            num -= num % ten;
            ten *= 10;
        }
        System.out.print(res);

        br.close();
    }

    private Map<Character, Integer> init() {
        Map<Character, Integer> res = new HashMap<>();

        res.put('I', 1);
        res.put('V', 5);
        res.put('X', 10);
        res.put('L', 50);
        res.put('C', 100);
        res.put('D', 500);
        res.put('M', 1000);

        return res;
    }

    private int strToNum(String src) {
        int res = romeMap.get(src.charAt(0));
        for (int i = 1; i < src.length(); i++) {
            if (romeMap.get(src.charAt(i - 1)) < romeMap.get(src.charAt(i))) res += romeMap.get(src.charAt(i)) - romeMap.get(src.charAt(i - 1)) * 2;
            else res += romeMap.get(src.charAt(i));
        }
        return res;
    }

    private String numToStr(int num) {
        String res = "";
        if (num == 0) return "";
        else if (num == 1) return "I";
        else if (num == 5) return "V";
        else if (num == 10) return "X";
        else if (num == 50) return "L";
        else if (num == 100) return "C";
        else if (num == 500) return "D";
        else if (num == 1000) return "M";
        else if (num == 4) return "IV";
        else if (num == 9) return "IX";
        else if (num == 40) return "XL";
        else if (num == 90) return "XC";
        else if (num == 400) return "CD";
        else if (num == 900) return "CM";
        else {
            if (num / 10 == 0) {
                if (num > 5) {
                    num -= 5;
                    res = res.concat(numToStr(5));
                }
                if (num % 3 == 1) res = res.concat("I");
                if (num % 3 == 2) res = res.concat("II");
                if (num % 3 == 0) res = res.concat("III");
            } else if (num / 100 == 0) {
                if (num > 50) {
                    num -= 50;
                    res = res.concat(numToStr(50));
                }
                if ((num / 10) % 3 == 1) res = res.concat("X");
                if ((num / 10) % 3 == 2) res = res.concat("XX");
                if ((num / 10) % 3 == 0) res = res.concat("XXX");
            } else if (num / 1000 == 0) {
                if (num > 500) {
                    num -= 500;
                    res = res.concat(numToStr(500));
                }
                if ((num / 100) % 3 == 1) res = res.concat("C");
                if ((num / 100) % 3 == 2) res = res.concat("CC");
                if ((num / 100) % 3 == 0) res = res.concat("CCC");
            } else if (num / 10000 == 0) {
                for (int i = 1; i <= (num / 1000); i++) res = res.concat("M");
            }
        }
        return res;
    }
}
