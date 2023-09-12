use `expense-manager`;

CREATE TABLE `category_transaction` (
  `category_id` int NOT NULL,
  `transaction_id` int NOT NULL,
  
  PRIMARY KEY (`category_id`,`transaction_id`),
  
  KEY `FK_TRANSACTION_idx` (`transaction_id`),
  
  CONSTRAINT `FK_CATEGORY_05` FOREIGN KEY (`category_id`) 
  REFERENCES `category` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_TRANSACTION` FOREIGN KEY (`transaction_id`) 
  REFERENCES `transaction` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `type_transaction` (
  `type_id` int NOT NULL,
  `transaction_id` int NOT NULL,
  
  PRIMARY KEY (`type_id`,`transaction_id`),
  
  KEY `FK_TRANSACTION_idx` (`transaction_id`),
  
  CONSTRAINT `FK_TYPE_05` FOREIGN KEY (`type_id`) 
  REFERENCES `type` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_TRANSACTION_01` FOREIGN KEY (`transaction_id`) 
  REFERENCES `transaction` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;