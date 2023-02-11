
create table clothes_brand
(
    id       varchar(36) not null
        primary key,
    homepage varchar(255),
    name     varchar(255)
);

alter table clothes_brand
    owner to admin;

create table clothes_category
(
    id      varchar(36) not null
        primary key,
    name    varchar(255),
    session varchar(255)
);

alter table clothes_category
    owner to admin;

create table outfit_suggestions
(
    id          varchar(36)  not null
        primary key,
    clothes_ids varchar(255),
    name        varchar(255),
    occasion    varchar(255) not null,
    season      varchar(255) not null,
    wheather    varchar(255) not null
);

alter table outfit_suggestions
    owner to admin;

create table product
(
    id               varchar(36)  not null
        primary key,
    colors           varchar(255),
    description      varchar(255),
    image            varchar(255),
    name             varchar(255) not null,
    clothes_brand    varchar(36)
        constraint fk3vre6nbcq4q5jxiwop0xovuao
            references clothes_brand,
    clothes_category varchar(36)
        constraint fkhsaaj7ruoiwf53deyj3nwtiqd
            references clothes_category
);

alter table product
    owner to admin;

create table saved_outfits
(
    id          varchar(36)  not null
        primary key,
    clothes_ids varchar(255),
    name        varchar(255),
    occasion    varchar(255) not null,
    season      varchar(255) not null
);

alter table saved_outfits
    owner to admin;

