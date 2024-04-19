Create DATABASE ideadb;
CREATE SCHEMA ideadb;
GRANT All PRIVILEGES ON ideadb.* TO 'ohgiraffers'@'%';
SHOW GRANTS FOR 'ohgiraffers'@'%';



DROP TABLE IF EXISTS `tbl_category`;

CREATE TABLE `tbl_category`
(
    `category_code`    INT NOT NULL AUTO_INCREMENT,
    `category_name`    VARCHAR(50) NOT NULL,
    `ref_category_code`    INT,
    PRIMARY KEY ( `category_code` )
);

CREATE UNIQUE INDEX `tbl_category_PK` ON `tbl_category`
    ( `category_code` );


DROP TABLE IF EXISTS  `tbl_idea`;

CREATE TABLE `tbl_idea`
(
    `idea_code`    INT NOT NULL AUTO_INCREMENT,
    `idea_name`    VARCHAR(50) NOT NULL,
    `idea_rank`    INT DEFAULT 1 NOT NULL,
    `idea_work_count`    INT DEFAULT 0,
    `category_code`    INT NOT NULL,
    PRIMARY KEY ( `idea_code` )
);

CREATE UNIQUE INDEX `tbl_idea_PK` ON `tbl_idea`
    ( `idea_code` );


