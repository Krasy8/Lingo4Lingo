CREATE TABLE IF NOT EXISTS roles (
    id BIGINT AUTO_INCREMENT primary key NOT NULL,
    name VARCHAR(45) CHARACTER SET UTF8MB4 NOT NULL

);

create table if not exists privileges (
    id bigint auto_increment primary key not null,
    name varchar(45) character set UTF8MB4 not null
);

create table if not exists users_roles (
  users_id bigint not null,
  roles_id bigint not null,
  foreign key (users_id) references users(id),
  foreign key (roles_id) references roles(id),
  unique (users_id, roles_id)
);

create table if not exists roles_privileges (
  roles_id bigint not null,
  privileges_id bigint not null,
  foreign key (roles_id) references roles(id),
  foreign key (privileges_id) references privileges(id),
  unique (roles_id, privileges_id)
);
