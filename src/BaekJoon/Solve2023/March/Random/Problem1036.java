package BaekJoon.Solve2023.March.Random;

import java.io.*;
import java.util.Arrays;

public class Problem1036 {
    TSNumber[] usedFreq = new TSNumber[36];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordCnt = Integer.parseInt(br.readLine());
        TSNumber[] numArr = new TSNumber[wordCnt];
        int maximumLength = 0;
        for (int i = 0; i < 36; i++) {
            usedFreq[i] = new TSNumber(i);
        }
        for (int i = 0; i < wordCnt; i++) {
            numArr[i] = new TSNumber(br.readLine());
            maximumLength = Math.max(maximumLength, numArr[i].size);
        }

        int upperCnt = Integer.parseInt(br.readLine());
        int[] upperArr = new int[36];

        Arrays.sort(usedFreq);
        for (int i = 0; i < 36; i++) {
            if (upperCnt == 0) {
                break;
            }

            upperArr[usedFreq[i].reqIdx] = 1;
            upperCnt--;
        }

        TSNumber result = numArr[0].upperCase(upperArr);
        for (int i = 1; i < wordCnt; i++) {
            result.add(numArr[i], upperArr);
        }

        bw.write(result.getValue());

        br.close();
        bw.close();
    }

    class TSNumber implements Comparable {
        final int limit = 53;
        int[] value = new int[limit];
        int size;
        int reqIdx;

        public TSNumber() {
            size = 0;
        }
        public TSNumber(int idx) {
            this.reqIdx = idx;
            size = 0;
        }
        public TSNumber(String strVal) {
            size = strVal.length();
            for (int i = 0; i < size; i++) {
                int tmp = strVal.charAt(i);
                if (tmp > 64) { //알파벳
                    tmp -= 55;
                } else {
                    tmp -= 48;
                }
                value[limit - size + i] = tmp;
                usedFreq[tmp].add(size - i, 35 - tmp);
            }
        }

        public void add(int idx, int val) {
            size = Math.max(size, idx);
            value[limit - idx] += val;
            adjust();
        }

        public void add(TSNumber val, int[] upperArr) {
            size = Math.max(size, val.size);
            for (int i = 0; i < val.size; i++) {
                if (upperArr[val.value[limit - 1 - i]] > 0) {
                    value[limit - 1 - i] += 35;
                } else {
                    value[limit - 1 - i] += val.value[limit - 1 - i];
                }
            }
            adjust();
        }

        public TSNumber upperCase(int[] upperArr) {
            String tmp = this.getValue();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.length(); i++) {
                int tmpNum = tmp.charAt(i);
                if (tmpNum > 64) { //알파벳
                    tmpNum -= 55;
                } else {
                    tmpNum -= 48;
                }

                if (upperArr[tmpNum] > 0) {
                    sb.append("Z");
                } else {
                    sb.append(tmp.charAt(i));
                }
            }

            return new TSNumber(sb.toString());
        }

        public String getValue() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < size; i++) {
                int tmp = value[limit - size + i];
                if (tmp < 10) {
                    sb.append(tmp);
                } else {
                    sb.append((char) (tmp + 55));
                }
            }

            return sb.toString();
        }

        private void adjust() {
            for (int i = 0, bfVal = 0; i <= size; i++) {
                if (bfVal > 0) {
                    if (i == size) {
                        size++;
                    }
                    value[limit - 1 - i] += bfVal;
                    bfVal = 0;
                }

                if (value[limit - 1 - i] > 35) {
                    bfVal += value[limit - 1 - i] / 36;
                    value[limit - 1 - i] %= 36;
                }
            }
        }

        @Override
        public int compareTo(Object o) {
            TSNumber tsn = (TSNumber) o;

            if (tsn.reqIdx == 35) {
                return -1;
            } else if (reqIdx == 35) {
                return 1;
            }

            if (tsn.size - size != 0) {
                return tsn.size - size;
            } else if (tsn.size == 0 && size == 0) {
                return tsn.reqIdx - reqIdx;
            }

            int tmpSize = size;
            boolean flag = true;
            while(tmpSize > 0) {
                if (value[limit - tmpSize] != tsn.value[limit - tmpSize]) {
                    if (value[limit - tmpSize] > tsn.value[limit - tmpSize]) {
                        flag = false;
                    }

                    break;
                }
                tmpSize--;

                if (tmpSize == 0) {
                    return reqIdx - tsn.reqIdx;
                }
            }

            if (flag) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}