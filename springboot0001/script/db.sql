CREATE TABLE t_user
(
    id INT NOT NULL,
    name VARCHAR(30) NULL DEFAULT NULL,
    age INT NULL DEFAULT NULL,
    email VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

insert into t_user (id,name,age,email) values
(1,'penruins',23,'lx_tdcq_king@icloud.com');


CREATE TABLE t_user2
(
    id INT NOT NULL,
    name VARCHAR(30) NULL DEFAULT NULL,
    age INT NULL DEFAULT NULL,
    email VARCHAR(50) NULL DEFAULT NULL,
    create_time timestamp NULL DEFAULT NULL,
    update_time timestamp NULL DEFAULT NULL,
    PRIMARY KEY (id)
);
