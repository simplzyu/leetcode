package com.gzy.leetcode;

/**
 *字符串Z字型输出 eg:"PAYPALISHIRING" 
 *P A H N 
 *APLSIIG
 *Y I R 
 *out:"PAHNAPLSIIGYIR"
 **/
public class LeetCode006 {
	public static void main(String[] args) {
		LeetCode006 lc6 = new LeetCode006();
		String s = "PAHNAPLSIIGYIR";
		System.out.println(lc6.convert(s, 2));
	}

	//如果row=2则Z型不同,如
	//P H A L I G I
	// A N P S I Y R
	public String convert(String s, int numRows) {
		int p=0,temp = 2 * (s.length() / numRows) + 1;
		char[] schar = s.toCharArray();
		if(numRows == 2){
			char[] numChar = new char[s.length()];
			for(int i = 0; i < s.length(); i++){
				if(i%2==0) numChar[p++] = schar[i];
			}
			for(int i = 0; i < s.length(); i++){
				if(i%2 == 1) numChar[p++] = schar[i];
			}
			return String.valueOf(numChar);
		}
		int i = 0, j = 0;
		char[][] zigArray = new char[numRows][temp];
		for (int t = 0; t < s.length(); t++) {
			if (j % 2 == 0 && i < numRows) {
				zigArray[i++][j] = schar[t];
				if (i == numRows) {
					j++;
					i = numRows - 2;
				}
			} else {
				if (i > 0) {
					zigArray[i--][j] = schar[t];
					if (i == 0) {
						j++;
						i = 0;
					}
				}
			}
		}
		int t = 0;
		for (i = 0; i < zigArray.length; i++)
			for (j = 0; j < zigArray[0].length; j++) {
				if (zigArray[i][j] != 0)
					schar[t++] = zigArray[i][j];
				else
					continue;
			}
//		LeetCodeUtil.printCharArray(schar);
		String res = String.valueOf(schar);
		return res;
	}
}
