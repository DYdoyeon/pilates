
DROP TABLE IF EXISTS POST;

CREATE TABLE POST (
    POSTNO INT PRIMARY KEY AUTO_INCREMENT,
    TITLE VARCHAR,
    CATEGORY VARCHAR,
    CONTENT VARCHAR,
    WRITER VARCHAR
);


INSERT INTO POST ( TITLE, CONTENT, WRITER) VALUES ('1 DB 제목 입니다.', '1 DB 콘텐츠 입니다.', '1 DB 작성자 입니다.');
INSERT INTO POST ( TITLE, CONTENT, WRITER) VALUES ('2 DB 제목 입니다.', '2 DB 콘텐츠 입니다.', '2 DB 작성자 입니다.');
INSERT INTO POST ( TITLE, CONTENT, WRITER) VALUES ('3 DB 제목 입니다.', '3 DB 콘텐츠 입니다.', '3 DB 작성자 입니다.');
