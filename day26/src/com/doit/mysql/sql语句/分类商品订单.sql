CREATE DATABASE day02;
USE day02;

/*

	创建分类表 
	为分类表添加数据
	创建商品表
	为商品表添加外键约束
	为商品表添加数据
*/
#创建分类表
CREATE TABLE category(
	cid INT PRIMARY KEY AUTO_INCREMENT,
	cname VARCHAR(100)
);

#向分类表中添加数据 
INSERT INTO category(cname) VALUES
('服装'),
('化妆品'),
('家电'),
('鞋帽'),
('厨具');

#创建商品表
CREATE TABLE product(
	pid INT PRIMARY KEY AUTO_INCREMENT,
	pname VARCHAR(100),
	price DOUBLE ,
	cid INT 
);

#为商品表添加外键约束 
/*
	主表:category 
	从表:product 
	添加外键的列:product.cid
	引用的主键列:category.cid
	alter table 从表 add constraint 外键名 foreign key  从表(添加外键的列)
	references 主表(引用的主键列)
	*/
ALTER TABLE product ADD CONSTRAINT fk_cid FOREIGN KEY product(cid)
REFERENCES category(cid) ;

#为商品表添加数据
INSERT INTO product(pname,price,cid) VALUES
('内衣',500,1),
('风衣',2000,1),
('羽绒服',300,1),
('手电筒',20,3),
('电冰箱',8000,3);

/*
	向商品表中添加错误的数据  
	主表中没有的cid 
*/
INSERT INTO product(pname,price,cid) VALUES ('黄瓜',100,10);



/*
	创建订单表   
	向订单表中添加数据
	创建中间表
	为中间表添加外键约束 
	向中间表中添加数据

*/
CREATE TABLE orders(
	oid INT PRIMARY KEY AUTO_INCREMENT,
	totalPrice DOUBLE 
);


#向订单表中插入数据 
INSERT INTO orders(totalPrice) VALUES
(2500),
(3000),
(10000),
(2800);


#创建中间表
CREATE TABLE pro_ord(
	pid INT ,
	oid INT 
);

#为中间表 添加外键约束
/*	
	主表  product
	从表 pro_ord
	外键列:pro_ord(pid)
	主键列:product(pid)
*/
ALTER TABLE pro_ord ADD CONSTRAINT pro_ord_pid FOREIGN KEY pro_ord(pid)
REFERENCES product(pid);
/*
	主表  orders 
	从表 pro_ord
	外键列:pro_ord(oid)
	主键列:orders(oid)

*/
ALTER TABLE pro_ord ADD CONSTRAINT pro_ord_oid FOREIGN KEY pro_ord(oid)
REFERENCES orders(oid);
/*
	向中间表中插入数据
*/
INSERT INTO pro_ord VALUES
(1,1),
(1,2),
(1,4),
(2,4),
(3,4);
/*
	向中间表中添加错误数据 
	product中没有的pid
	或者 
	orders中没有的oid
*/
INSERT INTO pro_ord VALUES(10,20);


/*
	一个公司有多名员工   部门领导  普通员工  公司分为不同的部门
	公司要求 每个部门都装门禁   自己部门的普通员工  只能进入自己部门的区域
	但是 部门领导的门禁卡 可以通行  所有区域 
	
	
	用户     角色          权限  
    张三     领导           1号门
    李四     普通员工       2号门
						    3号门
*/ 				















