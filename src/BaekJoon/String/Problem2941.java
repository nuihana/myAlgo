package BaekJoon.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem2941 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		List<String> cAlphaList = new ArrayList<>();
		cAlphaList.add("c=");
		cAlphaList.add("c-");
		cAlphaList.add("dz=");
		cAlphaList.add("d-");
		cAlphaList.add("lj");
		cAlphaList.add("nj");
		cAlphaList.add("s=");
		cAlphaList.add("z=");
		
		for(String tmp : cAlphaList) {
			if (input.contains(tmp)) {
				input = input.replaceAll(tmp, "?");
			}
		}
		
		bw.write(Integer.toString(input.length()));
		bw.flush();

		br.close();
		bw.close();
	}
}
