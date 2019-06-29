--liquibase formatted sql
--changeset author:jderda context:development
INSERT INTO users (email,passwordHash,active,authority)
VALUES
('admin@admin','$2a$10$6VlU4SDwP9dT7sztn/t6IuM3hu8emZhI83zni1nNxB40bG3WMjAWK',1),
('outdated@outdated','$2a$10$M6epQOy9.E.dpb1jyH2CFODB7b8aBZRv3Cmq5b7Cf0YKOBPUgwhda',0);