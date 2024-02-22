create table if not exists image_storage
(
    id varchar(250) primary key default gen_random_uuid(),
    name varchar(250)
);

