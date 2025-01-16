<h1 align="center">
  App프로젝트 (운동 루틴 관리 App)
</h1>

<div align="center">
  <img src="https://github.com/user-attachments/assets/185ce177-89dd-4a5f-8826-d692d59e012f" width="800">
</div>

## 개요 : 일주일 단위의 운동 계획 설계 및 기록 확인
<br>

<p align="center">
  누구나 쉽게 사용할 수 있는 운동 루틴 관리 App 입니다<br>
  월 ~ 일요일까지 원하는 날짜, 원하는 운동을 등록 가능합니다<br>
  
</p>

<br>

---

## 프로젝트 특징
<br>
- 사용자는 원하는 부위를 선택, 원하는 운동을 골라 쉽게 운동 계획을 등록 가능  :<br><br>
  부위별 카테고리 필터를 제공하여 사용자가 원하는 운동을 쉽게 찾을 수 있게 합니다<br><br>
- 수행 이력 확인 가능 :<br><br>
  운동을 수행하였다면 체크하여 관리할 수 있고, 달력으로 수행 이력을 확인 가능합니다 (체크 내역은 매주 월요일에 초기화되며, 달력에 기록됩니다.)<br><br>

## 시연 영상


<br><br>

[![Watch the video](https://img.youtube.com/vi/difnYipSIE0/0.jpg)](https://www.youtube.com/watch?v=difnYipSIE0)



<br><br>



## 팀원
- 박무현(팀장) [![박무현](https://img.shields.io/badge/GitHub-박무현-orange)](https://github.com/MooHyunPark)
- 송승현 [![송승현](https://img.shields.io/badge/GitHub-송승현-blue)](https://github.com/seunghyeon22)
- 조세은 [![조세은](https://img.shields.io/badge/GitHub-조세은-red)](https://github.com/SeeunJoe)
- 김인범 [![김인범](https://img.shields.io/badge/GitHub-김인범-green)](https://github.com/kiminbeam)
- 이나겸 [![이나겸](https://img.shields.io/badge/GitHub-이나겸-yellow)](https://github.com/NakyeomLee)
<br>





## 통합 구현 기능



### 유저 관련 기능
- 로그인, 회원가입
### 운동 관련 기능
- 요일별 운동 등록, 등록한 운동 내용 수정
### 관리 기능
- 사용자 정보(키, 신장 등) 수정, 운동 수행 후 체크 기능, 과거 운동 수행 내역 확인 가능

<br>

<br>

## 내가 구현한 내용
- App프로젝트 설정과 세팅, 공유
- Server프로젝트 설정과 세팅, 공유
- Server프로젝트 유저 관련 기능 기본 세팅
- 컨벤션 작성 및 공유
- 체크 이력에 따른 일주일 치 결과를 연산하여 recode 테이블에 옮겨 담는 내용 및 알고리즘. 페이지 구현
- 팀원들이 작성한 내용 디버깅 및 수정
  
  
<br>
<br>

## 보완할 점

<br>
시간 부족으로 skip 한 내용 :
<br><br>

- 등록한 운동과 이미지가 서로 매치되지 않는 경우가 발생. (프로젝트에 업로드 할 때 이미지 파일 명이 잘못된 것으로 확인, 추후 각자 이미지 명을 변경하기로 합의)
- 데이터가 등록 또는 변경되었다면 클라이언트에서 state를 직접 변경해주어 추가적인 통신을 하지 않을 수 있었으나, 그렇게 하지 않고 화면 새로고침이 다수 있었던 점

<br>
<br>
컨벤션이 제대로 지켜지지 않은 내용 :
<br><br>

- exercise와 fitness 둘 중 하나만 사용하여야 했으나, 둘 다 프로젝트 폴더 및 파일 명으로 들어간 내용.

<br><br><br>

## 트러블슈팅
<br><br>

### 기존의 프로젝트와는 다르게 문법적인 문제가 다수 발생하였고 아래는 그 중 일부입니다.
<br>

1. responseList를 FitnessListModel 타입으로 변환하려고 할 때 발생
2. List<dynamic> 타입을 다운캐스팅하지 않고 바로 형을 변환하려고 하여 예외가 발생하였음
3. 해당 타입을 전달 받은 후 직접 옮겨담는 로직을 추가하거나, 다운 캐스팅을 통해 예외 발생 수정
4. 같은 예외가 발생한 팀원 다수 확인.

<br><br>

<div align="center">
  <img src="https://github.com/user-attachments/assets/1996d5ad-71c3-4c70-9b9b-65d952182aba" width="800">

</div>

<br><br><br>
위의 문제가 발생한 이유 : <br>
팀원들이 전체적으로 dart 문법에 아직 익숙하지 않았으며, 헷갈릴 수 있는 부분을 제가 따로 캐치해내지 못했습니다.

<br>

위의 문제에 대처한 방법 : 모든 팀원들을 각각 불러서 문제의 원인과 해결 방법을 하나씩 학습시켰습니다. <br>
또한 어떤 부분에서 코드를 작성하기 어려워하는지 추가로 검토한 뒤, 개인별로 부족한 문법 내용을 추가로 알려주며 프로젝트를 진행하였습니다.
<br><br>


## 느낀점
<br>

1. 새로운 문법을 배울 때는 추가 내용을 메모한 뒤, 팀원들에게 따로 공유해주는 것이 좋다 : <br>
   저를 포함하여 다른 팀원들도 새로운 문법을 정리하였으나, 이에 대해서 서로 공유하지는 않았습니다.
   이를 제가 앞장서서 자료를 모은 뒤, 중복 내용을 제거한 통합 파일을 만들어 공유하였으면 프로젝트 진행 속도가 더 빨라지지 않았을까 생각합니다.
<br><br>

2. 소통이 중요하다 : <br>
   위의 내용에서 추가적으로 파생되는 내용입니다.<br>
   프로젝트 진행은 서로 잊어버릴 수 있는 부분을 소통과 공유가 있어야만 효율적으로 이루어질 수 있다는 생각이 확고해졌습니다. <br><br>

3. 시간적 여유 부족으로 간단한 앱 프로젝트를 진행하였으나, 추후에 개인적으로 직접 원하는 어플을 만들어 보고 싶습니다. <br><br>

   
(번외). Flutter는 정말 쓰기 편하고, 신규 사용자가 사용하기에 직관적이다. <br>
   원래 app을 어느정도 개발하려면 오랜 시간이 걸린다고 들었습니다.
   하지만 학습을 1 ~ 2주 정도밖에 진행하지 않은 상태로도 플러터 프로젝트를 진행할 수 있었고, 이는 누구나 쉽게 쓸 수 있다는 것을 어느정도 증명하는 것 같습니다.
   다만 아직까지 왜 사람들이 flutter를 선호하지 않는지에 대해서 의문점입니다.
<br><br>




## 기타

---

## 협업 전략
<br>

- 기존에 사용하였던 협업 전략에 추가로 내용을 보태여 팀원들에게 내용을 공유하였습니다.

<div align="center">
  <img src="https://github.com/user-attachments/assets/58c328eb-a1d3-4a7f-b588-5e29c6c4d3e7" width="800">
</div>

<br><br><br>

## DB 설계
<br>

- 팀 회의를 통해 엑셀을 이용하여 테이블을 구상하고 관리하였습니다.

<div align="center">
  <img src="https://github.com/user-attachments/assets/65a3a439-ef08-4b5e-84c0-fb148f0a4c30" width="800">
</div>
<br><br>

## ERD
<div align="center">
  <img src="https://github.com/user-attachments/assets/170a7b1f-56b3-49a3-b405-587d70ff0b9e" width="800">
</div>
<br>
<br><br><br><br>


## 프로젝트 기간
<br>

- 2024년 12월 30일 ~ 2025년 1월 13일 (약 2주)
  
<br>

## 기술 스택

### Backend
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

### Frontend
![Dart](https://img.shields.io/badge/dart-%230175C2.svg?style=for-the-badge&logo=dart&logoColor=white)
![Riverpod](https://img.shields.io/badge/riverpod-%23000?style=for-the-badge&logo=riverpod&logoColor=white)
![MVVM](https://img.shields.io/badge/mvvm-%2300C4B3.svg?style=for-the-badge&logo=mvvm&logoColor=white)

### IDE
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

### 협업도구
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)

### 데이터베이스
![H2DB](https://img.shields.io/badge/H2DB-31A8FF?style=for-the-badge&logo=H2DB&logoColor=white)

<br><br>









