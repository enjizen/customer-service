CREATE TABLE client (
  client_id VARCHAR(255) NOT NULL,
  client_secret VARCHAR(255) NOT NULL,
  client_name VARCHAR(100) NOT NULL,
  is_deleted TINYINT(1) NOT NULL,
  is_suspended TINYINT(1) NOT NULL,
  PRIMARY KEY (client_id),
  UNIQUE KEY client_id_client_secret (client_id,client_secret)
  );