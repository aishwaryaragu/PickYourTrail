package com.cat.dsp.common.test;

public class MudWall {
	private static int maxHeight(int[] stickPositions, int[] stickHeights) {
		int max_height = 0;
		for(int i = 0; i < stickPositions.length - 1; i++) {
			int start = stickPositions[i];
			int end = stickPositions[i + 1];
			int height_curr = stickHeights[i];
			int max_h = 0;
			for(int curr = start + 1; curr < end; curr++) {
				height_curr = Math.min(height_curr + 1, (end - curr) + stickHeights[i+1]);
				max_h = Math.max(height_curr, max_h);
			}
			max_height = Math.max(max_height, max_h);
		}
		return max_height;
	}
	public static void main(String[] args) {
//		int[] stickPositions = {1, 10};
//		int[] stickHeights = {1, 5};
//		int[] stickPositions = {1, 3, 7};
//		int[] stickHeights = {4, 3, 3};
		int[] stickPositions = {1, 2, 4, 7};
		int[] stickHeights = {4, 5, 7, 11};
		System.out.println(maxHeight(stickPositions, stickHeights));
	}
}

/**
1,3,7] [4,3,3]
for(int i=0; i < len(st) - 1;i++) {
	start = st[i]
	end = st[i + 1]
	height_curr = height[i]
	for(int curr=start+1;curr < end; curr++) {
		height_curr = min(height_curr + 1, (end - curr) + height[i + 1]) //min(4 + 1=5, (3-2)+3=4)=4
		//min(3+1=4, (7-4)+3=6)=4
		//min(4+1=5, (7-5)+3=5)=5
		//min(5+1=6, (7-6)+3=4)=4
	}
}
1MMMMMMMM9
12MMMMMM89
123MMMM789
1234MM6789
1234566789

12345678910
1 10 1 5
0 1 2 3 4 5 6 7 8 9
1                 5
i = 0 -> n - 1
height(curr) = min(height(curr) + 1, (pos(last) - pos(curr)) + height(last))
min(1+1 = 2, (9 - 1) + 5 = 13) = 2
min(2+1 = 3, (9 - 2) + 5 = 12) = 3
min(3+1 = 4, (9 - 3) + 5 = 11) = 4
min(4+1 = 5, (9 - 4) + 5 = 10) = 5
min(5+1 = 6, (9 - 5) + 5 = 9) = 6
min(6+1 = 7, (9 - 6) + 5 = 8) = 7
min(7+1 = 8, (9 - 7) + 5 = 7) = 7
min(7+1 = 8, (9 - 8) + 5 = 6) = 6
**/

