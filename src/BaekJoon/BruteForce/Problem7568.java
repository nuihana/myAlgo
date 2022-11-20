package BaekJoon.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem7568 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		List<Person> personList = new ArrayList<>();
		
		for (int i = 0; i < input; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			personList.add(new Person(st.nextToken(), st.nextToken()));
		}
		
		for (int i = 0; i < input; i++) {
			Person tmp = personList.get(i);
			
			for (int j = 0; j < input; j++) {
				if (i != j) {
					Person tmpCp = personList.get(j);
					tmp.compareTo(tmpCp);
				}
			}
		}
		
		for (int i = 0; i < input; i++) {
			bw.write(personList.get(i).getOrder() + " ");
		}
		
		br.close();
		bw.close();
	}
	
	class Person {
		private int weight;
		private int tall;
		private int order = 1;
		
		Person(String weight, String tall) {
			this.weight = Integer.parseInt(weight);
			this.tall = Integer.parseInt(tall);
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public int getTall() {
			return this.tall;
		}
		
		public int getOrder() {
			return this.order;
		}

		public void compareTo(Person obj) {
			if (this.weight < obj.getWeight() && this.tall < obj.getTall()) {
				this.order++;
			}
		}
	}
}