package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14890 {
    int size;
    int l;
    int[][] field;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        field = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            result += chkPath(true, i);
            result += chkPath(false, i);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int chkPath(boolean direction, int idx) {
        boolean[] builded = new boolean[size];
        boolean flag = true;
        if (direction) { // horizontal 방향
            for (int i = 1, bf = field[idx][0]; i < size; i++) {
                if (field[idx][i] != bf) {
                    if (Math.abs(field[idx][i] - bf) > 1) {
                        flag = false;
                        break;
                    } else if (field[idx][i] > bf) {
                        for (int j = 1, fix = bf; j <= l; j++) {
                            if (i - j < 0) {
                                flag = false;
                                break;
                            }

                            if (field[idx][i - j] == fix) {
                                if (builded[i - j]) {
                                    flag = false;
                                    break;
                                } else {
                                    builded[i - j] = true;
                                }
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    } else {
                        for (int j = 0, fix = field[idx][i]; j < l; j++) {
                            if (i + j >= size) {
                                flag = false;
                                break;
                            }

                            if (field[idx][i + j] == fix) {
                                if (builded[i + j]) {
                                    flag = false;
                                    break;
                                } else {
                                    builded[i + j] = true;
                                }
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if(!flag) {
                        break;
                    }
                }

                bf = field[idx][i];
            }
        } else { // vertical 방향
            for (int i = 1, bf = field[0][idx]; i < size; i++) {
                if (field[i][idx] != bf) {
                    if (Math.abs(field[i][idx] - bf) > 1) {
                        flag = false;
                        break;
                    } else if (field[i][idx] > bf) {
                        for (int j = 1, fix = bf; j <= l; j++) {
                            if (i - j < 0) {
                                flag = false;
                                break;
                            }

                            if (field[i - j][idx] == fix) {
                                if (builded[i - j]) {
                                    flag = false;
                                    break;
                                } else {
                                    builded[i - j] = true;
                                }
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    } else {
                        for (int j = 0, fix = field[i][idx]; j < l; j++) {
                            if (i + j >= size) {
                                flag = false;
                                break;
                            }

                            if (field[i + j][idx] == fix) {
                                if (builded[i + j]) {
                                    flag = false;
                                    break;
                                } else {
                                    builded[i + j] = true;
                                }
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if(!flag) {
                        break;
                    }
                }

                bf = field[i][idx];
            }
        }

        if (flag) {
            return 1;
        } else {
            return 0;
        }
    }
}
