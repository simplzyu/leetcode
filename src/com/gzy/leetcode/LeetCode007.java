package com.gzy.leetcode;

public class LeetCode007 {
	public static void main(String[] args) {
		int x = 1056389759;
		// String s = "9646324351";
		// x = (int)Long.parseLong(s);
		// System.out.println(x);
		System.out.println(new LeetCode007().reverse(x));
	}

	public int reverse(int x) {
		boolean isPositive = true;
		if (x < 0) {
			isPositive = false;
			x = -x;
		}
		String s = Integer.toString(x);
		char[] ch = s.toCharArray();
		int j = ch.length - 1;
		char temp;
		for (int i = 0; i < ch.length / 2; i++) {
			temp = ch[i];
			ch[i] = ch[j];
			ch[j--] = temp;
		}
		s = String.valueOf(ch);
//		System.out.println(s);
		try {
			j = Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
		if (!isPositive)
			j = -j;
		return j;
	}

	public int reverse1(int x) {
		int ret = 0;
		int digit = 0;
		boolean neg_flag = false;

		if (x < 0) {
			neg_flag = true;
			x = -1 * x; // covert to abs(x), and record the symbol of negative
						// or positive.
		}

		while (x != 0) {
			digit = x % 10; // get the last digit of x

			if (ret != 0) { // must follow this pattern to check
				if ((Integer.MAX_VALUE - digit) / ret < 10)
					return 0;

				if (neg_flag == true) {
					if (-10 < (Integer.MIN_VALUE + digit) / ret)
						// - (ret * 10 + digit) < Integer.MIN_VALUE
						// if we convert the number to abs, we need to compare
						// it in negative form with Integer.MIN_VALUE
						return 0;
				}
			}

			ret = ret * 10 + digit;
			x = x / 10; // chop off the last digit of x
		}

		if (neg_flag == true && ret > 0)
			ret = -1 * ret;

		return ret;
	}
}
