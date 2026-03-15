<%--
  Created by IntelliJ IDEA.
  User: parkjimyeong
  Date: 2026. 3. 15.
  Time: 오후 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>회원가입</title>
  <link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
  <h1>회원가입</h1>
  <form action="/register" method="post">
    <table class="vertical">
      <tr>
        <th>이름</th>
        <td><input type="text" name="name" min="2" max="5" placeholder="이름"></td>
      </tr>
      <tr>
        <th>아이디</th>
        <td>
          <input type="text" name="id">
          <input type="button" id="checkIdBtn" value="아이디 중복확인">
          <span id="idMsg"></span>
        </td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <th>비밀번호 확인</th>
        <td><input type="password" name="passwordCheck"></td>
      </tr>
      <tr>
        <th>주민번호</th>
        <td><input type="text" name="jumin" min="14" max="14"></td>
      </tr>
      <tr>
        <th>닉네임</th>
        <td>
          <input type="text" name="nickname">
          <input type="button" id="checkNicknameBtn" value="닉네임 중복확인">
          <span id="nicknameMsg"></span>
        </td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input type="email" name="email"></td>
      </tr>
      <tr>
        <th>전화번호</th>
        <td><input type="tel" name="phone"></td>
      </tr>
      <tr>
        <th>주소</th>
        <td><input type="text" name="address"></td>
      </tr>
    </table>
    <hr>
    <div>
      <input type="submit" value="가입하기">
    </div>
  </form>

  <script src="https://code.jquery.com/jquery-4.0.0.js"></script>
  <script src="https://bit.ly/4cMuheh"></script>
  <script>

    // 아이디 중복확인
    $('#checkIdBtn').click(() => {
      // 1. 입력값 가져오기
      let id = $('input[name="id"]').val();

      // 2. 빈값 체크
      if (id.trim() === "") {
        $('#idMsg').text("아이디를 입력해주세요.");
        return;
      }

      // 3. AJAX 요청
      fetch('/checkid?id=' + id)
              .then(response => response.json())
              .then(data => {
                if (data.result === 1) {
                  $('#idMsg').css('color', 'green').text('✅ 사용 가능한 아이디입니다.');
                } else {
                  $('#idMsg').css('color', 'red').text('❌ 이미 사용중인 아이디입니다.');
                }
              });
    });

    // 닉네임 중복확인
    $('#checkNicknameBtn').click(() => {
      // 1. 입력값 가져오기
      let nickname = $('input[name="nickname"]').val();

      // 2. 빈값 체크
      if (nickname.trim() === "") {
        $('#nicknameMsg').text("닉네임을 입력해주세요.");
        return;
      }

      // 3. AJAX 요청
      fetch('/checknickname?nickname=' + nickname)
              .then(response => response.json())
              .then(data => {
                if (data.result === 1) {
                  $('#nicknameMsg').css('color', 'green').text('✅ 사용 가능한 닉네임입니다.');
                } else {
                  $('#nicknameMsg').css('color', 'red').text('❌ 이미 사용중인 닉네임입니다.');
                }
              });
    });

  </script>

</body>
</html>
