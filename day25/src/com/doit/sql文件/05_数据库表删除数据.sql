/*
	删除表数据
	delete from 表名 where 条件;
*/
DELETE FROM category WHERE cid = 1;

DELETE FROM category WHERE cid = 2 OR cid = 9;


/*
	清空表中所有记录 
	delete from 表名; 这是数据库操作语言 DML语句 一条一条删除表记录
	truncate table 表名; 这是数据库定义语句 DDL语句 先drop表 创建一个一模一样的表

*/
