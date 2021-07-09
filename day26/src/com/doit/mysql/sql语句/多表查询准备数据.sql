CREATE DATABASE day02_query;
USE day02_query;

# 分类表
CREATE TABLE category (
  cid VARCHAR(32) PRIMARY KEY ,
  cname VARCHAR(50)
);

#商品表
CREATE TABLE products(
  pid  INT PRIMARY KEY AUTO_INCREMENT ,
  pname VARCHAR(50),
  price DOUBLE,
  flag VARCHAR(2), #是否上架标记为：1表示上架、0表示下架
  cid VARCHAR(32),
  CONSTRAINT products_fk FOREIGN KEY (cid) REFERENCES category (cid)
);


#分类
INSERT INTO category(cid,cname) VALUES('c001','家电');
INSERT INTO category(cid,cname) VALUES('c002','服饰');
INSERT INTO category(cid,cname) VALUES('c003','化妆品');
#商品
INSERT INTO products(pid, pname,price,flag,category_id) VALUES(1,'联想',5000,'1','c001');
INSERT INTO products(pid, pname,price,flag,category_id) VALUES(2,'海尔',3000,'1','c001');
INSERT INTO products(pid, pname,price,flag,category_id) VALUES(3,'雷神',5000,'1','c001');

INSERT INTO products (pid, pname,price,flag,category_id) VALUES(4,'JACK JONES',800,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES(5,'真维斯',200,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES(6,'花花公子',440,'1','c002');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES(7,'劲霸',2000,'1','c002');

INSERT INTO products (pid, pname,price,flag,category_id) VALUES(8,'香奈儿',800,'1','c003');
INSERT INTO products (pid, pname,price,flag,category_id) VALUES(9,'相宜本草',200,'1','c003');