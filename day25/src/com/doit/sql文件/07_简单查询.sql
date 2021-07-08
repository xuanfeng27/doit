/*
	select  常量/函数/表达式 ;
*/

#查询常量 select 常量值
SELECT 10;
SELECT 'aaa';

#查询表达式 
SELECT 10 * 100;
SELECT 10/3;

#查询函数 
SELECT DATABASE();
SELECT VERSION();

/*
	+号的问题
	mysql中的+号 只能做运算
	
*/
#数字+数字
SELECT 1+1;
#数字+字符串  字符串如果能转换为数字 没问题 将字符串转换为数字 然后相加
SELECT 1+"10";
#字符串如果不能转换为数字 值为0
SELECT 'abc'+'10';
#任何数 与null 相加 值为null
SELECT 10+NULL;


/*
	简单查询 查询表内数据 
	select 列名,列名... from 表名 ;
*/
#查询商品名称
SELECT pname FROM product;
#查询商品名和商品价格
SELECT pname,price FROM product;
SELECT price,pname FROM product;

#查询所有列 
SELECT 
	pid,
	pname,
	price,
	category_id
FROM 
   product;
SELECT  * FROM  product;


#查询商品名称 和 商品价格 将价格上涨100
SELECT pname,price+100 FROM product;

#别名查询   列名 as '别名'
SELECT pname,price+100 AS 'newPrice' FROM product;
SELECT pname,price+100 'new Price' FROM product;
SELECT pname,price+100 newPrice FROM product;

#去重  查询所有价格  去掉重复的 distinct 列
# 如果distinct 列名,列名  这两列完全相同 才会去重
SELECT DISTINCT price FROM product;
























