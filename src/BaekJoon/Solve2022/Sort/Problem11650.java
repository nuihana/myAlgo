package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11650 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		List<Coordinate> valList = new ArrayList<>();
		
		for (int i = 0; i < inputCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			valList.add(new Coordinate(st.nextToken(), st.nextToken()));
		}
		
		valList.sort((a, b) -> a.getX() - b.getX() == 0 ? a.getY() - b.getY() : a.getX() - b.getX());
		
		for (Coordinate val : valList) {
			bw.write(val.getX() + " " + val.getY() + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	class Coordinate {
		private int x;
		private int y;
		
		public Coordinate(String xStr, String yStr) {
			this.x = Integer.parseInt(xStr);
			this.y = Integer.parseInt(yStr);
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
}
