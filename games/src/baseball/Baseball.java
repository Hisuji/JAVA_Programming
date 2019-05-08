package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Baseball {
	private int num1;
	private int num2;
	private int num3;
	private int[] comNums = { num1, num2, num3 };

	public int[] comPlay() {
		Random r = new Random();
		comNums = new int[3];

		for (int i = 0; i < comNums.length; i++) {
			comNums[i] = r.nextInt(9) + 1;
			for (int j = 0; j < i; j++) {
				if (comNums[j] == comNums[i]) {
					i--;
					break;
				}
			}
			num1 = comNums[0];
			num2 = comNums[1];
			num3 = comNums[2];
		}
		
		System.out.println(num1 + " / " + num2 + " / " + num3);
		
		return comNums;
	}

	public void userPlay() {
		int count = 0;
		int strike = 0;
		int ball = 0;
		
		while (count < 5 && strike < 3) {
			strike = ball = 0;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("1 ~ 9까지의 숫자 중 3개를 작성해주세요. 숫자는 콤마(,)로 구분");
			
			int[] intArr = new int[3];
			
			try {
				String str = br.readLine();
				String regExp = "^[1-9]+,[1-9]+,[1-9]$";
				if (str.matches(regExp) == true) {
					String[] strArr = str.split(",");
					for (int i = 0; i < strArr.length; i++) {
						 intArr[i] = new Integer(strArr[i]).intValue();
					}
					
					if (intArr[0] != intArr[1] 
							&& intArr[1] != intArr[2] 
									&& intArr[2] != intArr[0]) {
						count++;
						
						for (int i = 0; i < intArr.length; i++) {
							if (comNums[i] == intArr[i]) {
								strike++;
							}
						}
						
						if (num1 == intArr[1] || num1 == intArr[2]) {
							ball++;
						}
						if (num2 == intArr[0] || num2 == intArr[2]) {
							ball++;
						}
						if (num3 == intArr[0] || num3 == intArr[1]) {
							ball++;
						}

						System.out.println("> 스트라이크: " + strike + " -- > 볼: " + ball);
						System.out.println("> 게임 횟수: " + count);
					} else {
						System.out.println("중복되지 않은 숫자를 입력해주세요!");
					}
				} else {
					System.out.println("다시 입력해주세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (strike == 3 && count == 5) {
			System.out.println("USER WIN!!");
		} else if (count == 5) {
			System.out.println("COM WIN!!");
		} 
	}

	public static void main(String[] args) {
		Baseball baseball = new Baseball();
		baseball.comPlay();
		baseball.userPlay();
	}
}
