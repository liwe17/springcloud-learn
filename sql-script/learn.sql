DROP TABLE IF EXISTS payment;
CREATE TABLE payment (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  serial varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;
insert into payment(serial) values ('尚硅谷'),('alibaba'),('京东'),('头条');