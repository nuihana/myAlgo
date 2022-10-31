package BaekJoon.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11720 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		String value = br.readLine();

		br.close();
		
		int result = 0;
		
		for (int i = 0; i < input; i++) {
			result += Integer.parseInt(value.substring(i, i+1));
		}
		
		bw.write(Integer.toString(result));
		bw.flush();
		
		bw.close();
	}
}
