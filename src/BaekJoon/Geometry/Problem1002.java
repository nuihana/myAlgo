package BaekJoon.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1002 {
	private void solution() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Locale lo = new Locale();
        int[] personA = new int[3];
        int[] personB = new int[3];
        
        int limit = Integer.parseInt(br.readLine().trim());
        
        for (int i = 0; i < limit; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
            for (int idx = 0; idx < 6; idx++) {
                if (idx < 3) {
                    personA[idx] = Integer.parseInt(st.nextToken());
                } else {
                    personB[idx - 3] = Integer.parseInt(st.nextToken());
                }
            }
            
            int distance = lo.getDistance(personA, personB);
            
            if (lo.isSamePlace(personA, personB) && personA[2] == personB[2]) {
            	bw.write("-1");
            } else if (lo.isSamePlace(personA, personB) || (distance > Math.pow(personA[2] + personB[2], 2)) || (distance < Math.pow(personA[2] - personB[2], 2))) {
            	bw.write("0");
            } else if ((distance == Math.pow(personA[2] + personB[2], 2)) || (distance == Math.pow(personA[2] - personB[2], 2))) {
            	bw.write("1");
            } else {
            	bw.write("2");
            }
        }
        
        br.close();
		bw.close();
	}
}

class Locale {
    public boolean isSamePlace(int[] personA, int[] personB) {
        if (personA[0] - personB[0] == 0 && personA[1] - personB[1] == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getDistance(int[] personA, int[] personB) {
        return (int) (Math.pow(personB[0] - personA[0], 2) + Math.pow(personB[1] - personA[1], 2));
    }
}