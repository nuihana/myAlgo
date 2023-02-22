package BaekJoon.Solve2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class quickSort {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		
		int[] valueArr = new int[inputCnt];
		
		for (int i = 0; i < inputCnt; i++) {
			valueArr[i] = Integer.parseInt(br.readLine());
		}
		
		quickSort(valueArr, 0, valueArr.length - 1);
		
		for (int value : valueArr) {
			bw.write(value + "\n");
		}
		
		br.close();
		bw.close();
	}
	
	private void quickSort(int[] arr, int start, int end) {
		if (end <= start) {
			return;
		}
		
		int pivot = arr[start];
		int leftIdx = start;
		int rightIdx = end;
		
		while (leftIdx < rightIdx) {
			while(arr[rightIdx] > pivot && leftIdx < rightIdx) {
				rightIdx--;
			}
			
			while(arr[leftIdx] < pivot && leftIdx < rightIdx) {
				leftIdx++;
			}
			
			if (leftIdx < rightIdx) {
				int tmp = arr[rightIdx];
				arr[rightIdx] = arr[leftIdx];
				arr[leftIdx] = tmp;
			}
		}
		
		int tmp = arr[rightIdx];
		arr[rightIdx] = pivot;
		arr[start] = tmp;
		
		quickSort(arr, start, rightIdx - 1);
		quickSort(arr, rightIdx + 1, end);
	}
}
