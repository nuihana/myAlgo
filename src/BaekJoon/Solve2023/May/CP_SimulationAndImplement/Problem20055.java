package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.*;

public class Problem20055 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int brokenLimit = Integer.parseInt(st.nextToken());

        ConveyorBelt cb = new ConveyorBelt(len, brokenLimit);
        int[] hp = new int[len * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len * 2; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
        cb.setHp(hp);

        bw.write(cb.run());

        br.close();
        bw.close();
    }

    class ConveyorBelt {
        int[] hp;
        int length;
        int limit;
        int brokenCnt;

        public ConveyorBelt(int length_, int limit_) {
            this.length = length_;
            this.limit = limit_;

            hp = new int[length * 2];
            brokenCnt = 0;
        }

        private boolean isExit() {
            if (brokenCnt >= limit) {
                return false;
            }
            return true;
        }

        public void setHp(int[] hp_) {
            System.arraycopy(hp_, 0, hp, 0, hp_.length);
        }
        public String run() {
            int turn = 0;
            List<Integer> robotIdx = new ArrayList<>();

            while(isExit()) {
                // 1. 회전
                int tmp = hp[hp.length - 1];
                System.arraycopy(hp, 0, hp, 1, hp.length - 1);
                hp[0] = tmp;

                List<Integer> tmpList = new ArrayList<>();
                for(int i = 0; i < robotIdx.size(); i++) {
                    if (robotIdx.get(i) + 1 != length - 1) {
                        tmpList.add(robotIdx.get(i) + 1);
                    }
                }
                robotIdx = new ArrayList<>(tmpList);

                // 2. 로봇 이동
                tmpList = new ArrayList<>();
                for(int i = 0; i < robotIdx.size(); i++) {
                    if (hp[robotIdx.get(i) + 1] > 0 && !tmpList.contains(robotIdx.get(i) + 1)) {
                        hp[robotIdx.get(i) + 1] -= 1;
                        if (hp[robotIdx.get(i) + 1] == 0) {
                            brokenCnt++;
                        }
                        if (robotIdx.get(i) + 1 != length - 1) {
                            tmpList.add(robotIdx.get(i) + 1);
                        }
                    } else {
                        tmpList.add(robotIdx.get(i));
                    }
                }
                robotIdx = new ArrayList<>(tmpList);

                // 3. 로봇 추가
                if (hp[0] > 0 && !robotIdx.contains(0)) {
                    hp[0] -= 1;
                    if (hp[0] == 0) {
                        brokenCnt++;
                    }
                    robotIdx.add(0);
                }

                turn++;
            }

            return String.valueOf(turn);
        }
    }
}
