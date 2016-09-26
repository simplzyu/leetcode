package com.gzy.leetcode;

public class LeetCode064 {
	public static void main(String[] args) {
//		int[][] grid = {{3,1,8},{7,6,2},{2,3,9}};
		int[][] grid = 
				{{5,0,1,1,2,1,0,1,3,6,3,0,7,3,3,3,1},
				{1,4,1,8,5,5,5,6,8,7,0,4,3,9,9,6,0},
				{2,8,3,3,1,6,1,4,9,0,9,2,3,3,3,8,4},
				{3,5,1,9,3,0,8,3,4,3,4,6,9,6,8,9,9},
				{3,0,7,4,6,6,4,6,8,8,9,3,8,3,9,3,4},
				{8,8,6,8,3,3,1,7,9,3,3,9,2,4,3,5,1},
				{7,1,0,4,7,8,4,6,4,2,1,3,7,8,3,5,4},
				{3,0,9,6,7,8,9,2,0,4,6,3,9,7,2,0,7},
				{8,0,8,2,6,4,4,0,9,3,8,4,0,4,7,0,4},
				{3,7,4,5,9,4,9,7,9,8,7,4,0,4,2,0,4},
				{5,9,0,1,9,1,5,9,5,5,3,4,6,9,8,5,6},
				{5,7,2,4,4,4,2,1,8,4,8,0,5,4,7,4,7},
				{9,5,8,6,4,4,3,9,8,1,1,8,7,7,3,6,9},
				{7,2,3,1,6,3,6,6,6,3,2,3,9,9,4,4,8}};
//		int[][] grid = { { 3, 1, 8 }, { 7, 6, 2 }, { 2, 3, 9 } };
		System.out.println(new LeetCode064().minPathSum(grid));
//		new leetCode64().print(grid);
	}

	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
//		System.out.println(row);
//		System.out.println(col);
//		return minPath(grid, row-1, col-1);
		return minPathArray(grid, row, col);
	}
	//µÝ¹é·¨
	public int minPath(int[][] grid, int row, int col) {
		int sum1 = -1, sum2 = -1;
//		int temp1,temp2;
		if (row == 0 && col == 0) {
			return grid[0][0];
		} else {
			if (row > 0) {
//				printf("row %d" ,(row - 1));
//				printf("%d\n",col);
//				printf("now:%d + temp1:%d\n",grid[row][col],temp1);
				sum1 = grid[row][col] + minPath(grid, row - 1, col);
			}
			if (col > 0) {
//				printf("col %d",row);
//				printf("%d\n",(col-1));
//				printf("now:%d + temp2:%d\n",grid[row][col],temp2);
				sum2 = grid[row][col] + minPath(grid, row, col - 1);;
			}
//			printf("sum1 = %d sum2= %d\n",sum1,sum2);
			if(sum1 < 0) return sum2;
			else if(sum2 < 0) return sum1;
			else
				return  sum1 < sum2 ? sum1 : sum2;
		}
	}
	//¶¯Ì¬·¨
	public int minPathArray(int[][] grid, int row, int col){
		int[][] minPath = new int[row][col];
		minPath[0][0] = grid[0][0];
		for(int i = 1; i < col; i++){
			minPath[0][i] = minPath[0][i-1] + grid[0][i];
		}
		for(int i = 1; i < row; i++){
			minPath[i][0] = minPath[i-1][0] + grid[i][0]; 
		}
		
		for(int i = 1; i < row; i++){
//			System.out.print(i);
			for(int j = 1; j < col; j++){
				minPath[i][j] = Math.min(minPath[i-1][j], minPath[i][j-1]) + grid[i][j];
//				System.out.print(" " +minPath[i][j]);
			}
//			System.out.println("");
		}
		return minPath[row-1][col-1];
	}
	
	public void print(int[][] grid){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++)
				System.out.print(grid[i][j]);
			System.out.println("");
		}
	}
}
