package BaekJoon.Solve2022.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem2477 {
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int perOne = Integer.parseInt(br.readLine());
		int[] vecArr = new int[6];
		int[] valArr = new int[6];
		
		int trigger = 0;
		int triggerIdx = 0;
		int[] calcArr = new int[4];
		
		for (int i = 0, s = 0, w = 0, n = 0, e = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			
			int vector = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			vecArr[i] = vector;
			valArr[i] = value;
			
			if (vector == 1) {
				e++;
			} else if (vector == 2) {
				w++;
			} else if (vector == 3) {
				s++;
			} else if (vector == 4) {
				n++;
			}
			
			if (i == 5) {
				if (e == 1 && n == 1) {
					trigger = 4;
				}
				if (s == 1 && e == 1) {
					trigger = 1;
				}
				if (n == 1 && w == 1) {
					trigger = 2;
				}
				if (w == 1 && s == 1) {
					trigger = 3;
				}
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if (trigger == vecArr[i]) {
				triggerIdx = i;
			}
		}
		
		for (int i = triggerIdx + 2, limit = triggerIdx + 4, j = 2; i < limit; i++) {
			calcArr[j] = valArr[i % 6];
			j++;
		}
		
		calcArr[0] = valArr[triggerIdx == 0 ? 5 : triggerIdx - 1];
		calcArr[1] = valArr[triggerIdx];
		
		bw.write(Integer.toString(perOne * (calcArr[0] * calcArr[1] - calcArr[2] * calcArr[3])));
		
		br.close();
		bw.close();
	}
}
