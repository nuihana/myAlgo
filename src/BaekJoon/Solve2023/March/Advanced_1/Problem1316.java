package BaekJoon.Solve2023.March.Advanced_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1316 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int wordCnt = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i = 0; i < wordCnt; i++) {
			String value = br.readLine();
			
			for (int j = 0; j < value.length(); j++) {
				String singleStr = value.substring(j, j+1);
				int checkIdx = value.indexOf(singleStr);
				String tmpStr = value.replaceFirst(singleStr, "");
				boolean flag = true;
				
				while(flag) {
					if (tmpStr.indexOf(singleStr) == checkIdx) {
						tmpStr = tmpStr.replaceFirst(singleStr, "");
					} else {
						flag = false;
					}
				}

				if (tmpStr.indexOf(singleStr) > 0) {
					j = value.length();
				}
				
				if (j == value.length() - 1) {
					result++;
				}
			}
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
}
