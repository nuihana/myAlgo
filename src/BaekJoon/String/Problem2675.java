package BaekJoon.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2675 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < inputCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int repeatCnt = Integer.parseInt(st.nextToken());
			String value = st.nextToken();
			
			for (int j = 0, jLimit = value.length(); j < jLimit; j++) {
				for (int n = 0; n < repeatCnt; n++) {
					bw.write(value.substring(j, j + 1));
				}
			}
			bw.write("\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
