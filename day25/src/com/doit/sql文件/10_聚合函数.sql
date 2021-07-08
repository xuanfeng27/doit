/*
	聚合函数
	count(列) 计数 
	sum(列) 求和 
	max(列) 最大值 
	min(列) 最小值
	avg(列) 平均值
	
	聚合函数忽略null值
*/
SELECT COUNT(pid) FROM product;
SELECT COUNT(category_id) FROM product;
SELECT COUNT(*) FROM product;

#查询所有商品价格的和 
SELECT SUM(price) FROM product;
#查询所有商品价格的平均值
SELECT AVG(price) FROM product;#1964.5
#查询最大价格 和最小价格 
SELECT MAX(price) AS 'maxPrice',MIN(price) AS 'minPrice' FROM product;

