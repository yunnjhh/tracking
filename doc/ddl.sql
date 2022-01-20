create table contents
(
    id varchar(255) primary key, 
    name varchar(255) not null,
    description longtext default null,
    img_path varchar(255) default null,
    deleted bit not null,
    view_time timestamp default null, 
    registered_time timestamp not null, 
    modified_time timestamp default null
) comment '컨텐츠';
 
 -- 외래키 설정 확인 
create table category
(
    id varchar(255) primary key, 
    name varchar(255) not null,
    enabled bit not null,
    registered_time timestamp not null, 
    modified_time timestamp default null
) comment '분류';


create table category_contents
(
    category_id varchar(255) not null,
    contents_id varchar(255) not null,
    list_order int not null,
    primary key(category_id, contents_id),
    foreign key(category_id) references category(id),
    foreign key(contents_id) references contents(id)
) comment '카드 컨텐츠 매핑 정보';

create table sequence_book
(
    id bigint(20) primary key,
    type varchar(255) not null,
    sequence bigint(20) not null
) comment '채번 정보';

create table bookmark
(
    id varchar(255) primary key,
    contents_id varchar(255) not null,
    user_id varchar(255) not null,
    register_time timestamp not null
) comment '북마크';


-- 확인 쿼리  
select t.TABLE_NAME, t.TABLE_COMMENT
        , c.COLUMN_NAME, c.COLUMN_COMMENT, c.DATA_TYPE, c.CHARACTER_MAXIMUM_LENGTH, c.COLUMN_KEY, c.IS_NULLABLE
from information_schema.COLUMNS c , information_schema.TABLES t
where c.TABLE_SCHEMA = 'tracking'
    and t.TABLE_SCHEMA = 'tracking'
    and c.TABLE_NAME = t.TABLE_NAME
    and t.TABLE_NAME in
('sequence_book');


  
