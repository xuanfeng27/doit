USE day01;


/*
	查看数据库中有哪些表
	show tables;
*/	
SHOW TABLES;

/*
	查看表结构
	desc 表名;
*/
DESC tab_date;

/*
	删除表 
	drop table 表名;
*/
DROP TABLE tab_date;
DROP TABLE tab_int;


/*
	创建数据库表 
	create table 表名(
		列名 数据类型 [约束],
		列名 数据类型 [约束],
		列名 数据类型 [约束]
	);
*/

CREATE TABLE student(
	sid  INT ,
    sname VARCHAR(20),
    sheight DOUBLE,
    sbrithday DATE
);

/*
	约束:就是限制当前列的数据
	主键约束:每一张表都应该有一个主键约束
			 限制当前列的数据 非空 唯一
			 一个表只能有一个主键约束 
	列名 数据类型  primary key
	
	mysql可以设置主键自动增长
	我们要是为主键设置了自动增长
	那么今后 主键就不需要我们来管了
	mysql自己维护这个主键 
	需要注意 这个主键必须是 数值类型
	
	primary key auto_increment

*/
#创建表 设置主键自动增长
DROP TABLE IF EXISTS student;
CREATE TABLE student(
	sid  INT PRIMARY KEY AUTO_INCREMENT,
    sname VARCHAR(20),
    sheight DOUBLE,
    sbrithday DATE
);




DESC student;

/*
	创建一张分类表 category 
	定义一个主键 cid  自动增长
	定义一个列 cname 分类名称
*/
CREATE TABLE category(
	cid INT PRIMARY KEY AUTO_INCREMENT,
	cname VARCHAR(100) 	
);


/*
	复制表
*/
CREATE TABLE cat
SELECT * FROM category;


/*
	修改表结构 
*/
/*
	添加列 
	alter table 表名 add  列名 数据类型 [约束]
*/
#为分类表添加一个新的字段为 分类描述 varchar(200)
ALTER TABLE category ADD description VARCHAR(200);

#将分类描述 修改为  varchar(100) 不允许null值
#alter table 表名 modify 列名 数据类型 [约束];
#修改某一列的 数据类型 和 约束
ALTER TABLE category MODIFY description VARCHAR(100) NOT NULL;
/*
	修改列  
	修改列名 数据类型 约束
	alter table  表名  change 旧列名 新列名 数据类型 [约束];
*/
#将分类描述 改为 desc  varchar(200) 允许null值
ALTER TABLE category CHANGE description `desc` VARCHAR(200) NULL;
/*
	删除列
	alter table 表名 drop 列名;
*/
ALTER TABLE category DROP `desc`;

/*
	修改表名
	rename table 表名 to 新表名; 
*/
RENAME TABLE category TO c;
RENAME TABLE c TO category;





