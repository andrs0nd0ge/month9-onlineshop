create table brands
(
    id   bigserial
        primary key,
    name varchar
);

alter table brands
    owner to postgres;

create table categories
(
    id   bigserial
        primary key,
    name varchar
);

alter table categories
    owner to postgres;

create table products
(
    id          bigserial
        primary key,
    name        varchar not null,
    price       numeric not null,
    qty         numeric,
    image       varchar,
    description varchar,
    brand_id    bigint
        constraint products_brand_fk
            references brands
            on update cascade on delete cascade,
    category_id bigint
        constraint products_category_fk
            references categories
            on update cascade on delete cascade
);

alter table products
    owner to postgres;