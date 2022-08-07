create schema ekzam_2;

create table ekzam_2."news"
(
    id serial not null unique,
    name_news varchar(50) not null,
    text_news varchar not null,
    publication_time timestamp not null
)