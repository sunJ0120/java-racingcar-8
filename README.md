# java-racingcar-precourse
## 우아한 테크코스 프리코스 8기 2주차 미션: 자동차 경주

## 0. 객체 협력 흐름
!["협력_흐름.jpg"](협력_흐름.jpg)

## 1. 주요 기능 목록
- [x] 사용자 입력을 받아 차를 생성
- [x] 차들은 , 로 구분. 차를 받아서 파싱
- [x] 제공 메서드를 이용해서 1~9까지의 랜덤한 번호 생성
- [x] 랜덤 번호가 4 이상이면 해당 차를 움직임 (마치 주사위 굴리듯)
- [x] 턴이 끝나면 우승자를 출력, 우승자는 여러명도 가능
- [x] 잘못된 입력 시 `IllegalArgumentException` 발생

## 2. 구현 시 주요 고려사항

### 객체지향 설계
- **책임 주도 설계(RDD)**: 각 클래스가 명확한 책임을 가지며, 행동 위주로 도메인을 분리
- **Getter 사용 최소화**: 컬렉션 객체의 경우는 getter 사용 금지, 서비스 로직이 아닌 뷰에만 getter를 노출 하도록 최소화
- **일급 컬렉션**: Cars라는 이름의, List<Car>를 사용하는 일급 콜렉션 객체를 사용해서 캡슐화
- **총괄 매니저** : 전체 게임을 총괄하는 `RacingGameManager`, 운전을 총괄하는 `RacingController`를 두어 협력 관계를 더욱 응집도 있게 구성

### 제공 util test method 사용
- `assertTimeoutPreemptively`를 사용하는 simpleTest를 활용하여, 테스트 효율성도 같이 체크
- mock를 활용하는 `assertRandomNumberInRangeTest`를 활용하여, `randomGenerator`의 값을 고정하여 로직을 독립적으로 테스트

## 3. 예외 처리
> 모든 예외는 `IllegalArgumentException`을 사용하여 요구사항 준수
> 
> - 예외는 `validateEachCarName`를 활용한 단일 네임 체크와 
> - `validateListNotEmpty` & `validateDuplicateNames`를 활용한 전체 이름 체크로 나눠진다.

### 차 이름이 공백인 경우
- 전체 공백이 들어왔을 경우 **"차 이름을 입력해주세요."** 메세지
- 일부가 공백일 경우 **"차 이름은 공백일 수 없습니다."** 메세지

### 차 이름이 너무 길 경우
- 차 이름이 5자 초과이면 **"차 이름은 5자보다 길 수 없습니다."** 메세지

### 이름이 중복일 경우
- 차 이름이 중복될 경우 **"이름이 중복됩니다."** 메세지