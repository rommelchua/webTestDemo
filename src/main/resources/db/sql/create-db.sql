CREATE TABLE department (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30)
);

CREATE TABLE user (
  id INTEGER PRIMARY KEY auto_increment,
  name VARCHAR(30),
  email  VARCHAR(50),
  dep_id INTEGER,
  foreign key (dep_id) references department(id)
);