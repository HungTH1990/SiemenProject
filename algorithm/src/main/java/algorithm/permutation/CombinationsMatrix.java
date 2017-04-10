package algorithm.permutation;

public class CombinationsMatrix {

	public StringBuilder valueCurrent;
	public CombinationsMatrix getNext;
	public Integer countCurrent;
	public Integer totalCombinationCount;
	public int sizeArray;
	public int countTwoDimStringArray;
	public String[][] twoDimStringArray;
	public int[] counterArray;

	public CombinationsMatrix(String[][] twoDimStringArray_) {

		
		twoDimStringArray = twoDimStringArray_;

		sizeArray = twoDimStringArray_[0].length;
		countTwoDimStringArray = twoDimStringArray_.length;

		counterArray = new int[countTwoDimStringArray];
		
		totalCombinationCount = (int) Math.pow(sizeArray, countTwoDimStringArray);
		countCurrent = 0;
		valueCurrent = combinations(twoDimStringArray_, countCurrent);
		

	}

	public void getCombinationsMatrix(Integer count_) {
		valueCurrent = combinations(twoDimStringArray, count_);
		countCurrent = count_;
	}

	public CombinationsMatrix CombinationsMatrixNext() {
		getCombinationsMatrix(countCurrent + 1);
		return null;
	}

	public StringBuilder combinations(String[][] twoDimStringArray, Integer countCurrent_) {

		StringBuilder sb = new StringBuilder(100000);
		sb.setLength(0);
		for (int i = 0; i < countTwoDimStringArray; ++i) {
			sb.append(twoDimStringArray[i][counterArray[i]]);
		}
		
		for (int incIndex = countTwoDimStringArray - 1; incIndex >= 0; --incIndex) {
			if (counterArray[incIndex] + 1 < sizeArray) {
				++counterArray[incIndex];
				break;
			}
			counterArray[incIndex] = 0;
		}
		return sb;
	}

	public static void main(String[] args) {
		String[][] twoDimStringArray = { { "11", "12", "13", "14" }, { "21", "22", "23", "24" },
				{ "31", "32", "33", "34" }, { "41", "42", "43", "44" }, { "51", "52", "53", "54" } };
		CombinationsMatrix combinationsMatrix = new CombinationsMatrix(twoDimStringArray);
		for (int i = 0; i < combinationsMatrix.totalCombinationCount; i++) {
			System.out.println(combinationsMatrix.valueCurrent);
			combinationsMatrix.CombinationsMatrixNext();
		}
		System.gc();
	}
}
