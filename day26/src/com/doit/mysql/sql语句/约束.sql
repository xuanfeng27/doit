/*
	约束 为哪一列设置约束 就是对这一列数据进行限制
	
	约束的种类 
		  主键约束   primary key  代表当前列非空 唯一 要求每个表都应该有一个主键 只能有一个
		  非空约束   not null   代表当前列 不能为null  一个表可以有多个非空约束
		  唯一约束   unique   代表当前列数据不能重复 但是可以为null值 可以多个null  一个表可以有多个唯一约束
		  默认约束   default 值   如果当前列不赋值 那么 会有默认值  一个表可以有多个默认约束
		  
     如何添加约束 
         1.创建列时直接添加 
			   列级约束  
			   主键 非空 唯一  默认 
			   
		 2.创建表时在constraint区域添加
			   表级约束  
			   主键  唯一
			   
			   [constraint  主键名(自定义)]  primary key(主键列)
			    [constraint  名字(自定义)]   unique(唯一列)
*/

#列级约束 添加
CREATE TABLE person(
	pid INT PRIMARY KEY,
	pname VARCHAR(50) NOT NULL,
	pcard  VARCHAR(50) UNIQUE NOT NULL,
	page  INT  DEFAULT 18
);

DESC person


CREATE TABLE person(
	pid INT ,
	pname VARCHAR(50) NOT NULL,
	pcard  VARCHAR(50),
	page  INT  DEFAULT 18 ,
	
	CONSTRAINT pk_pid PRIMARY KEY (pid),
	CONSTRAINT un_card UNIQUE(pcard)
	
);


DROP TABLE IF EXISTS person;
CREATE TABLE person(
	pid INT ,
	pname VARCHAR(50),
	pcard  VARCHAR(50) ,
	page  INT 
);

/*
	通过修改表结构的方式添加
	alter table 表名 add/modify  列名  数据类型  约束

*/

#添加主键 
ALTER TABLE person MODIFY pid INT PRIMARY KEY ;
ALTER TABLE person ADD CONSTRAINT  pk_pid PRIMARY KEY(pid);
#删除主键  
ALTER TABLE person DROP PRIMARY KEY ;


#添加非空 
ALTER TABLE person MODIFY pname  VARCHAR(50) NOT NULL;
#删除非空
ALTER TABLE person MODIFY pname  VARCHAR(50) ;



#添加唯一 
ALTER TABLE person MODIFY pcard  VARCHAR(50) UNIQUE;
ALTER TABLE person ADD CONSTRAINT un_card UNIQUE(pcard);


#删除唯一约束
ALTER TABLE person DROP INDEX un_card;


DESC person



#联合主键
/*
	将两列 或者 多列 看做成是一个主键 
	这两列的数据 不能有null出现 
	也不可以完全相同 
*/
CREATE TABLE persons
(
	firstname VARCHAR(255),
	lastname VARCHAR(255),
	address VARCHAR(255),
	city VARCHAR(255),
	CONSTRAINT pk_personID PRIMARY KEY (firstname,lastname)
);



DROP TABLE IF EXISTS persons;
CREATE TABLE persons
(
p_id INT PRIMARY KEY AUTO_INCREMENT,
lastname VARCHAR(255),
firstname VARCHAR(255),
address VARCHAR(255),
city VARCHAR(255)
)

#删除自动增长
ALTER TABLE persons MODIFY p_id INT ;
#删除主键约束
ALTER TABLE persons DROP PRIMARY KEY ;
DESC persons;








