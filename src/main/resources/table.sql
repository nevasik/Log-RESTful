create table Log (
    id bigint generated by default as identity primary key,
    message text,
    type text,
    level text,
    time timestamp
);