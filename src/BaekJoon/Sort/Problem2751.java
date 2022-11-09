package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2751 {
	private int[] resultArr;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		
		int[] valueArr = new int[inputCnt];
		resultArr = new int[inputCnt];
		
		for (int i = 0; i < inputCnt; i++) {
			valueArr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(valueArr, 0, valueArr.length - 1);
		
		for (int value : valueArr) {
			bw.write(value + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	private void mergeSort(int[] arr, int start, int end) {
		int mid;
		
		if (start < end) {
			mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	
	private void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while(i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				resultArr[k] = arr[i];
				i++;
				k++;
			} else {
				resultArr[k] = arr[j];
				j++;
				k++;
			}
		}
		
		if (i > mid) {
			for (int l = j; l <= end; l++) {
				resultArr[k] = arr[l];
				k++;
			}
		} else {
			for (int l = i; l <= mid; l++) {
				resultArr[k] = arr[l];
				k++;
			}
		}
		
		for (int l = start; l <= end; l++) {
			arr[l] = resultArr[l];
		}
	}
}
