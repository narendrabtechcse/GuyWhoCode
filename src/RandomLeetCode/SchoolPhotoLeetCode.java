package RandomLeetCode;

import java.util.*;

class SchoolPhotoLeetCode {

	public static void main(String[] args) {

		heightChecker(new int[] { 2, 5, 8, 3, 1 });
	}

	public static int heightChecker(int[] heights) {
		int[] origHeights = new int[heights.length];
		origHeights = heights.clone();
		Arrays.sort(heights);
		int notInPlace = 0;

		for (int i = 0; i < heights.length; i++) {
			if (origHeights[i] != heights[i])
				notInPlace++;
		}
		return notInPlace;
	}
}