package test;


public class Main {

	public static void main(String[] args) {
		System.out.println(digitalReverse(12300));
		System.out.println(digitalReverse(-12300));
	}

	public static int digitalReverse(int x) {
		int result = 0;
		// 处理负数的情况
		int sign = 1;
		if (x < 0) {
			sign = -1;
			x = -x;
		}
		// 进行逻辑处理
		while (x > 0) {
			int d = x % 10;
			result = result * 10 + d;
			x = x / 10;
		}

		return sign * result;
	}
}
