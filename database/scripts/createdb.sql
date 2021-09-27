SET search_path TO dictionaryrest;

CREATE SEQUENCE user_id_sequence;
CREATE SEQUENCE dictionary_id_sequence;
CREATE SEQUENCE record_id_sequence;

CREATE TABLE Users
(
	id INT NOT NULL DEFAULT nextval('user_id_sequence') PRIMARY KEY,
	name VARCHAR(50),
	password VARCHAR(50)
);
ALTER SEQUENCE user_id_sequence OWNED BY Users.id;

CREATE TABLE Dictionaries
(
	id INT NOT NULL DEFAULT nextval('dictionary_id_sequence') PRIMARY KEY,
	ownerId INT NULL,
	description VARCHAR(50)
);
ALTER SEQUENCE dictionary_id_sequence OWNED BY Dictionaries.id;

CREATE TABLE Records
(
	id INT NOT NULL DEFAULT nextval('record_id_sequence') PRIMARY KEY,
	dictionaryId INT NOT NULL,
	content VARCHAR(50)
);
ALTER SEQUENCE record_id_sequence OWNED BY Records.id;

ALTER TABLE Dictionaries
ADD CONSTRAINT fk_dictionaries
FOREIGN KEY (ownerId)
REFERENCES Users(id);

ALTER TABLE Records
ADD CONSTRAINT fk_records
FOREIGN KEY (dictionaryId)
REFERENCES Dictionaries(id);
-- DROP TABLE Users;
-- DROP TABLE Dictionaries;
-- DROP TABLE Records;
-- DROP SEQUENCE user_id_sequence;
-- DROP SEQUENCE dictionary_id_sequence;
-- DROP SEQUENCE record_id_sequence;
