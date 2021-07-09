/*
	子查询  
	一条sql语句的结果可以是 另外一条sql语句一部分 

*/
#查询所有化妆品的记录   cname ='化妆品'

#1.先查询出 化妆品的cid是多少 
SELECT cid FROM category WHERE cname = '化妆品';
#2 查询所有化妆品商品的记录 一条语句的查询结果 是另外一条语句的查询条件
SELECT * FROM products WHERE cid = 
	(SELECT cid FROM category WHERE cname = '化妆品');

#查询所有化妆品和家电的商品的记录 

SELECT * FROM products WHERE cid IN 
	(SELECT cid FROM category WHERE cname = '化妆品' OR cname='家电');
	
	
SELECT * FROM products WHERE cid IN('c001','c003');

SELECT * FROM products WHERE cid ='c001' OR cid = 'c003';

SELECT * FROM products WHERE cid =(SELECT cid FROM category WHERE cname ='家电') OR cid =(SELECT cid FROM category WHERE cname = '化妆品')


#使用内连接 查询所有化妆品的记录
SELECT * FROM category,products  WHERE  category.cid = products.cid AND category.cname = '化妆品';




#查询所有化妆品的记录  此时 使用伪表的方式 

SELECT * FROM 
	(SELECT * FROM category WHERE cname = '化妆品') c,products p
	WHERE c.cid = p.cid


/*
	标量子查询 
	相关子查询  
*/






