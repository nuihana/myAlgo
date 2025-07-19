package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem5217 {
    public void solution() throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int n = 0; n < numCases; n++)
        {
            int target = sc.nextInt();

            ArrayList<Integer> answer = solveSumPairs(target);

            System.out.print("Pairs for "+target+": ");

            for (int i = 0; i<answer.size(); i+=2 ) {
                if (i>0)
                    System.out.print(", ");
                System.out.print(answer.get(i) + " " + answer.get(i+1));
            }
            System.out.println();
        }
    }

    private ArrayList<Integer> solveSumPairs(int target) {

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i < target; i++) {
            for (int j = i; j < target; j++) {
                if (i != j && i + j == target) {
                    answer.add(i);
                    answer.add(j);
                }
            }
        }

        return answer;
    }
}
