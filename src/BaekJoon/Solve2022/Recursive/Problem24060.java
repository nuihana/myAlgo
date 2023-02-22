package BaekJoon.Solve2022.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem24060 {
	private int order = 0, target;
	private int result = -1;
	private int[] tmp;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int input = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		int[] rstArr = new int[input];
		tmp = new int[input];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < input; i++) {
			rstArr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(rstArr, 0, rstArr.length - 1);
		System.out.print(result);

		br.close();
	}
	
	private void mergeSort(int[] arr, int start, int end) {
		if (target <= order) {
			return;
		}
		
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	
	private void merge(int[] arr, int start, int mid, int end) {
		if (target <= order) {
			return;
		}
		
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		
		while (j <= end) {
			tmp[k++] = arr[j++];
		}
		
		i = start;
		
		while (i <= end) {
			order++;
			
			if (target == order) {
				result = tmp[i];
				break;
			}
			
			arr[i] = tmp[i];
			i++;
		}
	}
}
