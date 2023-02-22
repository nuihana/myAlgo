package BaekJoon.Solve2022.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2563 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int paperCnt = Integer.parseInt(br.readLine());
		int[][] area = new int[100][100];
		
		for (int i = 0; i < paperCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int x = Integer.parseInt(st.nextToken()), xLimit = x + 9; x < xLimit; x++) {
				for (int y = Integer.parseInt(st.nextToken()), yLimit = y + 9; y < yLimit; y++) {
					area[x][y] += 1;
				}
			}
		}
		
		int areaValue = (int) Arrays.stream(area)
								.flatMapToInt(Arrays::stream)
								.filter(i -> i > 0)
								.count();

		bw.write(Integer.toString(areaValue));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
