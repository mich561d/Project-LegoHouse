-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema LegoHouseDatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LegoHouseDatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LegoHouseDatabase` DEFAULT CHARACTER SET utf8 ;
USE `LegoHouseDatabase` ;

-- -----------------------------------------------------
-- Table `LegoHouseDatabase`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LegoHouseDatabase`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LegoHouseDatabase`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LegoHouseDatabase`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `fours` INT NOT NULL,
  `twos` INT NOT NULL,
  `ones` INT NOT NULL,
  `shipped` VARCHAR(20) NOT NULL DEFAULT 'false',
  PRIMARY KEY (`id`),
  INDEX `user_has_order_FK_idx` (`user_id` ASC),
  CONSTRAINT `user_has_order_FK`
    FOREIGN KEY (`user_id`)
    REFERENCES `LegoHouseDatabase`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
