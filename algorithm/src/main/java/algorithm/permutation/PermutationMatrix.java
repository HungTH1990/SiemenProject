package algorithm.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationMatrix {
	public List<String> permute2;
	public String[] array;
	public int row;
	public StringBuilder valueCurrent;
	public Integer count;
	public CombinationsMatrix combinationsMatrix;

	public static void main(String[] args) {
		String[] Test = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34",
				"35", "36", "37", "38", "39", "40" };
		PermutationMatrix permutationMatrix = new PermutationMatrix(Test, 5);
		for (int i = 0; i < 100000; i++) {
			StringBuilder sb = permutationMatrix.getNext();
			System.out.println(sb);
		}

		// resurtPermute.clear();
	}

	// Tinh hoan vi dong cua mang 2 chieu
	public PermutationMatrix(String[] array_, int row_) {
		Permutation permutation = new Permutation();
		array = array_;
		row = row_;
		count = 0;
		int lengthAray = array.length;

		String[] array1d = new String[row];
		// CombinationsMatrix combinationsMatrix=new CombinationsMatrix();

		// Hoan vi mang
		for (int i = 0; i < row; i++) {
			String[] array1 = new String[lengthAray / row];
			for (int j = 0; j < lengthAray / row; j++) {
				array1[j] = array[(lengthAray / row) * i + j];
			}

			List<String> permute1 = new ArrayList<String>();
			permute1 = permutation.PermutationGenerate(array1);
			array1d[i] = permute1.toString();
		}

		permute2 = new ArrayList<String>();
		permute2 = permutation.PermutationGenerate(array1d);
	}

	public StringBuilder getNext() {
		Permutation permutation = new Permutation();
		int lengthAray2d = permutation.Factorial(array.length / row);
		String[][] array2d = new String[row][lengthAray2d];
		int countPermute2 = permute2.size();
		int i = count / countPermute2;
		String a = permute2.get(i);
		a = a.replaceAll("\\]|\\[", ",");
		a = a.replace(",,,,", ", ");
		a = a.replaceAll(",,,|,,", ",");
		a = a.replace(" ", " ,");
		String[] b = a.split(" ");
		for (int j = 0; j < row; j++) {
			for (int k = 0; k < lengthAray2d; k++) {
				array2d[j][k] = b[j * lengthAray2d + k];
			}
		}
		if (count % countPermute2 == 0) {
			combinationsMatrix = new CombinationsMatrix(array2d);
		}
		valueCurrent = combinationsMatrix.valueCurrent;
		combinationsMatrix.CombinationsMatrixNext();
		System.gc();
		count++;
		return valueCurrent;
	}

}
