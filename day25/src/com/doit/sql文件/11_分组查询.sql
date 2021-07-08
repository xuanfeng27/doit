/*
	分组查询 
	group by 列名
	
	1.对哪列分组 就是将这一列或者多列相同数据作为一组
	2.分组查询一般都要结合聚合函数使用 max min sum count avg 
	3.分组查询一定要把分组的列 查询出来
	
*/
#查询所有分类id相同的商品的 价格的和
SELECT category_id,SUM(price) FROM product GROUP BY category_id;
#查询所有相同商品名 商品价格的和
SELECT pname,SUM(price) FROM product GROUP BY pname;
#查询所有相同商品名 商品价格的和 将结果升序排列
SELECT pname,SUM(price) FROM product GROUP BY pname ORDER BY SUM(price)
#查询除了联想这个商品之外的  所有相同商品名 商品价格的和 将结果升序排列
SELECT pname ,SUM(price) FROM product WHERE pname !='联想' GROUP BY pname ORDER BY SUM(price);
#查询除了联想这个商品之外的  所有相同商品名 商品价格的和  只要价格大于2000以上的 将结果升序排列
SELECT pname ,SUM(price) FROM product WHERE pname !='联想'  GROUP BY pname HAVING SUM(price)>=2000 ORDER BY SUM(price);


/*

	where 是分组前过滤 后面不能跟 聚合函数 或者 别名
	having 是分组后过滤 后面可以跟聚合函数 或者 别名


*/

