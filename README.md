# 자바로 게임 코딩

1. ## 가위, 바위, 보

- 가위는 숫자 0, 바위는 숫자 1, 보는 숫자 2와 같다.
- 컴퓨터는 Math.random()을 이용해 0 부터 2까지의 숫자를 랜덤으로 출력한다.
- 유저는 가위, 바위, 보 중 하나를 키보드로 입력해야 한다.
  - 가위, 바위, 보가 아닌 이외의 값을 입력한 경우 안내 문구가 출력된다.
  - 값을 잘못 입력한 경우 다음 판으로 넘어가지 않는다. (카운팅 X)
- 게임은 총 3판으로 진행되고 모든 게임이 끝나면 오늘 날짜와 시간을 출력한다.
<img src="https://user-images.githubusercontent.com/47530310/57128298-ec330280-6dcd-11e9-8f62-eeb40063a5f4.PNG" alt="가위바위보실행이미지" width="50%">

2. ## 구구단

- question() : 랜덤으로 구구단 문제를 출제한다.
- answerCheck() : 유저가 입력한 답과 구구단 계산 결과 값을 비교한다.
  - 아무 값도 입력하지 않으면 '값을 입력해주세요!!' 문구가 출력된다.
  - 정답을 제출할 때까지 계속해서 반복된다.
<img src="https://user-images.githubusercontent.com/47530310/57128719-484a5680-6dcf-11e9-88a4-2cf2804e18a5.PNG" alt="구구단실행이미지" width="50%">

3. ## 숫자 야구 게임
- 컴퓨터가 랜덤으로 숫자 3개를 출력하면, 유저가 이 숫자를 모두 맞추는 게임이다.
- 숫자뿐 아니라 위치까지 정확히 맞춰야 한다.
  - 숫자만 맞춘 경우 ball++;
  - 숫자와 위치를 맞춘 경우 strike++;
- 게임이 진행될 때마다 게임 횟수가 카운팅된다. count++;
- 게임 횟수가 5번 초과할 때까지 유저가 strike를 3개 얻지 못하면 COM WIN!
- 게임 횟수 5번 이내에 유저가 Strike를 3개 획득하면 USER WINE!
- comPlay() : 1부터 9까지의 중복되지 않은 숫자 3개를 랜덤으로 출력한다.
  - num1, num2, num3
- userPlay() : 유저가 1부터 9까지의 중복되지 않은 숫자 3개를 콤마로 구분하여 입력해야 한다.
  - 정규표현식으로 유효성 체크 : String regExp = "^[1-9]+,[1-9]+,[1-9]$";
<img src="https://user-images.githubusercontent.com/47530310/57343797-b4d2a600-717f-11e9-8770-b16074d44e39.png" alt="숫자야구게임실행이미지" width="50%">

3. ## 행멘 게임
- 영어 단어 맞추기 게임으로 글자 수만큼 ‘□’ 도형이 출력된다.
- 유저에게는 총 4번의 기회가 주어진다.
  - 알파벳 이외의 값을 입력한 경우 기회는 차감되지 않는다.
- prepare() : 영어단어가 입력된 파일을 읽어 들여 게임을 준비한다.
- test() : 읽어 들인 파일에서 랜덤으로 영어 단어 하나를 선택해 문제를 낸다.
  - wordsList.get(key); 
- answer() : 유저가 입력한 알파벳이 영어 단어에 포함되어 있으면 해당 자리를 알려준다.
  - 대/소문자 구분 없이 입력받을 수 있다. 
  - buffer.replace(index, index + 1, alphabet); 
<img src="https://user-images.githubusercontent.com/47530310/57595633-3449e600-7581-11e9-9909-bddd48b2a0ce.png" alt="행멘게임실행이미지" width="50%">

4. ## Swing을 이용한 계산기
- 사칙연산이 가능한 계산기이며, 값은 소수점 두자리까지 표기된다.
  - 소수점 첫째 자리가 0인 경우 소수점은 표기되지 않는다. [ DecimalFormat 이용 ]
- createCal() : 계산기 레이아웃 구성
- class InputAction : 계산기 버튼 클릭 시 연산 시작
- isNumber() : 버튼값이 숫자인지 아닌지 확인
- actionPerformed() : 숫자키 다음 연산키를 눌러야지만 Arraylist에 숫자가 저장된다.
  - 맨 처음 연산키가 입력되면 아무것도 저장되지 않는다.
- addParentheses() : 계산식에 곱셈 또는 나눗셈이 포함된 경우 createParentheses() 실행
- createParentheses() : 괄호 자동 삽입
- chageNotation() : 중위 표기법을 후위 표기법으로 변경
- calculate() : 연산자에 따라 연산한 후 중간 계산 값이 있는 경우 temp에 저장
<img src="https://user-images.githubusercontent.com/47530310/58395263-45ffb300-8082-11e9-9f05-b07222ffe7e0.PNG" alt="계산기실행이미지" width="50%">

