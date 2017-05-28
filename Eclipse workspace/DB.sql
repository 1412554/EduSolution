create table user_account
(
user_name 			varchar(255)	not null,
password  			varchar(255) 	not null,
logical_thinking	int				not null,
detailed_thinking	int				not null,
speed_of_learning	int				not null,
communication		int				not null,
primary key (user_name)
);