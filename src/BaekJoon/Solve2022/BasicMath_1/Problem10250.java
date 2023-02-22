package BaekJoon.Solve2022.BasicMath_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10250 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int execCnt = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < execCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int floor = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            
            int targetRoomNum = (int)Math.ceil((double)customer / floor);
            int targetFloor = customer % floor;
            targetFloor = targetFloor == 0 ? floor : targetFloor;
            
            bw.write(Integer.toString(targetFloor) + String.format("%02d", targetRoomNum));
            bw.write("\n");
        }
		
		br.close();
        bw.flush();
		bw.close();
	}
}
