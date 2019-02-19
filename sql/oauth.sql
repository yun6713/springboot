CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(255) NOT NULL,
  `token` blob NULL,
  `authentication` blob NULL,
  PRIMARY KEY (`token_id`)
);
CREATE TABLE `oauth_role`  (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
);
CREATE TABLE `oauth_token`  (
  `token_id` varchar(255) NOT NULL,
  `token` blob NULL,
  `authentication_id` varchar(255) NULL DEFAULT NULL,
  `username` varchar(255) NULL DEFAULT NULL,
  `client_id` varchar(255) NULL DEFAULT NULL,
  `authentication` blob NULL,
  `refresh)token` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`token_id`)
);
CREATE TABLE `oauth_user`  (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NULL DEFAULT NULL,
  `email` varchar(255) NULL DEFAULT NULL,
  `activated` tinyint(1) NULL DEFAULT NULL,
  `activationkey` varchar(255) NULL DEFAULT NULL,
  `resetpasswordkey` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`username`)
);
CREATE TABLE `oauth_user_authority`  (
  `username` varchar(255) NOT NULL,
  `authority` varchar(255) NULL DEFAULT NULL
);
