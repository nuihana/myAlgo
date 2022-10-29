package BaekJoon.Function;

import java.util.Arrays;

public class Problem15596 {
	public long sum(int[] input) {
		return Arrays.stream(input).summaryStatistics().getSum();
	}
}
