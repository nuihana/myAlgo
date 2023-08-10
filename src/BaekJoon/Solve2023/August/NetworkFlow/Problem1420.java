package BaekJoon.Solve2023.August.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem1420 {
    int N, M, V;
    int INF = 100001;
    char[][] map;
    ArrayList<Edge>[] eglist;
    int start, end;
    int sx, sy, ex, ey;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = N * M;

        map = new char[N+1][M+1];
        eglist = new ArrayList[2*V+1];

        for(int i=1; i<=2*V; i++) {
            eglist[i] = new ArrayList();
        }

        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j-1);

                if(map[i][j]=='#') continue;

                int from = (i-1)*M + j;
                int to = (i-1)*M + j + V;

                if(map[i][j]=='K') {
                    sx = i;
                    sy = j;

                    start = to;
                }
                if(map[i][j]=='H') {
                    ex = i;
                    ey = j;

                    end = from;
                }

                for(int k=1; k<=4; k++) {
                    int ni = sx + dx[k-1];
                    int nj = sy + dy[k-1];


                    if(ni==ex && nj==ey) {
                        System.out.println("-1");
                        return;
                    }
                }


                Edge fromto_edge = new Edge(from, to, 1);
                Edge tofrom_edge = new Edge(to, from, 0);
                fromto_edge.rev = tofrom_edge;
                tofrom_edge.rev = fromto_edge;

                eglist[from].add(fromto_edge);
                eglist[to].add(tofrom_edge);
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                for(int k=1; k<=4; k++) {
                    if(map[i][j]=='#') continue;

                    int ni = i + dx[k-1];
                    int nj = j + dy[k-1];

                    if(ni<1 || nj<1 || ni>N || nj>M) continue;
                    if(map[ni][nj]=='#') continue;

                    int from = (i-1)*M + j + V;
                    int to = (ni-1)*M + nj;

                    Edge fromto_edge = new Edge(from, to, INF);
                    Edge tofrom_edge = new Edge(to, from, 0);
                    fromto_edge.rev = tofrom_edge;
                    tofrom_edge.rev = fromto_edge;

                    eglist[from].add(fromto_edge);
                    eglist[to].add(tofrom_edge);
                }
            }
        }

        long ans = get_max_flow(start, end);

        System.out.println(ans);
    }

    private int get_max_flow(int start, int end) {
        int tot_max_flow = 0;
        int cnt=0;

        while(true) {
            Edge[] path = new Edge[2*V+1];

            Queue<Integer> pq = new LinkedList();
            pq.add(start);

            while(!pq.isEmpty()) {
                int curr = pq.poll();
                if(curr==end) break;

                for(Edge next: eglist[curr]) {

                    if(path[next.to]==null && next.capa-next.flow>0) {
                        path[next.to] = next;
                        pq.add(next.to);

                        if(next.to==end) break;
                    }
                }
            }

            if(path[end]==null) break;

            int this_min_flow = INF;

            int curr = end;
            while(curr!=start) {
                this_min_flow = Math.min(this_min_flow,
                        path[curr].capa-path[curr].flow);
                curr = path[curr].from;
            }

            curr = end;
            while(curr!=start) {
                path[curr].flow += this_min_flow;
                path[curr].rev.flow -= this_min_flow;

                curr = path[curr].from;
            }

            tot_max_flow += this_min_flow;
        }

        return tot_max_flow;
    }

    class Edge {
        int from;
        int to;
        int capa;
        int flow;
        Edge rev;

        public Edge(int from, int to, int capa) {
            this.from = from;
            this.to = to;
            this.capa = capa;
        }
    }
}
