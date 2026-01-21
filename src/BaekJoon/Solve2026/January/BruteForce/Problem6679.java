package BaekJoon.Solve2026.January.BruteForce;

public class Problem6679 {
    public void solution() {
        StringBuilder sb = new StringBuilder();
        for (int num = 1000; num < 10000; num++) {
            int tmp = num;
            int sum10 = 0;
            while (tmp / 10 != 0) {
                sum10 += tmp % 10;
                tmp /= 10;
            }
            sum10 += tmp;

            tmp= num;
            int sum12 = 0;
            while (tmp / 12 != 0) {
                sum12 += tmp % 12;
                tmp /= 12;
            }
            sum12 += tmp;

            tmp = num;
            int sum16 = 0;
            while (tmp / 16 != 0) {
                sum16 += tmp % 16;
                tmp /= 16;
            }
            sum16 += tmp;

            if (sum10 == sum12 && sum10 == sum16) {
                sb.append(num).append("\n");
            }
        }
        System.out.print(sb);
    }
}
