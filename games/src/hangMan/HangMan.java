package hangMan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HangMan {
	List<String> wordsList;
	String question;
	StringBuffer buffer;

	public List<String> prepare() {
		String path = "C:" + File.separator + "test" + File.separator + "english_words.txt";
		BufferedReader br = null;
		String words = null;
		wordsList = new ArrayList<String>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while ((words = br.readLine()) != null) {
				wordsList.add(words);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return wordsList;
	}

	public void test() {
		int listSize = wordsList.size();

		Random random = new Random();
		int key = random.nextInt(listSize);
		question = wordsList.get(key);

		// System.out.println(">>>문제 : " + question);

		int underscore = question.length();

		buffer = new StringBuffer();
		for (int i = 0; i < underscore; i++) {
			buffer.append("□");
		}
		System.out.println("> 게임 시작 ! : " + buffer);
	}

	public void answer() {
		Scanner scanner = new Scanner(System.in);
		String pattern;
		boolean regex;
		int repeat = 0;
		while (repeat < 4) {
			if (repeat <= 2) {
				pattern = "^[a-zA-Z]{1}$";
				System.out.println("[ 글자 하나를 입력해주세요. ]");

				String alphabet = scanner.nextLine();

				// 대문자 > 소문자 변환
				alphabet = alphabet.toLowerCase();
				regex = Pattern.matches(pattern, alphabet);
				if (!regex) {
					System.out.println("다시 입력해주세요.");
				} else {
					boolean check = question.contains(alphabet);
					if (check) {
						int index = question.indexOf(alphabet);
						while (index != -1) {
							buffer.replace(index, index + 1, alphabet);

							// indexOf(String str, int fromIndex) : fromIndex부터 검색
							index = question.indexOf(alphabet, index + 1);
						}
						System.out.println(buffer);
					}
					repeat++;
				}

				int symbol = buffer.indexOf("□");
				if (symbol == -1) {
					System.out.println("--- 정답입니다! ---");
					break;
				}
				
			}

			if (repeat == 3) {
				pattern = "^[a-zA-Z]*$";
				System.out.println("> [ 단어 전체를 입력해주세요. ] <");

				String word = scanner.nextLine();
				regex = Pattern.matches(pattern, word);
				if (regex) {
					boolean result = word.equals(question);
					if (result) {
						System.out.println("--- 정답입니다! ---");
					} else {
						System.out.println("--- 오답입니다! --- 정답 : " + question);
					}
					break;
				}
			}

		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		HangMan hangMan = new HangMan();
		hangMan.prepare();
		hangMan.test();
		hangMan.answer();
	}

}
