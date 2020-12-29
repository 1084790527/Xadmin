CREATE TABLE sys(
        id VARCHAR(20),
        nickname VARCHAR(30) COMMENT '昵称',
        mobile_no VARCHAR(11) COMMENT '手机号 登入账号',
        real_name VARCHAR(30) COMMENT '真实姓名',
        profile_pic VARCHAR(100) COMMENT '头像地址',
        sex VARCHAR(1) DEFAULT '0' COMMENT '性别 0未知 1男 2女',
        password VARCHAR(60) COMMENT '密码',
        birthday DATETIME COMMENT '出生日期',
        reg_date DATETIME COMMENT '注册日期',
        update_date DATETIME COMMENT '用户修改日期',
        last_date DATETIME COMMENT '最后登录日期',
        last_mod_oper_id VARCHAR(20) COMMENT '最后修改操作员id',
        last_mod_oper_date DATETIME COMMENT '最后修改操作员时间',
        last_audit_oper_id VARCHAR(20) COMMENT '最后审核操作员id',
        last_audit_oper_date DATETIME COMMENT '最后审核时间',
        last_login_ip VARCHAR(40) COMMENT '最后登录ip',
        state varchar(2) default '1' COMMENT '用户状态 2删除 1启用 0停用',
        agency_id varchar(200) COMMENT '当前的所属机构id',
        defaults varchar(1) COMMENT '1 机构默认操作员  0由机构操作员创建的操作员',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户会员表';
ALTER TABLE sys ADD FULLTEXT (nickname);
ALTER TABLE sys ADD FULLTEXT (mobile_no);
ALTER TABLE sys ADD FULLTEXT (agency_id);
CREATE TABLE agency (
        id VARCHAR(20),
        name VARCHAR(20) COMMENT '机构名称',
        mobile_no VARCHAR(15) COMMENT '电话号码',
        reg_date DATETIME COMMENT '注册日期',
        update_date DATETIME COMMENT '修改日期',
        cre_oper_id VARCHAR(20)  COMMENT '创建人员id',
        last_mod_oper_id VARCHAR(20) COMMENT '最后修改操作员id',
        last_mod_oper_date DATETIME COMMENT '最后修改操作员时间',
        state varchar(2) default '0' COMMENT '状态 2删除 1启用 0停用',
        city_id VARCHAR(20) COMMENT '所在城市',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构';
ALTER TABLE agency ADD FULLTEXT (mobile_no);
ALTER TABLE agency ADD FULLTEXT (name);
CREATE TABLE sys_role(
        user_id varchar(20) default '' COMMENT '用户id',
        role_id varchar(20) default '' COMMENT '角色id',
        state varchar(2) default '0' COMMENT '1启用 0停用',
        last_mod_oper_id VARCHAR(20) COMMENT '最后修改操作员id',
        last_mod_oper_date DATETIME COMMENT '最后修改操作员时间',
        cre_oper_id VARCHAR(20)  COMMENT '创建人员id',
        cre_date DATETIME COMMENT '添加日期',
        PRIMARY KEY (user_id,role_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';
ALTER TABLE sys_role ADD FULLTEXT (state);
CREATE TABLE role(
        id VARCHAR(20),
        name varchar(30) COMMENT '角色名称',
        _desc varchar(100) COMMENT '描述',
        state varchar(2) default '0' COMMENT '1启用 0停用 2删除',
        last_mod_oper_id VARCHAR(20) COMMENT '最后修改操作员id',
        last_mod_oper_date DATETIME COMMENT '最后修改操作员时间',
        cre_oper_id VARCHAR(20)  COMMENT '创建人员id',
        cre_date DATETIME COMMENT '添加日期',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
ALTER TABLE role ADD FULLTEXT (name);
ALTER TABLE role ADD FULLTEXT (state);
CREATE TABLE role_privileges(
        privilege_id varchar(20) default '' COMMENT '权限id',
        role_id varchar(20) default '' COMMENT '角色id',
        state varchar(2) default '0' COMMENT '1启用 0停用',
        last_mod_oper_id VARCHAR(20) COMMENT '最后修改操作员id',
        last_mod_oper_date DATETIME COMMENT '最后修改操作员时间',
        cre_oper_id VARCHAR(20)  COMMENT '创建人员id',
        cre_date DATETIME COMMENT '添加日期',
        PRIMARY KEY (privilege_id,role_id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';
ALTER TABLE role_privileges ADD FULLTEXT (state);

CREATE TABLE privileges(
        id varchar(20) default '' COMMENT 'id',
        name varchar(30) COMMENT '角色名称',
        _desc varchar(100) COMMENT '描述',
        parent_id varchar(20) default '' COMMENT '父id',
        menu_level int default 0 COMMENT '菜单层级',
        permission_type int default 0 COMMENT '1按钮 0页面',
        permission varchar(100) default '' COMMENT '权限名称',
        url varchar(200) default '' COMMENT 'url请求地址',
        method_type varchar(20) default '' COMMENT 'url请求方式',
        state varchar(2) default '0' COMMENT '1启用 0停用',
        last_mod_oper_id VARCHAR(20) COMMENT '最后修改操作员id',
        last_mod_oper_date DATETIME COMMENT '最后修改操作员时间',
        cre_oper_id VARCHAR(20)  COMMENT '创建人员id',
        cre_date DATETIME COMMENT '添加日期',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
ALTER TABLE privileges ADD FULLTEXT (name);
ALTER TABLE privileges ADD FULLTEXT (parent_id);
ALTER TABLE privileges ADD FULLTEXT (menu_level);
ALTER TABLE privileges ADD FULLTEXT (state);


