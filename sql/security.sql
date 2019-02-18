CREATE TABLE "user"  (
  `u_id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `role`  (
  `r_id` varchar(255) NOT NULL,
  `role` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`)
);
CREATE TABLE `user_role`  (
  `ur_id` varchar(255) NOT NULL,
  `u_id` varchar(255) NOT NULL,
  `r_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
insert into user (u_id,username,password) values 
	(1,'admin','123456'),
	(2,'test','test');
insert into role (r_id,role) values 
	(1,'admin'),
	(2,'test');
insert into user_role (ur_id,u_id,r_id) values 
	(1,1,1),
	(2,2,2);