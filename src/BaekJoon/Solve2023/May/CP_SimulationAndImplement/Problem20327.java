package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.StringTokenizer;

public class Problem20327 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());

        Array arr = new Array(arrSize);
        for (int i = 0; i < (1 << arrSize); i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[(1 << arrSize)];
            for (int j = 0; j < (1 << arrSize); j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }

            arr.setArr(i, tmp);
        }

        for (int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            String level = st.nextToken();

            arr.command(command, level);
        }

        bw.write(arr.print());

        br.close();
        bw.close();
    }

    class Array {
        int dataSize;
        int[][] data;
        int[][] nextData;

        public Array(int size) {
            dataSize = (1 << size);
            data = new int[dataSize][dataSize];
            nextData = new int[dataSize][dataSize];
        }

        private void innerReverseHeight(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[x + intLevel - 1 - i][y + j];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void innerReverseWidth(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[x + i][y + intLevel - 1 - j];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void rotateClockWiseHalfpie(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[x + intLevel - 1 - j][y + i];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void rotateCounterClockWiseHalfpie(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[x + j][y + intLevel - 1 - i];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void outerReverseHeight(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[dataSize - x - intLevel + i][y + j];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void outerReverseWidth(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[x + i][dataSize - y - intLevel + j];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void rotateOuterClockWiseHalfpie(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[dataSize - y - intLevel + i][x + j];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }
        private void rotateOuterCounterClockWiseHalfpie(String level) {
            int intLevel = (1 << Integer.parseInt(level));

            int x = 0;
            while (x < dataSize) {
                int y = 0;
                while (y < dataSize) {
                    for (int i = 0; i < intLevel; i++) {
                        for (int j = 0; j < intLevel; j++) {
                            nextData[x + i][y + j] = data[y + i][dataSize - x - intLevel + j];
                        }
                    }
                    y += intLevel;
                }
                x += intLevel;
            }

            for (int i = 0; i < dataSize; i++) {
                System.arraycopy(nextData[i], 0, data[i], 0, dataSize);
            }
        }

        public void setArr(int idx, int[] dataArr) {
            System.arraycopy(dataArr, 0, data[idx], 0, dataSize);
        }
        public void command(String command, String level) {
            if (command.equals("1")) {
                innerReverseHeight(level);
            } else if (command.equals("2")) {
                innerReverseWidth(level);
            } else if (command.equals("3")) {
                rotateClockWiseHalfpie(level);
            } else if (command.equals("4")) {
                rotateCounterClockWiseHalfpie(level);
            } else if (command.equals("5")) {
                outerReverseHeight(level);
            } else if (command.equals("6")) {
                outerReverseWidth(level);
            } else if (command.equals("7")) {
                rotateOuterClockWiseHalfpie(level);
            } else if (command.equals("8")) {
                rotateOuterCounterClockWiseHalfpie(level);
            }
        }
        public String print() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dataSize; i++) {
                for (int j = 0; j < dataSize; j++) {
                    sb.append(data[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
