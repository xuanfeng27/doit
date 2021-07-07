#常见的数据类型
/*
数值型：
	整型 
	小数：
		定点数
		浮点数
字符型：
	较短的文本：char、varchar
	较长的文本：text、blob（较长的二进制数据）

日期型：
	date 日期类型，格式为yyyy-MM-dd，包含年月日，不包含时分秒
	datetime 日期类型，格式为 YYYY-MM-DD HH:MM:SS，包含年月日时分秒
	timestamp 日期类型，时间戳





*/

#一、整型
/*
分类：
tinyint、smallint、mediumint、int/integer、bigint
1	 		2		3			4			8
注意：
1.如果不设置无符号还是有符号，默认是有符号，如果想设置无符号，需要添加unsigned关键字
2.如果不设置长度，会有默认的长度
  后面给(数字)代表宽度，如果不够会用0在左边填充，但必须搭配zerofill使用！

*/

#1.如何设置无符号和有符号

DROP TABLE IF EXISTS tab_int;
CREATE TABLE tab_int(
	t1 INT	  unsigned, #设置无符号 都是整数 如果插入负数 插入0
	t2 INT(5) ZEROFILL  #左边用0填充

);

DESC tab_int;

#二、小数
/*
分类：
1.浮点型
	float
	double
2.定点型
	dec(M，D)
	decimal(M,D)

注意：
	1.M：整数位数+小数位数  D：小数位数 如果超过范围，则插入临界值
	2.M和D都可以省略	如果是decimal，则M默认为10，D默认为0
	  如果是float和double，则会根据插入的数值的精度来决定精度
	3.定点型的精确度较高，如果要求插入数值的精度较高如货币运算等则考虑使用


*/

DROP TABLE tab_double;
CREATE TABLE tab_double(
	f1 FLOAT,
	f2 DOUBLE,
	f3 DECIMAL,
	f4 FLOAT(5,2),
	f5 DOUBLE(5,2),
	f6 DECIMAL(5,2)  
);


#三、字符型
/*
较短的文本：
char(M)
varchar(M)

较长的文本：
text
注意：
	M 代表长度 
	char(M)  固定长度字符  即使只存1个字符 也占用 M个字符的空间  效率高
	varchar(M) 可变长度字符  最大长度为M  节省空间   效率低

*/



CREATE TABLE tab_char(
	c1 ENUM('a','b','c')  #枚举 只能存储 a b c  字符 忽略大小写 其他字符添加不进来
);

INSERT INTO tab_char VALUES('a');
INSERT INTO tab_char VALUES('b');
INSERT INTO tab_char VALUES('c');
INSERT INTO tab_char VALUES('m');
INSERT INTO tab_char VALUES('A');

SELECT * FROM tab_set;



#四、日期型

/*

分类：
date只保存日期
time 只保存时间
year只保存年

datetime保存日期+时间  范围  1000——9999  不受时区影响
timestamp保存日期+时间  范围  1970-2038   受时区影响

*/


CREATE TABLE tab_date(
	t1 DATETIME,
	t2 TIMESTAMP
);



INSERT INTO tab_date VALUES(NOW(),NOW());

SELECT * FROM tab_date;

SHOW VARIABLES LIKE 'time_zone';

SET time_zone='+9:00';















