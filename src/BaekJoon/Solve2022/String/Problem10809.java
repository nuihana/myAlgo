package BaekJoon.Solve2022.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem10809 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();

		br.close();
		
		for (char i = 97; i < 123; i++) {
			bw.write(input.indexOf(Character.valueOf(i).toString()) + " ");
			bw.flush();
		}
		
		bw.close();
	}
}
