package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem19538 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int lineNum = Integer.parseInt(br.readLine());
		int[] result = new int[lineNum];
		List<String> datasArray = new ArrayList<>();
		List<Integer> leastValArray = new ArrayList<>();
		
		for (int idx = 0; idx < lineNum; idx++) {
			String val = br.readLine().replaceAll("0", "").trim();
			datasArray.add(val);
			int tmp = val.replaceAll("0", "").trim().split(" ").length;
			tmp = (tmp > 0) ? tmp / 2 + tmp % 2 : 0;
			leastValArray.add(tmp);
		}

		String init = br.readLine();
		init = br.readLine();
		
		br.close();
		
		StringTokenizer st = new StringTokenizer(init);
		StringBuilder sb = new StringBuilder();
		List<Integer> targetIdx = new ArrayList<>();
		
		for (int idx = 0; idx < lineNum; idx++) {
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());

				if (idx == 0) {
					targetIdx.add(tmp - 1);
					sb.append(datasArray.get(tmp - 1));
					sb.append(" ");
				} else {
					if (result[tmp - 1] == 0) {
						int judgeCnt = 0;
							
						for (String tmpStr : datasArray.get(tmp - 1).split(" ")) {
							if (result[Integer.parseInt(tmpStr) - 1] > 0) {
								judgeCnt++;
							}
						}
						
						if (judgeCnt >= leastValArray.get(tmp - 1)) {
							targetIdx.add(tmp - 1);
							sb.append(datasArray.get(tmp - 1));
							sb.append(" ");
						}
					}
				}
			}
			
			for (int target : targetIdx) {
				result[target] = idx + 1;
			}
			targetIdx.clear();
			
			if (sb.length() == 0) {
				idx = lineNum;
			}
			
			st = new StringTokenizer(sb.toString().trim());
			sb.setLength(0);
		}
		
		for (int tmp : result) {
			sb.append(tmp - 1).append(" ");
		}
		
		System.out.print(sb.toString());
	}
}
