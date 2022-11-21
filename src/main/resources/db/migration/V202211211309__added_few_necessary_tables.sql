create table users
(
    id         bigserial
        primary key
        unique,
    email      varchar
        unique,
    password   varchar,
    first_name varchar(50),
    last_name  varchar(70)
);

create table baskets
(
    id bigserial
        primary key
        unique
);

create table orders
(
    id         bigserial
        primary key
        unique,
    product_id bigint
        constraint orders_products_id_fk
            references products
            on update cascade on delete cascade,
    user_id    bigint
        constraint orders_users_id_fk
            references users
            on update cascade on delete cascade
);

alter table orders
    add date date;

create table basket_products
(
    order_id  bigint not null
        constraint basket_products_orders_id_fk
            references orders
            on update cascade on delete cascade,
    basket_id bigint not null
        constraint basket_products_baskets_id_fk
            references baskets
            on update cascade on delete cascade
);

alter table basket_products
    add primary key (order_id, basket_id);

alter table basket_products
    rename column basket_id to product_id;

alter table basket_products
drop constraint basket_products_baskets_id_fk;

alter table basket_products
    add constraint basket_products_products_id_fk
        foreign key (product_id) references products
            on update cascade on delete cascade;
