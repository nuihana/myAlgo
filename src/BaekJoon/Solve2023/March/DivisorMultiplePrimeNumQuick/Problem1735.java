package BaekJoon.Solve2023.March.DivisorMultiplePrimeNumQuick;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1735 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ActualNum first = new ActualNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        ActualNum second = new ActualNum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(first.multiple(second));

        br.close();
        bw.close();
    }

    class ActualNum {
        int numerator; //분자
        int denominator; //분모

        public ActualNum(int a, int b) {
            this.numerator = a;
            this.denominator = b;
        }

        private int getMinMultiple(int a, int b) {
            int sqrtNum = (int) Math.ceil(Math.sqrt(Math.max(a, b)));
            int multiple = 1;

            for (int i = 2; i <= sqrtNum; i++) {
                while (a % i == 0 && b % i == 0) {
                    a /= i;
                    b /= i;
                    multiple *= i;
                }
            }

            return a * b * multiple;
        }
        private int getMaxDivisor(int a, int b) {
            int sqrtNum = (int) Math.ceil(Math.sqrt(Math.max(a, b)));
            int multiple = 1;

            for (int i = 2; i <= sqrtNum; i++) {
                while (a % i == 0 && b % i == 0) {
                    a /= i;
                    b /= i;
                    multiple *= i;
                }
            }

            return multiple;
        }

        public String multiple(ActualNum another) {
            int minMultiple = getMinMultiple(this.denominator, another.denominator);
            int newNumerator = 0;

            newNumerator += this.numerator * (minMultiple / this.denominator);
            newNumerator += another.numerator * (minMultiple / another.denominator);

            int maxDivisor = getMaxDivisor(newNumerator, minMultiple);

            return newNumerator / maxDivisor + " " + minMultiple / maxDivisor;
        }
    }
}
