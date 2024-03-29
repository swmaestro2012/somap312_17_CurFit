# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coupon (
  id                        bigint auto_increment not null,
  user_look_hash            varchar(255),
  price                     integer,
  expire_date               datetime,
  used                      tinyint(1) default 0,
  constraint pk_coupon primary key (id))
;

create table look (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  shot_count                integer,
  year                      integer,
  season                    integer,
  look_type                 integer,
  price                     integer,
  barcode                   varchar(255),
  image_file_name           varchar(255),
  image_to_s3               tinyint(1) default 0,
  description               varchar(255),
  constraint pk_look primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  user_id                   varchar(255),
  name                      varchar(255),
  password                  varchar(255),
  mail                      varchar(255),
  membership_id             varchar(255),
  admin                     tinyint(1) default 0,
  constraint pk_user primary key (id))
;

create table user_look (
  id                        bigint auto_increment not null,
  look_id                   bigint,
  user_id                   bigint,
  size                      integer,
  like_count                integer,
  image_file_name           varchar(255),
  date                      datetime,
  image_to_s3               tinyint(1) default 0,
  match_user_look_id        bigint,
  constraint pk_user_look primary key (id))
;

alter table user_look add constraint fk_user_look_look_1 foreign key (look_id) references look (id) on delete restrict on update restrict;
create index ix_user_look_look_1 on user_look (look_id);
alter table user_look add constraint fk_user_look_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_user_look_user_2 on user_look (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table coupon;

drop table look;

drop table user;

drop table user_look;

SET FOREIGN_KEY_CHECKS=1;

