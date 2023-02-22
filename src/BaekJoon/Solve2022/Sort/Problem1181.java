package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1181 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		Set<String> valSet = new HashSet<>();
		
		for (int i = 0; i < inputCnt; i++) {
			valSet.add(br.readLine());
		}
		
		List<String> valList = new ArrayList<>(valSet);
		valList.sort((a, b) -> a.length() - b.length() == 0 ? a.compareTo(b) : a.length() - b.length());
		
		for (String val : valList) {
			bw.write(val + "\n");
		}
		
		br.close();
		bw.close();
	}
}
