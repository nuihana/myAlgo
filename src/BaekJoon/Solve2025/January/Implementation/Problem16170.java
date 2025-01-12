package BaekJoon.Solve2025.January.Implementation;

import java.time.LocalDateTime;

public class Problem16170 {
    public void solution() {
        LocalDateTime now = LocalDateTime.now();
        now.minusHours(9);
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.print(now.getDayOfMonth());
    }
}
