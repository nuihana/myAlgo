package BaekJoon.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2447 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		int[][] result = new int[input][input];
		
		setResult(result, null, 1);
		
		for (int i = 0, limit_i = result.length; i < limit_i; i++) {
			for (int j = 0, limit_j = result[i].length; j < limit_j; j++) {
				if (result[i][j] == 1) {
					bw.write("*");
				} else {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}

		br.close();
		bw.close();
	}
	
	private void setResult(int[][] arr, int[][] fragment, int num) {
		if (num > arr.length) {
			return;
		}
		
		int turnNum = num * 3;
		
		if (fragment == null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != 1 || j != 1) {
						arr[i][j] = 1;
					}
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != 0 || j != 0) {
						deepCopy(arr, fragment, i * num, j * num, num);
					}
				}
			}
		}
		
		setResult(arr, arr, turnNum);
	}
	
	private void deepCopy(int[][] arr, int[][] fragment, int x, int y, int size) {
		for (int i = x, limit_i = x + size; i < limit_i; i++) {
			for (int j = y, limit_j = y + size; j < limit_j; j++) {
				arr[i][j] = fragment[i - x][j - y];
			}
		}
	}
}
