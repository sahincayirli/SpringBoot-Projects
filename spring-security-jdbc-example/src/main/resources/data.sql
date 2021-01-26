insert into users (username, password,enabled) values ('sahin','sahin',true);
insert into users (username, password,enabled) values ('emre','emre',true);

insert into authorities (username, authority) values ('sahin','ROLE_USER');
insert into authorities (username, authority) values ('emre','ROLE_ADMIN');
