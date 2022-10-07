-- 订单
drop table orders;
CREATE TABLE orders(
  id varchar(32)  PRIMARY KEY,
  orderNum varchar(20) NOT NULL UNIQUE,
  orderTime datetime,
  peopleCount INT,
  orderDesc varchar(500),
  payType INT,
  orderStatus INT,
  productId varchar(32),
  memberId varchar(32),
  FOREIGN KEY (productId) REFERENCES product(id),
  FOREIGN KEY (memberId) REFERENCES member(id)
)
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '12345', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '54321', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('2FF351C4AC744E2092DCF08CFD314420', '67890', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '98765', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('E4DD4C45EED84870ABA83574A801083E', '11111', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', '22222', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55F9AF582D5A4DB28FB4EC3199385762', '33333', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', '44444', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('3081770BC3984EF092D9E99760FDABDE', '55555', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %h:%i:%s'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');


-- 会员
drop table member;
CREATE TABLE member(
       id varchar(32)  PRIMARY KEY,
       NAME varchar(20),
       nickname varchar(20),
       phoneNum varchar(20),
       email varchar(20) 
);
insert into MEMBER (id, name, nickname, phonenum, email)
values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');


-- 旅客
drop table traveller;
CREATE TABLE traveller(
  id varchar(32)  PRIMARY KEY,
  NAME varchar(20),
  sex varchar(20),
  phoneNum varchar(20),
  credentialsType INT,
  credentialsNum varchar(50),
  travellerType INT
)
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0, '987654321123456789', 1);


-- 订单与旅客中间表
drop table order_traveller;
CREATE TABLE order_traveller(
  orderId varchar(32),
  travellerId varchar(32),
  PRIMARY KEY (orderId,travellerId),
  FOREIGN KEY (orderId) REFERENCES orders(id),
  FOREIGN KEY (travellerId) REFERENCES traveller(id)
)

insert into ORDER_TRAVELLER (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');


CREATE TABLE product(
id varchar(32)  PRIMARY KEY,
productNum varchar(50) NOT NULL,
productName varchar(50),
cityName varchar(50),
DepartureTime datetime,
productPrice Number,
productDesc varchar(500),
productStatus INT,
CONSTRAINT product UNIQUE (id, productNum)
)
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
values ('676C5BD1D35E429A8C2E114939C5685A', 'itcast-002', '北京三日游', '北京', str_to_date('10-
10-2018 10:10:00', '%d-%m-%Y %h:%i:%s'), 1200, '不错的旅行', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
values ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'itcast-003', '上海五日游', '上海', str_to_date('25-
04-2018 14:30:00', '%d-%m-%Y %h:%i:%s'), 1800, '魔都我来了', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice,
productdesc, productstatus)
values ('9F71F01CB448476DAFB309AA6DF9497F', 'itcast-001', '北京三日游', '北京', str_to_date('10-
10-2018 10:10:00', '%d-%m-%Y %h:%i:%s'), 1200, '不错的旅行', 1);

INSERT INTO product (id, productNum, productName, cityName, DepartureTime, productPrice,productDesc, productStatus)VALUES ('676C5BD1D35E429A8C2E114939C5685A', 'itcast-002', '北京三日游', '北京', STR_TO_DATE('10-10-2018 10:10:00','%d-%m-%Y %h:%i:%s'), 1200, '不错的旅行', 1);

-- 用户表
CREATE TABLE users(
id VARCHAR(32) PRIMARY KEY,
email VARCHAR(50) UNIQUE NOT NULL,
username VARCHAR(50),
passwd VARCHAR(50),
phoneNum VARCHAR(20),
userstatus INT
)


-- 角色表
CREATE TABLE role(
id varchar2(32) default SYS_GUID() PRIMARY KEY,
roleName VARCHAR2(50) ,
roleDesc VARCHAR2(50)
)


-- 用户角色关联表
CREATE TABLE users_role(
userId varchar2(32),
roleId varchar2(32),
PRIMARY KEY(userId,roleId),
FOREIGN KEY (userId) REFERENCES users(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)

-- 资源权限表
CREATE TABLE permission(
id varchar2(32) default SYS_GUID() PRIMARY KEY,
permissionName VARCHAR2(50) ,
url VARCHAR2(50)
)

-- 角色权限关联表
CREATE TABLE role_permission(
permissionId varchar2(32),
roleId varchar2(32),
PRIMARY KEY(permissionId,roleId),
FOREIGN KEY (permissionId) REFERENCES permission(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)

-- 日志表
CREATE TABLE sysLog(
id VARCHAR2(32) PRIMARY KEY,
visitTime DATETIME,
username VARCHAR(50),
ip VARCHAR(30),
url VARCHAR(50),
executionTime INT,
method VARCHAR(200)
)
