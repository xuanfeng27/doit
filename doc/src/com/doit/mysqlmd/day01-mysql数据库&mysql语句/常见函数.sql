#一、字符函数

#1.length 获取参数值的字节个数
SELECT LENGTH('helloworld');
SELECT LENGTH('你好');
SHOW VARIABLES LIKE '%char%'

#2.concat 拼接字符串

SELECT CONCAT('张','_','三');

#3.upper、lower
SELECT UPPER('HelloWorld');
SELECT LOWER('HelloWorld');

#4.substr(开始索引,长度)
#注意：索引从1开始
#从索引3开始 到末尾
SELECT SUBSTR('abcdefg',3)  out_put;

#从索引1开始 截取3个
SELECT SUBSTR('aaabbbccc',1,3) out_put;

#5.instr 返回子串第一次出现的索引，如果找不到返回0
SELECT INSTR('aaabbbaaaccc','aaa') AS out_put;

#6.trim
SELECT LENGTH(TRIM('    柳岩    ')) AS out_put;
SELECT TRIM('a' FROM 'aaaaaaaaa柳aaa岩aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa')  AS out_put;

#7.lpad 用指定的字符实现左填充指定长度
SELECT LPAD('aa',5,'*') AS out_put;

#8.rpad 用指定的字符实现右填充指定长度
SELECT RPAD('bb',6,'*') AS out_put;


#9.replace 替换

SELECT REPLACE('aaabbbcccaaaaccccdddd','aaa','fff') AS out_put;



#二、数学函数

#round 四舍五入
SELECT ROUND(1.567,2);


#ceil 向上取整,返回>=该参数的最小整数

SELECT CEIL(-1.02);

#floor 向下取整，返回<=该参数的最大整数
SELECT FLOOR(-9.99);

#truncate 截断 

SELECT TRUNCATE(1.69999,1);

#mod取余
SELECT MOD(10,3);
SELECT 10%3;


#三、日期函数

#now 返回当前系统日期+时间
SELECT NOW();

#curdate 返回当前系统日期，不包含时间
SELECT CURDATE();

#curtime 返回当前时间，不包含日期
SELECT CURTIME();


#可以获取指定的部分，年、月、日、小时、分钟、秒
SELECT YEAR(NOW()) 年;
SELECT YEAR('1998-1-1') 年;

SELECT  YEAR(hiredate) 年 FROM employees;

SELECT MONTH(NOW()) 月;
SELECT MONTHNAME(NOW()) 月;

#四、流程控制函数
#1.if函数： if else 的效果

SELECT IF(10<5,'大','小');

#2.case函数的使用一： switch case 的效果

/*

mysql中

case 要判断的字段或表达式
when 常量1 then 要显示的值1或语句1;
when 常量2 then 要显示的值2或语句2;
...
else 要显示的值n或语句n;
end
*/

/*案例：商品价格，要求

category_id=c001，显示的价格为1.1倍
category_id=c002，显示的价格为1.2倍
category_id=c003，显示的价格为1.3倍
其他分类，不变

*/


SELECT price,category_id,
CASE category_id
WHEN 'c001' THEN price*1.1
WHEN 'c002' THEN price*1.2
WHEN 'c003' THEN price*1.3
ELSE price
END AS newPrice
FROM product;



#3.case 函数的使用二：类似于 多重if
/*

case 
when 条件1 then 要显示的值1或语句1
when 条件2 then 要显示的值2或语句2
。。。
else 要显示的值n或语句n
end
*/

#案例：查询商品价格的情况
如果价格>=5000,显示'高'级别
如果价格>=2000,显示'中'级别
如果工资>=500，显示'低'级别
否则，显示'超低'级别


SELECT price,
CASE 
WHEN price>=5000 THEN '高'
WHEN price>=2000 THEN '中'
WHEN price>=500 THEN '低'
ELSE '超低'
END AS 价格级别
FROM product;



















