/*
	修改表数据
	
	update 表名 set 列名= 列值 where 条件;
	
	条件 
	> 
	<
	>=
	<=
	=
	!=
	
	and 
	or 
	not
	
*/
UPDATE category SET cname = '首饰' WHERE cname='水果';

UPDATE category SET cname ='水果' WHERE cname ='aaa';

UPDATE category SET cname ='首饰' WHERE cid =1 OR cid = 2;