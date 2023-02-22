package BaekJoon.Solve2022.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem10815 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int possession = Integer.parseInt(br.readLine());
		Set<Integer> possessionSet = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			possessionSet.add(Integer.valueOf(st.nextToken()));
		}
		
		int input = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			if (possessionSet.contains(Integer.valueOf(st.nextToken()))) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
		}

		bw.close();
		br.close();
	}
}
