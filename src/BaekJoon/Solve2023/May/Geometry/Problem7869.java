package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem7869 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Circle a = new Circle(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Circle b = new Circle(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        if (a.radius < b.radius) {
            Circle tmp = a;
            a = b;
            b = tmp;
        }

        double interval = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        double result;
        if (a.radius + b.radius <= interval) {
            result = 0;
        } else if (a.radius - b.radius >= interval) {
            result = b.radius * b.radius * Math.PI;
        } else {
            double thetaA = 2 * Math.acos((a.radius * a.radius + interval * interval - b.radius * b.radius) / (2 * a.radius * interval));
            double thetaB = 2 * Math.acos((b.radius * b.radius + interval * interval - a.radius * a.radius) / (2 * b.radius * interval));

            double sizeA = (a.radius * a.radius) * (thetaA - Math.sin(thetaA)) / 2;
            double sizeB = (b.radius * b.radius) * (thetaB - Math.sin(thetaB)) / 2;

            result = sizeA + sizeB;
        }

        bw.write(String.format("%.3f", result));

        br.close();
        bw.close();
    }

    class Circle {
        double x;
        double y;
        double radius;

        public Circle(double x_, double y_, double radius_) {
            this.x = x_;
            this.y = y_;
            this.radius = radius_;
        }
    }
}
