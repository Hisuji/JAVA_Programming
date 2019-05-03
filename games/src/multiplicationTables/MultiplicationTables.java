package multiplicationTables;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class MultiplicationTables {
	private int result;

	public int question() {
		Random r = new Random();

		// 2 ~ 9까지의 정수 랜덤값 출력
		int x = r.nextInt(8) + 2;
		int y = r.nextInt(8) + 2;
		result = x * y;

		System.out.println("Q. " + x + " * " + y + " = ");
		System.out.println("------------------------------");

		return result;
	}

	public void answer() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String user = null;
		int inputNum = 0;
		boolean solution = true;
		try {
			while (solution) {
				user = br.readLine();
				if (!"".equals(user)) {
					inputNum = new Integer(user).intValue();
					if (result == inputNum) {
						System.out.println(">> 정답입니다!!");
						solution = false;
					} else if (result != inputNum) {
						System.out.println(" >> 오답입니다!! 다시 계산해보세요.");
					}
				} else {
					System.out.println(">>값을 입력해주세요!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MultiplicationTables tables = new MultiplicationTables();
		tables.question();
		tables.answer();
	}
}
