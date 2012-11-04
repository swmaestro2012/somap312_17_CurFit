# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table look (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  look_count                integer,
  year                      integer,
  season                    integer,
  look_type                 integer,
  price                     integer,
  image_url                 varchar(255),
  constraint pk_look primary key (id))
;

create table user_look (
  id                        bigint auto_increment not null,
  look_id                   bigint,
  size                      integer,
  like_count                integer,
  image_url                 varchar(255),
  date                      timestamp,
  constraint pk_user_look primary key (id))
;

alter table user_look add constraint fk_user_look_look_1 foreign key (look_id) references look (id) on delete restrict on update restrict;
create index ix_user_look_look_1 on user_look (look_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists look;

drop table if exists user_look;

SET REFERENTIAL_INTEGRITY TRUE;

