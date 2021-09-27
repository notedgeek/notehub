drop table doc_tag;
create table doc_tag (
    id bigint not null,
    doc_id bigint not null,
    tag_id bigint not null, primary key (id)
) engine=InnoDB;

alter table doc_tag add constraint doc_tag_fk_tag foreign key (tag_id) references tag (id);
alter table doc_tag add constraint doc_tag_fk_doc foreign key (doc_id) references doc (id);
