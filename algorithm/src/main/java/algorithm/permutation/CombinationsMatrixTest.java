package algorithm.permutation;

import java.util.ArrayList;
import java.util.List;

public class CombinationsMatrixTest {
	public static List<String> combinations(String[][] twoDimStringArray) {
		int sizeArray = twoDimStringArray[0].length;
		int countTwoDimStringArray = twoDimStringArray.length;
		int counterArray[] = new int[countTwoDimStringArray];
		int totalCombinationCount = (int) Math.pow(sizeArray, countTwoDimStringArray);
		List<String> combinationList = new ArrayList<String>();
		StringBuilder sb=new StringBuilder(100000);
		for (int countdown = totalCombinationCount; countdown > 0; --countdown) {
			sb.setLength(0);
			for (int i = 0; i < countTwoDimStringArray; ++i) {
				sb.append(twoDimStringArray[i][counterArray[i]]);
			}
			combinationList.add(sb.toString());
			for (int incIndex = countTwoDimStringArray - 1; incIndex >= 0; --incIndex) {
				if (counterArray[incIndex] + 1 < sizeArray) {
					++counterArray[incIndex];
					break;
				}
				counterArray[incIndex] = 0;
			}
			if(countdown%10000==0){
				System.gc();
			}
		}
		return combinationList;
	}

	public static List<String> combinations1(String[][] twoDimStringArray) {
		int sizeArray = twoDimStringArray[0].length;
		int counterArray[] = new int[twoDimStringArray.length];
		int countTwoDimStringArray = twoDimStringArray.length;
		int totalCombinationCount = 1;
		for (int i = 0; i < countTwoDimStringArray; ++i) {
			totalCombinationCount *= sizeArray;
		}
		List<String> combinationList = new ArrayList<String>();

		StringBuilder sb;
		for (int countdown = totalCombinationCount; countdown > 0; --countdown) {
			sb = new StringBuilder();
			for (int i = 0; i < countTwoDimStringArray; ++i) {
				sb.append(twoDimStringArray[i][counterArray[i]]);
			}
			combinationList.add(sb.toString());
			for (int incIndex = countTwoDimStringArray - 1; incIndex >= 0; --incIndex) {
				if (counterArray[incIndex] + 1 < sizeArray) {
					++counterArray[incIndex];
					break;
				}
				counterArray[incIndex] = 0;
			}
			System.gc();
		}
		return combinationList;
	}

	public static void main(String[] args) {
		String[][] twoDimStringArray = { { "11", "12", "13", "14" }, { "21", "22", "23", "24" },
				{ "31", "32", "33", "34" }, { "41", "42", "43", "44" }, { "51", "52", "53", "54" } };
		
		long start = System.currentTimeMillis();
		combinations(twoDimStringArray);
		long end = System.currentTimeMillis();
		long times = end - start;
		System.out.println(times);
		System.gc();
		start = System.currentTimeMillis();
		combinations1(twoDimStringArray);
		end = System.currentTimeMillis();
		times = end - start;
		System.out.println(times);
		System.gc();
	}
}
