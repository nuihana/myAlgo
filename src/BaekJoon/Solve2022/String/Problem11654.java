package BaekJoon.Solve2022.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11654 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char input = br.readLine().charAt(0);
		
		bw.write(Integer.toString(input));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
