insert into vendor
    (name, created_date, modified_date)
values
    ('cisco', now(), now());
insert into vendor
    (name, created_date, modified_date)
values
    ('juniper', now(), now());

insert into location
    (name, created_date, modified_date)
values
    ('TCC1', now(), now());

insert into kind
    (name, created_date, modified_date)
values
    ('switch', now(), now());

insert into model
    (name, kind_id, location_id, vendor_id, count, created_date, modified_date)
values
    ('model1', 1, 1, 1, 0, now(), now());

-- SELECT 
--     m.*,
--     k.name kind_name,
--     l.name location_name,
--     v.name vendor_name
-- FROM
--     model m
--         LEFT JOIN
--     kind k ON m.kind_id = k.id
--         LEFT JOIN
--     location l ON m.location_id = l.id
--         LEFT JOIN
--     vendor v ON m.vendor_id = v.id;