package rockPaperScissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RockPaperScissors {
	public static void main(String[] args) {
		// 가위 = 0 , 바위 = 1, 보 =2

		int computer = (int) (Math.random() * 4);

		String korean = null;
		if (computer == 0) {
			korean = "가위";
		} else if (computer == 1) {
			korean = "바위";
		} else if (computer == 2) {
			korean = "보";
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 3; i++) {
			System.out.println(i + "번째 게임" + " >>가위, 바위, 보 중 하나를 입력하세요.");

			String user;
			try {
				user = br.readLine();
				if (!"가위".equals(user) && !"바위".equals(user) && !"보".equals(user)) {
					System.out.println(">>잘못 입력하셨습니다. - 가위, 바위, 보 중 하나를 입력하세요.<<");
					--i;
					continue;
				}
				
				int number =0;
				if ("가위".equals(user)) {
					number = 0;
				} else if ("바위".equals(user)) {
					number = 1;
				} else if("보".equals(user)) {
					number = 2;
				}
				
				if (number > computer) {
					System.out.println("[유저 승] - " + "유저: " + user + ", 컴퓨터: " + korean);
				} else if (number == computer) {
					System.out.println("[무승부] - " + "유저: " + user + ", 컴퓨터: " + korean);
				} else if  (number < computer) {
					System.out.println("[유저 패] - " + "유저: " + user + ", 컴퓨터: " + korean);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Date today = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println("게임 끝! -------" + dateFormat.format(today));
	}
}
