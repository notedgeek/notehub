create table doc_tag (
    doc_id bigint not null,
    tag_id bigint not null, primary key (doc_id, tag_id)
) engine=InnoDB;
create table tag (
    id bigint not null,
    value varchar(255),
    primary key (id)
) engine=InnoDB;

alter table doc_tag add constraint doc_tag_fk_tag foreign key (tag_id) references tag (id);
alter table doc_tag add constraint doc_tag_fk_doc foreign key (doc_id) references doc (id);
