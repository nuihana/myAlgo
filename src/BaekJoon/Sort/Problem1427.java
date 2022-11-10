package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem1427 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		br.close();
		
		int[] value = new int[input.length()];
		
		for(int i = 0; i < input.length(); i++) {
			value[i] = input.indexOf(i) - 48;
		}
		
		value = Arrays.stream(value).sorted().toArray();
		
		for (int val : value) {
			bw.write(Integer.toString(val));
		}
		
		bw.close();
	}
}
