package BaekJoon.Solve2024.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem20006 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            int idx = -1;

            for (int j = 0; j < roomList.size(); j++) {
                if (roomList.get(j).isPossible(level)) {
                    idx = j;
                    break;
                }
            }

            if (idx == -1) {
                Room newRoom = new Room(level, m);
                newRoom.in(level, id);
                roomList.add(newRoom);
            } else {
                roomList.get(idx).in(level, id);
            }
        }
        for (int i = 0; i < roomList.size(); i++) {
            System.out.print(roomList.get(i).print());
        }

        br.close();
    }

    class Room {
        int min, max, limit;
        List<Player> in;

        class Player {
            int level;
            String name;

            Player(int l, String n) {
                this.level = l;
                this.name = n;
            }
        }

        Room(int level, int l) {
            min = level - 10;
            max = level + 10;
            limit = l;
            in = new ArrayList<>();
        }

        boolean isPossible(int level) {
            return level >= min && level <= max && in.size() < limit;
        }

        void in(int level, String id) {
            in.add(new Player(level, id));
        }

        String print() {
            StringBuilder sb = new StringBuilder();
            if (limit == in.size()) {
                sb.append("Started!");
            } else {
                sb.append("Waiting!");
            }
            sb.append("\n");

            in.sort((o1, o2) -> o1.name.compareTo(o2.name));
            for (int i = 0; i < in.size(); i++) {
                sb.append(in.get(i).level).append(" ").append(in.get(i).name).append("\n");
            }
            return sb.toString();
        }
    }
}
