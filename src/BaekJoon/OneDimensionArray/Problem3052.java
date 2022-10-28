package BaekJoon.OneDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Problem3052 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			set.add(Integer.parseInt(br.readLine()) % 42);
		}
		
		bw.write(Integer.toString(set.size()));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
