package BaekJoon.Solve2022.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem3009 {
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int[] xList = new int[4];
		int[] yList = new int[4];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int xTmp = Integer.parseInt(st.nextToken());
			int yTmp = Integer.parseInt(st.nextToken());
			
			if (xList[0] == xTmp) {
				xList[1]++;
			} else if (xList[2] == xTmp) {
				xList[3]++;
			} else {
				if (xList[1] == 0) {
					xList[0] = xTmp;
					xList[1]++;
				} else {
					xList[2] = xTmp;
					xList[3]++;
				}
			}
			
			if (yList[0] == yTmp) {
				yList[1]++;
			} else if (yList[2] == yTmp) {
				yList[3]++;
			} else {
				if (yList[1] == 0) {
					yList[0] = yTmp;
					yList[1]++;
				} else {
					yList[2] = yTmp;
					yList[3]++;
				}
			}
		}
		
		if (xList[1] == 1) {
			bw.write(xList[0] + " ");
		} else {
			bw.write(xList[2] + " ");
		}
		
		if (yList[1] == 1) {
			bw.write(Integer.toString(yList[0]));
		} else {
			bw.write(Integer.toString(yList[2]));
		}
		
		br.close();
		bw.close();
	}
}
