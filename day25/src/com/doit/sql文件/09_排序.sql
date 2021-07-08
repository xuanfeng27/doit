/*
	排序 
	order by 列名  ASC 升序   默认
	order by 列名  desc 降序 
	
	排序 一般情况都是 先查询 得到结果 对结果进行排序 
	所以排序一般都写在 最后.
	
	order by 列名/别名
*/
#查询所有信息对价格 从低到高排序
SELECT * FROM product ORDER BY price ;
SELECT * FROM product ORDER BY price ASC;

#查询所有分类是c001的商品 然后对价格进行降序排列 
SELECT * FROM product WHERE category_id = 'c001' ORDER BY price DESC;

#查询所有分类是c001的商品 将商品价格上涨百分之10 对价格降序排列
SELECT pid,pname,price*1.1,category_id FROM product WHERE category_id = 'c001' ORDER BY price*1.1 DESC;

SELECT pid,pname,price*1.1 AS 'newPrice',category_id FROM product WHERE category_id = 'c001' ORDER BY newPrice DESC;

