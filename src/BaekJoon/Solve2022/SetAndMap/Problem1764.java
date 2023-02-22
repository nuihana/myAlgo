package BaekJoon.Solve2022.SetAndMap;

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

public class Problem1764 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int noHear = Integer.parseInt(st.nextToken());
		int noSee = Integer.parseInt(st.nextToken());
		
		Set<String> noHearSet = new HashSet<>();
		List<String> noHearSeeList = new ArrayList<>();
		
		for (int i = 0; i < noHear; i++) {
			noHearSet.add(br.readLine());
		}
		for (int i = 0; i < noSee; i++) {
			String tmp = br.readLine();
			
			if (noHearSet.contains(tmp)) {
				noHearSeeList.add(tmp);
			}
		}
		
		Collections.sort(noHearSeeList);
		
		bw.write(noHearSeeList.size() + "\n");
		for (int i = 0; i < noHearSeeList.size(); i++) {
			bw.write(noHearSeeList.get(i) + "\n");
		}

		bw.close();
		br.close();
	}
}
