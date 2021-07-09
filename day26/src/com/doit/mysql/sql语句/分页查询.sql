/*
	
	索引从0 开始
	
	limit  从第几个索引开始,size;
	
	
	
	limit  (当前页-1)*size , size;
	
	
	0   10    1
	
	10   10   2
	
	20   10   3
	
	30   10   4
	
	一般情况 limit都写在sql语句的最后
	
	
	select  列名  from 表名 where 条件 group by 列名 having 条件 order by 列名 limit (curPage-1)*pageSize,pageSize;
	
	
	
	
	
	

*/
SELECT * FROM product LIMIT 0 , 3;#当前是第一页

SELECT * FROM product LIMIT 3, 3;#当前是第二页 

SELECT * FROM product LIMIT 6 , 3;#当前是第三页