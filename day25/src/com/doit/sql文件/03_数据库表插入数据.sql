/*
	向表中添加数据 
	insert into 表名(列名,列名...) values(值1,值2...);
	列 和 值 要一一对应 类型对应 个数对应 顺序对应
	
	正常来说 所有的值 都应该加上 '' 数字类型 可以省略''
	文本 日期类型 都要加'' 或者 "" 推荐使用''
	
*/
INSERT INTO category(cid,cname) VALUES(3,'化妆品');

/*
	由于我们对cid设置了主键自动增长
	所以 赋值时 可以忽略主键添加

*/
INSERT INTO category(cname) VALUES('蔬菜');
/*
	如果说列特别多,写的时候非常麻烦 
	可以不写列名 但是此时是全列值的方式添加 所有的列都要赋值
	并且必须按照顺序赋值
	insert into 表名 values(全列值);
*/
INSERT INTO category VALUES(NULL,'家电');
/*
	支持批量掺入
	insert into 表名(列名,列名...) values(列值,列值...),(列值,列值...),(列值,列值...);
*/
INSERT INTO category VALUES
(NULL,'服装'),
(NULL,'饮品'),
(NULL,'小型家电');

/*
	添加数据的另外一种格式 
	insert into 表名 set 列名=列值....
*/
INSERT INTO category SET cid= NULL,cname='水果';




