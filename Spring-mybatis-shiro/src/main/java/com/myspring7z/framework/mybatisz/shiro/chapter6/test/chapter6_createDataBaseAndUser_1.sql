create database myspring7z;

use myspring7z;

create user 'springside'@'localhost' identified by 'springside';

grant all privileges on myspring7z.* to springside@localhost identified by 'springside';