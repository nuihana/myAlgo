package BaekJoon.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1004 {
	private void solution() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		int[] fromto = new int[4];
		
		for (int i = 0; i < inputCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			fromto[0] = Integer.parseInt(st.nextToken());
			fromto[1] = Integer.parseInt(st.nextToken());
			fromto[2] = Integer.parseInt(st.nextToken());
			fromto[3] = Integer.parseInt(st.nextToken());
			
			int planetCnt = Integer.parseInt(br.readLine());
			int result = 0;
			
			for (int j = 0; j < planetCnt; j++) {
				st = new StringTokenizer(br.readLine());
				
				int[] planetP = new int[2];
				int size;
				
				planetP[0] = Integer.parseInt(st.nextToken());
				planetP[1] = Integer.parseInt(st.nextToken());
				size = Integer.parseInt(st.nextToken());
				
				if (Math.pow(planetP[0] - fromto[0], 2) + Math.pow(planetP[1] - fromto[1], 2) < Math.pow(size, 2)) {
					if (Math.pow(planetP[0] - fromto[2], 2) + Math.pow(planetP[1] - fromto[3], 2) >= Math.pow(size, 2)) {
						result++;
					}
				} else if (Math.pow(planetP[0] - fromto[2], 2) + Math.pow(planetP[1] - fromto[3], 2) < Math.pow(size, 2)) {
					if (Math.pow(planetP[0] - fromto[0], 2) + Math.pow(planetP[1] - fromto[1], 2) >= Math.pow(size, 2)) {
						result++;
					}
				}
			}
			
			bw.write(result + "\n");
		}
        
        br.close();
		bw.close();
	}
}