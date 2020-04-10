CREATE DATABASE IF NOT EXISTS agw DEFAULT CHARSET utf8mb4;

CREATE TABLE agw_api (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    code          varchar(255)                       NOT NULL COMMENT 'api唯一标识',
    name          varchar(255)                       NOT NULL COMMENT 'api接口名',
    method        varchar(255)                       NOT NULL COMMENT 'api方法名',
    alias         varchar(255)                           NULL COMMENT 'api方法别名',
    sys_id        bigint(20)                         NOT NULL COMMENT '所属业务系统id',
    timeout       smallint(6)                        NOT NULL DEFAULT 1000 COMMENT '超时时间，毫秒',
    ip_control    tinyint(4)                             NULL DEFAULT 0 COMMENT '是否白名单控制 0-否 1-是',
    PRIMARY KEY pk_id(id),
    INDEX idx_code(code),
    INDEX idx_sys_id(sys_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '接口信息';

CREATE TABLE agw_api_param (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    api_id        bigint(20)                         NOT NULL COMMENT 'api id',
    name          varchar(255)                       NOT NULL COMMENT '参数名',
    type          varchar(255)                       NOT NULL COMMENT '参数类型',
    `order`         smallint(6)                        NOT NULL COMMENT '参数顺序',
    PRIMARY KEY pk_id(id),
    INDEX idx_api_id(api_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '接口对应的参数信息';

CREATE TABLE agw_sys (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    name          varchar(255)                       NOT NULL COMMENT '业务系统名',
    `desc`          varchar(255)                       NOT NULL COMMENT '业务系统描述',
    PRIMARY KEY pk_id(id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '接口所属业务系统';

CREATE TABLE agw_out (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    name          varchar(255)                       NOT NULL COMMENT '业务系统名',
    `desc`          varchar(255)                       NOT NULL COMMENT '业务系统描述',
    code          varchar(255)                       NOT NULL COMMENT '外部系统唯一标识',
    PRIMARY KEY pk_id(id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '外部调用方';

CREATE TABLE agw_out_api (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    out_id        bigint(20)                         NOT NULL COMMENT '外部系统id',
    api_id        bigint(20)                         NOT NULL COMMENT 'api id',
    PRIMARY KEY pk_id(id),
    INDEX idx_out_id(out_id),
    INDEX idx_api_id(api_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '外部调用方拥有的api';

CREATE TABLE agw_out_ip (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    out_id        bigint(20)                         NOT NULL COMMENT '外部系统id',
    ip            varchar(255)                       NOT NULL COMMENT '外部系统白名单',
    PRIMARY KEY pk_id(id),
    INDEX idx_out_id(out_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '外部调用方的白名单配置';

CREATE TABLE agw_black_ip (
    id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键id',
    created_time  datetime                           NOT NULL COMMENT '创建时间',
    modified_time datetime                           NOT NULL COMMENT '修改时间',
    version       smallint(6)                        NOT NULL DEFAULT 1 COMMENT '版本号',
    out_id        bigint(20)                         NULL COMMENT '外部系统id',
    ip            varchar(255)                       NOT NULL COMMENT '黑名单ip',
    PRIMARY KEY pk_id(id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '黑名单ip';

















