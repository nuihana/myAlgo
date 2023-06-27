package BaekJoon.Solve2023.June.Conte_Chococup2;

import java.io.*;
import java.util.*;

public class Problem28258 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<int[]> chkList = new ArrayList<>();
        Integer[][] answer = new Integer[2][];
        for (int i = 0; i < 100; i += 2) {
            int x = i / 10;
            int y = i % 10;
            if (x % 2 == 1) {
                y++;
            }

            chkList.add(new int[]{x, y});
        }

        // 내부 38개
        List<int[]> nextList = new ArrayList<>();
        int ans = 0;
        for (int[] p : chkList) {
            if (p[0] == 0 || p[0] == 9 || p[1] == 0 || p[1] == 9) {
                nextList.add(p);
                continue;
            }

            bw.write(query(p[0], p[1]));
            bw.newLine();
            bw.flush();

            ans = Integer.parseInt(br.readLine());
            if (ans == 1) {
                answer[0] = new Integer[]{p[0], p[1]};
                break;
            }
        }

        if (answer[0] != null) {
            bw.write(query(answer[0][0] - 1, answer[0][1]));
            bw.newLine();
            bw.flush();

            ans = Integer.parseInt(br.readLine());
            if (ans == 1) {
                answer[1] = new Integer[]{answer[0][0] - 1, answer[0][1]};
            }

            if (answer[1] == null) {
                bw.write(query(answer[0][0], answer[0][1] + 1));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{answer[0][0], answer[0][1] + 1};
                }
            }

            if (answer[1] == null) {
                bw.write(query(answer[0][0] + 1, answer[0][1]));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{answer[0][0] + 1, answer[0][1]};
                }
            }

            if (answer[1] == null) {
                answer[1] = new Integer[]{answer[0][0], answer[0][1] - 1};
            }
        }

        //외부 10개
        if (answer[0] == null) {
            for (int[] p : nextList) {
                if (p[0] == 0 && p[1] == 0 || p[0] == 9 && p[1] == 9) {
                    continue;
                }

                bw.write(query(p[0], p[1]));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[0] = new Integer[]{p[0], p[1]};
                    break;
                }
            }
        }

        if (answer[0] != null && answer[1] == null) {
            if (answer[0][0] == 0) {
                bw.write(query(answer[0][0], answer[0][1] - 1));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{answer[0][0], answer[0][1] - 1};
                }

                if (answer[1] == null) {
                    bw.write(query(answer[0][0], answer[0][1] + 1));
                    bw.newLine();
                    bw.flush();

                    ans = Integer.parseInt(br.readLine());
                    if (ans == 1) {
                        answer[1] = new Integer[]{answer[0][0], answer[0][1] + 1};
                    }
                }

                if (answer[1] == null) {
                    answer[1] = new Integer[]{answer[0][0] + 1, answer[0][1]};
                }
            } else if (answer[0][0] == 9) {
                bw.write(query(answer[0][0], answer[0][1] - 1));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{answer[0][0], answer[0][1] - 1};
                }

                if (answer[1] == null) {
                    bw.write(query(answer[0][0], answer[0][1] + 1));
                    bw.newLine();
                    bw.flush();

                    ans = Integer.parseInt(br.readLine());
                    if (ans == 1) {
                        answer[1] = new Integer[]{answer[0][0], answer[0][1] + 1};
                    }
                }

                if (answer[1] == null) {
                    answer[1] = new Integer[]{answer[0][0] - 1, answer[0][1]};
                }
            } else if (answer[0][1] == 0) {
                bw.write(query(answer[0][0] - 1, answer[0][1]));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{answer[0][0] - 1, answer[0][1]};
                }

                if (answer[1] == null) {
                    bw.write(query(answer[0][0] + 1, answer[0][1]));
                    bw.newLine();
                    bw.flush();

                    ans = Integer.parseInt(br.readLine());
                    if (ans == 1) {
                        answer[1] = new Integer[]{answer[0][0] + 1, answer[0][1]};
                    }
                }

                if (answer[1] == null) {
                    answer[1] = new Integer[]{answer[0][0], answer[0][1] + 1};
                }
            } else if (answer[0][1] == 9) {
                bw.write(query(answer[0][0] - 1, answer[0][1]));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{answer[0][0] - 1, answer[0][1]};
                }

                if (answer[1] == null) {
                    bw.write(query(answer[0][0] + 1, answer[0][1]));
                    bw.newLine();
                    bw.flush();

                    ans = Integer.parseInt(br.readLine());
                    if (ans == 1) {
                        answer[1] = new Integer[]{answer[0][0] + 1, answer[0][1]};
                    }
                }

                if (answer[1] == null) {
                    answer[1] = new Integer[]{answer[0][0], answer[0][1] - 1};
                }
            }
        }

        if (answer[0] == null) {
            bw.write(query(0, 0));
            bw.newLine();
            bw.flush();

            ans = Integer.parseInt(br.readLine());
            if (ans == 1) {
                answer[0] = new Integer[]{0, 0};

                bw.write(query(0, 1));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{0, 1};
                } else {
                    answer[1] = new Integer[]{1, 0};
                }
            } else {
                answer[0] = new Integer[]{9, 9};

                bw.write(query(9, 8));
                bw.newLine();
                bw.flush();

                ans = Integer.parseInt(br.readLine());
                if (ans == 1) {
                    answer[1] = new Integer[]{9, 8};
                } else {
                    answer[1] = new Integer[]{8, 9};
                }
            }
        }

        bw.write(answer(answer[0], answer[1]));

        br.close();
        bw.close();
    }

    private String query(int x, int y) {
        return "? ".concat(String.valueOf(x)).concat(" ").concat(String.valueOf(y));
    }

    private String answer(Integer[] idx1, Integer[] idx2) {
        return "! ".concat(String.valueOf(idx1[0]).concat(" ").concat(String.valueOf(idx1[1]))).concat(" ").concat(String.valueOf(idx2[0]).concat(" ").concat(String.valueOf(idx2[1])));
    }
}
