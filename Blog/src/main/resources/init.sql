CREATE TABLE post (
  id BIGINT NOT NULL PRIMARY KEY,
  title VARCHAR(512) NOT NULL,
  text TEXT NOT NULL,
  creationDate DATE
);

CREATE SEQUENCE post_seq;


CREATE TABLE "users" (
  id BIGINT NOT NULL PRIMARY KEY,
  username VARCHAR(24) NOT NULL,
  password VARCHAR(10) NOT NULL
);

CREATE SEQUENCE users_seq;



































