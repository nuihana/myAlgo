package BaekJoon.SetAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem11478 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		Set<String> resultSet = new HashSet<>();
		
		for(int i = 1; i <= input.length(); i++) {
			for(int j = 0; j + i < input.length(); j++) {
				resultSet.add(input.substring(j, j + i));
			}
		}
		
		bw.write(Integer.toString(resultSet.size()));

		bw.close();
		br.close();
	}
}
