DROP USER if exists 'expense-manager'@'%' ;

-- Now create user with prop privileges
CREATE USER 'user'@'%' IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON * . * TO 'user'@'%';