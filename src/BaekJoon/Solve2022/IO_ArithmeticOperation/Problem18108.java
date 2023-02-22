package BaekJoon.Solve2022.IO_ArithmeticOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem18108 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String value = bf.readLine();
		
		bf.close();
		
		System.out.print(Integer.parseInt(value) - 543);
	}
}
