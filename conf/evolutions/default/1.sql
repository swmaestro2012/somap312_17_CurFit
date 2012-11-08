# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table look (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  shot_count                integer,
  year                      integer,
  season                    integer,
  look_type                 integer,
  price                     integer,
  image_url                 varchar(255),
  description               varchar(255),
  constraint pk_look primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  user_id                   varchar(255),
  password                  varchar(255),
  mail                      varchar(255),
  is_admin                  integer,
  constraint pk_user primary key (id))
;

create table user_look (
  id                        bigint auto_increment not null,
  look_id                   bigint,
  size                      integer,
  like_count                integer,
  image_url                 varchar(255),
  image_hash                varchar(255),
  date                      datetime,
  constraint pk_user_look primary key (id))
;

alter table user_look add constraint fk_user_look_look_1 foreign key (look_id) references look (id) on delete restrict on update restrict;
create index ix_user_look_look_1 on user_look (look_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table look;

drop table user;

drop table user_look;

SET FOREIGN_KEY_CHECKS=1;

