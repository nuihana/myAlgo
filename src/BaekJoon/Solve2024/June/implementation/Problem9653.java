package BaekJoon.Solve2024.June.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9653 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        sb.append("    8888888888  888    88888").append("\n");
        sb.append("   88     88   88 88   88  88").append("\n");
        sb.append("    8888  88  88   88  88888").append("\n");
        sb.append("       88 88 888888888 88   88").append("\n");
        sb.append("88888888  88 88     88 88    888888").append("\n").append("\n");
        sb.append("88  88  88   888    88888    888888").append("\n");
        sb.append("88  88  88  88 88   88  88  88").append("\n");
        sb.append("88 8888 88 88   88  88888    8888").append("\n");
        sb.append(" 888  888 888888888 88  88      88").append("\n");
        sb.append("  88  88  88     88 88   88888888");

        System.out.print(sb);

        br.close();
    }
}
