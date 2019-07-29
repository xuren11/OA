DROP DATABASE IF EXISTS OA;
CREATE DATABASE OA;
USE OA;

-- 报销单表
CREATE TABLE expense_account (
	id INT NOT NULL auto_increment PRIMARY KEY,
	cause VARCHAR (100) COMMENT '原因',
	create_sn CHAR (5) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	next_deal_sn CHAR (5) COMMENT '下一个处理人',
	total_amount DOUBLE COMMENT '总金额',
	STATUS VARCHAR (20) COMMENT '审批状态'
) ENGINE = INNODB CHARSET = utf8;

-- 报销明细表
CREATE TABLE expense_account_detail (
	id INT NOT NULL auto_increment PRIMARY KEY,
	expense_account_id INT COMMENT '报销单表id',
	item VARCHAR (20) COMMENT '明细项',
	amount DOUBLE COMMENT '金额',
	COMMENT VARCHAR (100) COMMENT '备注'
	-- FOREIGN key (expense_account_id) REFERENCES expense_account(id)
	-- 设置外键 不过不建议这样设置
) ENGINE = INNODB CHARSET = utf8;

SHOW CREATE TABLE expense_account_detail;

-- 报销单处理记录表
CREATE TABLE expense_account_deal (
	id INT NOT NULL auto_increment PRIMARY KEY,
	expense_account_id INT COMMENT '报销单表id',
	deal_sn CHAR (5) COMMENT '处理人',
	deal_time DATETIME COMMENT '处理时间',
	deal_way VARCHAR (20) COMMENT '处理类型',
	deal_result VARCHAR (20) COMMENT '处理结果',
	COMMENT VARCHAR (100) COMMENT '备注'
) ENGINE = INNODB CHARSET = utf8;

ALTER TABLE expense_account_deal CHANGE deal_time deal_time DATETIME;

-- 部门表
CREATE TABLE department (
	sn CHAR (10) PRIMARY KEY COMMENT '部门编号',
	NAME VARCHAR (20) COMMENT '部门名称',
	address VARCHAR (100) COMMENT '部门位置'
) ENGINE = INNODB charset = utf8;

-- 员工表
CREATE TABLE employee (
	sn CHAR (10) PRIMARY KEY COMMENT '员工编号',
	NAME VARCHAR (20) COMMENT '员工姓名',
	PASSWORD CHAR (10) COMMENT '密码',
	department_sn VARCHAR (20) COMMENT '所属部门',
	post VARCHAR (20) COMMENT '职务'
) ENGINE = INNODB charset = utf8;

-- 体检各个依赖关系
ALTER TABLE employee ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (department_sn) REFERENCES department (sn) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE expense_account ADD CONSTRAINT FK_Reference_2 FOREIGN KEY (next_deal_sn) REFERENCES employee (sn) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE expense_account ADD CONSTRAINT FK_Reference_3 FOREIGN KEY (create_sn) REFERENCES employee (sn) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE expense_account_detail ADD CONSTRAINT FK_Reference_4 FOREIGN KEY (expense_account_id) REFERENCES expense_account (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE expense_account_deal ADD CONSTRAINT FK_Reference_5 FOREIGN KEY (expense_account_id) REFERENCES expense_account (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE expense_account_deal ADD CONSTRAINT FK_Reference_6 FOREIGN KEY (deal_sn) REFERENCES employee (sn) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- 预先插入数据  后期可能有一个超级管理员，可以通过界面创建 部门
INSERT INTO department
VALUES
	(
		'10001',
		'总经理办公室',
		'CBD E座1223'
	);

INSERT INTO department
VALUES
	(
		'10002',
		'财务部',
		'CBD E座1223'
	);

INSERT INTO department
VALUES
	(
		'10003',
		'事业部',
		'CBD E座1223'
	);

-- 一起执行 比单个一个个插入执行更快
INSERT INTO employee
VALUES
	(
		'10001',
		'孙权',
		'123456',
		'10001',
		'总经理'
	),
	(
		'10002',
		'大乔',
		'123456',
		'10002',
		'财务'
	),
	(
		'10003',
		'周瑜',
		'123456',
		'10003',
		'部门经理'
	),
	(
		'10004',
		'黄盖',
		'123456',
		'10003',
		'员工'
	);

