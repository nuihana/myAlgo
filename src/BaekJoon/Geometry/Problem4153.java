package BaekJoon.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem4153 {
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int[] orderedList = new int[3];
		boolean flag = true;
		
		while (flag) {
			st = new StringTokenizer(br.readLine());
			
			int tmp = Integer.parseInt(st.nextToken());
			
			if (tmp == 0) {
				flag = false;
				break;
			} else  {
				orderedList[2] = tmp;
			}
			
			tmp = Integer.parseInt(st.nextToken());
			
			if (tmp > orderedList[2]) {
				orderedList[0] = orderedList[2];
				orderedList[2] = tmp;
			} else {
				orderedList[0] = tmp;
			}
			
			tmp = Integer.parseInt(st.nextToken());
			
			if (tmp > orderedList[2]) {
				orderedList[1] = orderedList[2];
				orderedList[2] = tmp;
			} else {
				orderedList[1] = tmp;
			}
			
			if (orderedList[2] * orderedList[2] == orderedList[0] * orderedList[0] + orderedList[1] * orderedList[1]) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
