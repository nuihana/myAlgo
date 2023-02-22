package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem10814 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		List<Person> valList = new ArrayList<>();
		
		for (int i = 0; i < inputCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			valList.add(new Person(st.nextToken(), st.nextToken(), i));
		}
		
		valList.sort((a, b) -> a.getAge() - b.getAge() == 0 ? a.getOrder() - b.getOrder() : a.getAge() - b.getAge());
		
		for (Person val : valList) {
			bw.write(val.getAge() + " " + val.getName() + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	class Person {
		private int order;
		private int age;
		private String name;
		
		public Person(String age_, String name_, int order_) {
			this.age = Integer.parseInt(age_);
			this.name = name_;
			this.order = order_;
		}

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		public int getOrder() {
			return order;
		}
	}
}
