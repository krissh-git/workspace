create table user(
id bigint(10) not null auto_increment,
username varchar(50) not null, 
password varchar(50) not null, 
salary int not null, 
age int not null,
primary key(id)
);


INSERT INTO user (id, username, password, salary, age) VALUES (1, 'test1', '$2a$04$b3416zAJnLpmRH5A2AKXjeOP6CY04eoMZV7n/4wb472IKMec/ct6e', 3456, 33);
INSERT INTO user (id, username, password, salary, age) VALUES (2, 'test2', '$2a$04$7e9cUabgAcVskcJXoj8TCuuqw6wkDhFq5n5nZjrm7HWxiu4uOBkjW', 7823, 23);





