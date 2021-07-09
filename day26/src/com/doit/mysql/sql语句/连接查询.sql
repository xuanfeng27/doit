/*
	交叉查询 
	select * from A,B;  
	查询出来的结果是笛卡尔积 有问题 
*/
SELECT * FROM category,products;
/*
   内连接  隐式内连接 
   sql92标准  1992 
		select * from A,B where A.key = B.key;
   sql99标准  1999
		select * from A inner join B on A.key = B.key;

*/
SELECT * FROM category,products WHERE  category.cid = products.cid;
#查询商品名称 及 商品对应的分类名称
SELECT products.pname,category.cname FROM category,products WHERE category.cid = products.cid;
#起别名 
SELECT p.pname,c.cname FROM category  c ,products p WHERE c.cid = p.cid;
#查询除了家电  商品名称 及商品分类 
SELECT p.pname,c.cname FROM category c ,products p WHERE c.cid = p.cid  AND c.cname!='家电';
#查询分类名称 及 每种分类有几个商品 按照个数升序排列
SELECT  cname, COUNT(pid) FROM category,products WHERE category.cid = products.cid GROUP BY products.cid ORDER BY COUNT(pid);
#查询分类名称 及 每种分类有几个商品 只显示商品个数大于2的分类  按照 个数降序排列
SELECT c.cname,COUNT(*) num  
	FROM category c,products p 
   WHERE c.cid = p.cid  
   GROUP BY p.cid 
   HAVING num>2 
   ORDER BY num DESC ;
#相同分类下的商品个数
SELECT COUNT(*) FROM products GROUP BY cid;
SELECT * FROM category,products WHERE  category.cid = products.cid;
#显示内连接 
SELECT *
FROM category
        INNER JOIN products
          ON category.cid = products.cid
WHERE cname = '化妆品';
SELECT * FROM category  JOIN products ON category.cid = products.cid WHERE cname='化妆品';
#查询 所有上架的 商品名称 商品价格 商品分类  并按照价格 升序排列
SELECT p.pname,p.price,c.cname  FROM category c,products p WHERE c.cid = p.cid AND flag = 1 ORDER BY p.price;
SELECT
        p.pname,
        p.price,
        c.cname
FROM category c
        INNER JOIN products p
          ON c.cid = p.cid
WHERE flag = 1
ORDER BY p.price;


#查询 所有上架商品中每种分类价格最高的商品名称和商品分类 

SELECT  MAX(price),c.cname FROM category c,products p WHERE c.cid = p.cid AND flag =1  GROUP BY p.cid;

/*
	外连接  
	  左外连接 
		select * from A left outer join B on 条件 
	  右外连接 
		select * from A right outer join B on 条件
*/

SELECT * FROM category,products WHERE  category.cid = products.cid;

SELECT * FROM category LEFT JOIN products ON  category.cid = products.cid;




