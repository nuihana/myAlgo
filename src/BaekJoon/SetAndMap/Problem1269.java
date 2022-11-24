package BaekJoon.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1269 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int aCnt = Integer.parseInt(st.nextToken());
		int bCnt = Integer.parseInt(st.nextToken());
		
		Set<Integer> valSet = new HashSet<>();
		int bResult = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aCnt; i++) {
			valSet.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bCnt; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if (valSet.contains(tmp)) {
				valSet.remove(tmp);
			} else {
				bResult++;
			}
		}
		
		bw.write(Integer.toString(valSet.size() + bResult));

		bw.close();
		br.close();
	}
}
