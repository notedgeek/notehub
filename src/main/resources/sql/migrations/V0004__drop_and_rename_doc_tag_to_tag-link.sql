drop table doc_tag;
create table tag_link (
    id bigint not null,
    doc_id bigint not null,
    tag_id bigint not null, primary key (id)
) engine=InnoDB;

alter table tag_link add constraint tag_link_fk_tag foreign key (tag_id) references tag (id);
alter table tag_link add constraint tag_link_fk_doc foreign key (doc_id) references doc (id);
