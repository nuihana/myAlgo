package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2290 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int fontSize = Integer.parseInt(st.nextToken());
        String displayNum = st.nextToken();

        Font font = new Font(fontSize);
        bw.write(font.print(displayNum));

        br.close();
        bw.close();
    }

    class Font {
        int size;
        private boolean[][] displayInfo = new boolean[10][7];

        public Font(int fontSize) {
            this.size = fontSize;

            displayInfo[0][3] = true;

            displayInfo[1][0] = true;
            displayInfo[1][1] = true;
            displayInfo[1][3] = true;
            displayInfo[1][4] = true;
            displayInfo[1][6] = true;

            displayInfo[2][1] = true;
            displayInfo[2][5] = true;

            displayInfo[3][1] = true;
            displayInfo[3][4] = true;

            displayInfo[4][0] = true;
            displayInfo[4][4] = true;
            displayInfo[4][6] = true;

            displayInfo[5][2] = true;
            displayInfo[5][4] = true;

            displayInfo[6][2] = true;

            displayInfo[7][1] = true;
            displayInfo[7][3] = true;
            displayInfo[7][4] = true;
            displayInfo[7][6] = true;

            displayInfo[9][4] = true;
        }

        public String print(String val) {
            StringBuilder sb = new StringBuilder();

            int[] numArr = new int[val.length()];
            for (int i = 0; i < val.length(); i++) {
                numArr[i] = Integer.parseInt(val.substring(i, i + 1));
            }

            for (int i = 0; i < 7; i++) {
                if (i == 0 || i == 3 || i == 6) {
                    for (int j = 0; j < numArr.length; j++) {
                        sb.append(" ");

                        for (int k = 0; k < size; k++) {
                            if (displayInfo[numArr[j]][i]) {
                                sb.append(" ");
                            } else {
                                sb.append("-");
                            }
                        }

                        sb.append(" ");
                        sb.append(" ");
                    }
                    sb.append("\n");
                } else {
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < numArr.length; k++) {
                            if (displayInfo[numArr[k]][i]) {
                                sb.append(" ");
                            } else {
                                sb.append("|");
                            }

                            for (int l = 0; l < size; l++) {
                                sb.append(" ");
                            }

                            if (displayInfo[numArr[k]][i + 1]) {
                                sb.append(" ");
                            } else {
                                sb.append("|");
                            }
                            sb.append(" ");
                        }
                        sb.append("\n");
                    }
                    i++;
                }
            }

            return sb.toString();
        }
    }
}
