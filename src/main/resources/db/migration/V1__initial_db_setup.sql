create schema if not exists online_shop;

create table if not exists online_shop.brands
(
    id   bigserial primary key,
    name text
);

create unique index if not exists brand_name_ix on online_shop.brands (name);

alter table online_shop.brands
    owner to postgres;

create table if not exists online_shop.categories
(
    id   bigserial primary key,
    name text
);

create index if not exists category_name_ix on online_shop.categories (name);

alter table online_shop.categories
    owner to postgres;

create table if not exists online_shop.products
(
    id          bigserial primary key,
    name        text not null default '',
    price       numeric(15, 2) not null default 0,
    qty         double precision,
    image       text,
    description text,
    brand_id    bigint
    constraint products_brand_fk
    references online_shop.brands(id)
    on update cascade on delete set null,
    category_id bigint
    constraint products_category_fk
    references online_shop.categories(id)
    on update cascade on delete set null
);

create index if not exists product_name_ix on online_shop.products (name);
create index if not exists product_desc_ix on online_shop.products (description);
create index if not exists product_price_ix on online_shop.products (price);
create index if not exists product_brand_ix on online_shop.products (brand_id);
create index if not exists product_category_ix on online_shop.products (category_id);
create index if not exists product_name_brand_ix on online_shop.products (name, brand_id);

create index if not exists product_name_description_fulltext_ix on online_shop.products using gin(to_tsvector('english', name || ' ' || description));

alter table online_shop.products
    owner to postgres;