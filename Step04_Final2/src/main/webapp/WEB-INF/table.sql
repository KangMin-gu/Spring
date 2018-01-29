
-- 상품 테이블
Create table shop(
	num number primary key, --상품번호
	name VARCHAR2(30), --상품이름
	price NumBER, --상품가격
	remainCount Number CHECK(remainCount >= 0) --재고갯수
);

-- 고객 계좌 테이블
Create table client_account(
	id varchar2(30) primary key, --고객의 아이디
	money number check(MONEY >= 0), -- 고객의 잔고
	point number --고객의 포인트
);

--sample data

insert into client_account (id, money, point)
values('gura', 10000, 0);

insert into client_account (id, money, point)
values('monkey', 10000, 0);



--주문 테이블 
create table client_order(
	num number primary key, --주문번호
	id varchar2(30), --주문 고객의 아이디
	code number, --주문한 상품의 번호
	addr varchar2(50) --배송 주소
); 

CREATE SEQUENCE client_order_seq;

--sample data
insert into shop (num, name, price, remainCount)
values(1, '사과', '1000', 5);

insert into shop (num, name, price, remainCount)
values(2, '바나나', '2000', 5);

insert into shop (num, name, price, remainCount)
values(3, '귤', '3000', 5);