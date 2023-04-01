package BaekJoon.Solve2023.March.Advanced_2;

import java.io.*;
import java.util.*;

public class Problem20920 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int wordCnt = Integer.parseInt(st.nextToken());
        int shortLength = Integer.parseInt(st.nextToken());
        Map<String, Word> wordMap = new HashMap<>();
        for (int i = 0; i < wordCnt; i++) {
            String tmp = br.readLine();

            if (tmp.length() < shortLength) continue;

            if (wordMap.get(tmp) == null) {
                Word tmpWord = new Word(tmp);

                wordMap.put(tmp, tmpWord);
            } else {
                wordMap.get(tmp).memorize();
            }
        }
        List<Word> wordList = new ArrayList<>(wordMap.values());
        Collections.sort(wordList);

        for (int i = 0; i < wordList.size(); i++) {
            bw.write(wordList.get(i).value);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Word implements Comparable {
        String value;
        int freq;
        int size;
        public Word(String value_) {
            this.value = value_;
            this.freq = 1;
            this.size = value_.length();
        }

        public void memorize() {
            this.freq++;
        }

        @Override
        public boolean equals(Object obj) {
            Word cpr = (Word) obj;
            return value.equals(cpr.value);
        }

        @Override
        public int compareTo(Object o) {
            Word cpr = (Word) o;

            if (freq != cpr.freq) {
                return cpr.freq - freq;
            }

            if (size != cpr.size) {
                return cpr.size - size;
            }

            return value.compareTo(cpr.value);
        }
    }
}
