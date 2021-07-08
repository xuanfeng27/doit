/*
	条件查询
	select 列名 from 表名 where 条件;
*/
#查询商品名称为“花花公子”的商品所有信息：
SELECT * FROM product WHERE  pname ='花花公子';
#查询价格为800商品
SELECT * FROM product WHERE price = 800;
#查询价格不是800的所有商品
SELECT * FROM product WHERE price != 800;
SELECT * FROM product WHERE price <> 800;
SELECT * FROM product WHERE NOT(price = 800);
#查询商品价格大于60元的所有商品信息
SELECT * FROM product WHERE price > 60;
#查询商品价格在200到1000之间所有商品
SELECT * FROM product WHERE price <=1000 AND price >=200 ;
#between 小值 and 大值  
SELECT * FROM product WHERE price BETWEEN 200 AND 1000;
#查询商品价格是200或800的所有商品
SELECT * FROM product WHERE price = 200 OR price =800;
#in(值1,值2,值3...)  值1,值2,值3 任选
SELECT * FROM product WHERE price IN (200,800);


/*

	模糊查询
	like 
	
	必须配合通配符一起使用  % _
*/
#查询所有带 霸字的商品
SELECT * FROM product WHERE pname LIKE '%霸%';
#查询第二个字是想的商品
SELECT * FROM product WHERE pname LIKE '_想%';
#查询所有4个字的商品
SELECT * FROM product WHERE pname LIKE '____';
#查询 第二个字符是 _的商品
SELECT * FROM product WHERE pname LIKE '_\_%';
SELECT * FROM product WHERE pname LIKE '_a_%' ESCAPE 'a';

/*
	null值的查询
	
	null值查询不能用=号  
	
	is null 
	is not null
*/
#查询分类id是null的商品
SELECT * FROM product WHERE category_id IS  NULL;
##查询分类id不是null的商品
SELECT * FROM product WHERE category_id IS NOT NULL;
SELECT * FROM product WHERE NOT(category_id IS  NULL);

# is只能和null 一起使用  其他使用 =
SELECT * FROM product WHERE price = 5000;



SELECT * FROM product WHERE TRUE;
SELECT * FROM product WHERE FALSE;
SELECT * FROM product WHERE TRUE AND FALSE;
SELECT * FROM product WHERE TRUE OR FALSE;
SELECT * FROM product WHERE TRUE AND FALSE  OR TRUE;
SELECT * FROM product WHERE 1 = 1;
SELECT * FROM product WHERE 1 = 2;
















