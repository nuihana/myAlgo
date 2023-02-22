package BaekJoon.Solve2022.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1620 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int possession = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		
		List<String> possessionList = new ArrayList<>();
		
		for (int i = 0; i < possession; i++) {
			possessionList.add(br.readLine());
		}
		for (int i = 0; i < input; i++) {
			String tmp = br.readLine();
			
			if (tmp.replaceAll("[^0-9]", "").equals("")) {
				bw.write(Integer.toString(possessionList.indexOf(tmp)));
			} else {
				bw.write(possessionList.get(Integer.valueOf(tmp) + 1));
			}
		}
		
		

		bw.close();
		br.close();
	}
}
