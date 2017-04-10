package algorithm.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	// Sinh hoán vị

	public List<Integer[]> PermutationGenerate(Integer[] input) {
		List<Integer[]> result = new ArrayList<Integer[]>();
		int lenght_ = input.length, i;
		int[] a = new int[lenght_];
		Integer[] output;
		for (int m = 0; m < lenght_; m++) {
			a[m] = m + 1;
		}

		do {
			output = new Integer[lenght_];
			for (int m = 0; m < lenght_; m++) {
				output[m] = input[a[m] - 1];
			}
			result.add(output);
			i = lenght_ - 1;
			while (i > 0 && a[i - 1] > a[i])
				--i;
			if (i > 0) {
				int k = lenght_;
				while (a[k - 1] < a[i - 1])
					// lùi dần từ cuối dãy để tìm phân tử đầu tiên lớn hơn x[i]
					--k;
				// đổi chỗ sau khi tìm thấy
				int temp = a[k - 1];
				a[k - 1] = a[i - 1];
				a[i - 1] = temp;
				// Lật ngược đoạn cuối cùng
				k = lenght_;
				for (int j = i + 1; j < k; j++, k--) {
					temp = a[j - 1];
					a[j - 1] = a[k - 1];
					a[k - 1] = temp;
				}
			}
		} while (i != 0);
		return result;
	}

	public List<String> PermutationGenerate(String[] input) {
		List<String> result = new ArrayList<String>();
		int lenght_ = input.length, i;
		int[] a = new int[lenght_];
		StringBuilder sb;
		for (int m = 0; m < lenght_; m++) {
			a[m] = m;
		}

		do {
			sb = new StringBuilder();
			for (int m = 0; m < lenght_; m++) {
				sb.append(input[a[m]]);
				sb.append(",");
			}
			result.add(sb.toString());
			i = lenght_ - 1;
			while (i > 0 && a[i - 1] > a[i])
				--i;
			if (i > 0) {
				int k = lenght_;
				while (a[k - 1] < a[i - 1])
					// lùi dần từ cuối dãy để tìm phân tử đầu tiên lớn hơn x[i]
					--k;
				// đổi chỗ sau khi tìm thấy
				int temp = a[k - 1];
				a[k - 1] = a[i - 1];
				a[i - 1] = temp;
				// Lật ngược đoạn cuối cùng
				k = lenght_;
				for (int j = i + 1; j < k; j++, k--) {
					temp = a[j - 1];
					a[j - 1] = a[k - 1];
					a[k - 1] = temp;
				}
			}
		} while (i != 0);
		System.gc();
		return result;
	}

	public List<String> PermutationGenerate(String[] a, String[] b, String[] c, List<String> resurlPermute, int count) {
		int k, n = a.length;
		String partOfPermute = "";
		for (k = 0; k < n; k++) {
			if (b[k] == null) {
				count++;

				c[count - 1] = a[k];
				b[k] = "1";
				if (count - 1 == n - 1) {
					for (int i = 0; i < n; i++) {
						partOfPermute += c[i] + ",";
					}
					resurlPermute.add(partOfPermute.substring(0, partOfPermute.length() - 1));
				}
				PermutationGenerate(a, b, c, resurlPermute, count);
				b[k] = null;
				count--;
			}
		}
		return resurlPermute;
	}

	public int Factorial(int n) {
		if (n < 0)
			return -1;
		else if (n == 0)
			return 1;
		else
			return n * Factorial(n - 1);
	}
	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		String[] a = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		String[] b = new String[20];
		String[] c = new String[20];
		List<String> resurlPermute = new ArrayList<String>();
		String[] d = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34",
				"35", "36", "37", "38", "39", "40" };
		d = d.clone();
		long start = System.currentTimeMillis();
		resurlPermute = permutation.PermutationGenerate(a);
		long end = System.currentTimeMillis();
		long times = end - start;
		System.out.println(times);
		System.gc();
		resurlPermute.clear();
		start = System.currentTimeMillis();
		resurlPermute = permutation.PermutationGenerate(a, b, c, resurlPermute, 0);
		end = System.currentTimeMillis();
		times = end - start;
		System.out.println(times);
		System.gc();
	}

	
}
