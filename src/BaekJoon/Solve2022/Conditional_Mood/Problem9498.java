package BaekJoon.Solve2022.Conditional_Mood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

public class Problem9498 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(bf.readLine());
		
		bf.close();
		
		double[] limit = {0, 60, 70, 80, 90};
		String[] grade = {"F", "D", "C", "B", "A"};
		
		ChoiceFormat cf = new ChoiceFormat(limit, grade);
		
		System.out.print(cf.format(input));
	}
}
