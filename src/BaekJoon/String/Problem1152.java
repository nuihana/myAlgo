package BaekJoon.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1152 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<String> distinctSet = new ArrayList<>();
		
		for(StringTokenizer input = new StringTokenizer(br.readLine()); input.hasMoreTokens();) {
			distinctSet.add(input.nextToken());
		}
		
		bw.write(Integer.toString(distinctSet.size()));
		bw.flush();

		br.close();
		bw.close();
	}
}
