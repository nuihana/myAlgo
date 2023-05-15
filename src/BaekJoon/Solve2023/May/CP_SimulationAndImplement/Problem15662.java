package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.*;

public class Problem15662 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int gearCnt = Integer.parseInt(br.readLine());
        GearBox result = new GearBox();

        for (int i = 0; i < gearCnt; i++) {
            result.addGear(new Gear(br.readLine()));
        }

        int commandCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            result.rotate(idx, direction);
        }

        bw.write(String.valueOf(result.getNorthIsS()));

        br.close();
        bw.close();
    }

    class GearBox {
        List<Gear> gearList;

        public GearBox() {
            gearList = new ArrayList<>();
        }

        public void addGear(Gear item) {
            gearList.add(item);
        }
        public void rotate(int idx, int direction) {
            int left = idx - 1;
            while (left > 0 && gearList.get(left - 1).getRightEdge() != gearList.get(left).getLeftEdge()) {
                left--;
                direction *= -1;
            }

            int right = idx - 1;
            while (right < gearList.size() - 1 && gearList.get(right).getRightEdge() != gearList.get(right + 1).getLeftEdge()) {
                right++;
            }

            for (int i = left, dir = direction; i <= right; i++) {
                gearList.get(i).rotate(dir);
                dir *= -1;
            }
        }
        public int getNorthIsS() {
            int result = 0;
            for (Gear gear : gearList) {
                if (gear.getTopEdge() == 1) {
                    result++;
                }
            }
            return result;
        }
    }
    class Gear {
        int[] edgeStat; // N극 : 0, S극 : 1

        public Gear(String stat) {
            edgeStat = new int[stat.length()];
            for (int i = 0; i < stat.length(); i++) {
                edgeStat[i] = Integer.parseInt(stat.substring(i, i + 1));
            }
        }

        public int getLeftEdge() {
            return edgeStat[6];
        }
        public int getRightEdge() {
            return edgeStat[2];
        }
        public int getTopEdge() {
            return edgeStat[0];
        }
        public void rotate(int direction) {
            int[] tmp = new int[edgeStat.length];
            if (direction > 0) {
                for (int i = 0; i < edgeStat.length; i++) {
                    tmp[i] = edgeStat[(edgeStat.length + i - 1) % edgeStat.length];
                }
            } else {
                for (int i = 0; i < edgeStat.length; i++) {
                    tmp[i] = edgeStat[(i + 1) % edgeStat.length];
                }
            }
            edgeStat = tmp;
        }
    }
}
