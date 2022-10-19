package BaekJoon.IO_ArithmeticOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2588 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(bf.readLine());
		int b = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		System.out.println(a * (b % 10));
		System.out.println(a * (b % 100));
		System.out.println(a * (b % 1000));
		System.out.println(a * b);
	}
}
