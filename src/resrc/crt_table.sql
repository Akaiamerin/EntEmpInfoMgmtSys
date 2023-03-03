CREATE DATABASE ent_emp_info_mgmt_sys;

USE ent_emp_info_mgmt_sys;

CREATE TABLE admin (
    acct VARCHAR(20) NOT NULL,
    pwd VARCHAR(20) NOT NULL,
    PRIMARY KEY(acct)
);

CREATE TABLE emp (
    id INT NOT NULL,
    name VARCHAR(20) NOT NULL,
    gender CHAR(2) NOT NULL CHECK (gender IN ('男', '女')),
    age INT NOT NULL CHECK (age >= 18 AND age <= 60),
    dept VARCHAR(20) NOT NULL CHECK (dept IN ('销售部', '市场部', '技术部', '财务部', '行政部')),
    job VARCHAR(20) NOT NULL CHECK (job IN ('员工', '组长', '主管', '经理', '总监')),
    sal DOUBLE NOT NULL,
    PRIMARY KEY(id)
);