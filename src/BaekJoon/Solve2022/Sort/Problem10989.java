package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Problem10989 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		
		int[] valueArr = new int[inputCnt];
		int[] freqArr = new int[8001];
		
		for (int i = 0; i < inputCnt; i++) {
			valueArr[i] = Integer.parseInt(br.readLine());
			freqArr[valueArr[i] + 4000]++;
		}
		
		IntSummaryStatistics iStatistics = Arrays.stream(valueArr).summaryStatistics();
		valueArr = Arrays.stream(valueArr).sorted().toArray();
		
		bw.write(Math.round((double) iStatistics.getSum() / inputCnt) + "\n");
		bw.write(valueArr[inputCnt / 2] + "\n");
		
		int maxRe = Arrays.stream(freqArr).max().getAsInt();
		
		List<Integer> maxReArr = new ArrayList<>();
		
		for (int i = 0; i < freqArr.length; i++) {
			if (freqArr[i] == maxRe) {
				maxReArr.add(i - 4000);
			}
		}
		
		if (maxReArr.size() > 1) {
			maxReArr.sort((x, y) -> Integer.compare(x, y));
			bw.write(maxReArr.get(1) + "\n");
		} else {
			bw.write(maxReArr.get(0) + "\n");
		}
		
		bw.write(Integer.toString(iStatistics.getMax() - iStatistics.getMin()));
		
		br.close();
		bw.close();
	}
}
