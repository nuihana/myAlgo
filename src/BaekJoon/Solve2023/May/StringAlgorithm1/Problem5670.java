package BaekJoon.Solve2023.May.StringAlgorithm1;

import java.io.*;
import java.util.*;

public class Problem5670 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = null;
        while((input = br.readLine()) != null && !input.equals("")) {
            int dictionaryCnt = Integer.parseInt(input);

            Dictionary dictionary = new Dictionary();
            String[] inputArr = new String[dictionaryCnt];
            for (int i = 0; i < dictionaryCnt; i++) {
                inputArr[i] = br.readLine();
                dictionary.setData(inputArr[i]);
            }

            int totalPress = 0;
            for (int i = 0; i < dictionaryCnt; i++) {
                totalPress += dictionary.getPressCnt(inputArr[i]);
            }

            bw.write(String.format("%.2f", (float) dictionaryCnt / totalPress));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Dictionary {
        Map<Character, Dictionary> data;
        boolean isLeaf = false;

        public Dictionary() {
            data = new HashMap<>();
        }

        public void setData(String str) {
            Dictionary dic = this;
            for (int i = 0; i < str.length(); i++) {
                char tmp = str.charAt(i);

                if (dic.data.get(tmp) == null) {
                    Dictionary tmpDic = new Dictionary();

                    dic.data.put(tmp, tmpDic);
                }

                dic = dic.data.get(tmp);
            }

            dic.isLeaf = true;
        }

        public int getPressCnt(String str) {
            int result = 0;

            Dictionary dic = data.get(str.charAt(0));
            result++;

            for(int i = 1; i < str.length(); i++) {
                while(dic.data.keySet().size() == 1 && i < str.length() && !dic.isLeaf) {
                    dic = dic.data.get(str.charAt(i));
                    i++;
                }

                if (i < str.length()) {
                    dic = dic.data.get(str.charAt(i));
                    result++;
                }
            }

            return result;
        }
    }
}
