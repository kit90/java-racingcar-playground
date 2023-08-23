## 1️⃣ 문자열 덧셈 계산기 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 
  - 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6) 
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 
  - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    (예: “//;\n1;2;3”을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환)
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

---

## 2️⃣ 자동차 경주 게임 기능 요구사항
1. 경주 시작전
- 각 자동차에 이름을 입력할 수 있다. 
  - 자동차 이름은 5자를 초과할 수 없다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분한다. 
- 시도할 라운드 회수를 묻는다.
2. 경주중
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
  - 라운드 결과(전진 상태)를 출력할 때, 자동차 이름을 같이 출력한다.
3. 경주 끝
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 최종 우승은 가장 많이 전진한 자동차이다.
  - 우승자는 한명 이상일 수 있다.

