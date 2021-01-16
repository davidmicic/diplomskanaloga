CREATE DATABASE diplomskanaloga;
CREATE USER admin with encrypted password 'admin';
GRANT ALL PRIVILEGES ON DATABASE diplomskanaloga TO admin;
ALTER ROLE admin  WITH SUPERUSER;