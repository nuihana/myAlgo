package LeetCode.Solve2026.May.String;

public class Question944 {
    public int minDeletionSize(String[] strs) {
        int res = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            boolean isSort = true;

            char before = strs[0].charAt(i);
            for (int j = 1; j < strs.length && isSort; j++) {
                char now = strs[j].charAt(i);

                if (before > now) isSort = false;
                before = now;
            }

            if (!isSort) res++;
        }

        return res;
    }
}
