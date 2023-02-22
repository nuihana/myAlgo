package BaekJoon.Solve2022.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem14425 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int possession = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		int result = 0;
		
		Set<String> posSet = new HashSet<>();
		for (int i = 0; i < possession; i++) {
			posSet.add(br.readLine());
		}
		for (int i = 0; i < input; i++) {
			if (posSet.contains(br.readLine())) {
				result++;
			}
		}
		
		bw.write(Integer.toString(result));

		bw.close();
		br.close();
	}
}
