-- board 계정 생성
CREATE USER board IDENTIFIED BY java1234;

-- 권한 부여
GRANT CONNECT, RESOURCE TO board;

-- 테이블스페이스 용량 제한 해제
ALTER USER board QUOTA UNLIMITED ON USERS;


