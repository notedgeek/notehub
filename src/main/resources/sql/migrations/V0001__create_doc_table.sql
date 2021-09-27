create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table doc (
    id bigint not null,
    markdown longtext,
    html longtext,
    date_created datetime(6),
    date_updated datetime(6),
    primary key (id)
) engine=InnoDB;
