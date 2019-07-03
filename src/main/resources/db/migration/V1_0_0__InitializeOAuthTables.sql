create table if not exists table_one (
  id numeric,
  name  varchar(50),
  constraint pk_table_one primary key (id)
);

insert into table_one(id, name)
values (1, 'Olek')