CREATE DATABASE  IF NOT EXISTS `vversity` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vversity`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: vversity
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL DEFAULT 'Bangladesh',
  `district` varchar(45) NOT NULL,
  `thana` varchar(45) NOT NULL,
  `mahalla` varchar(45) DEFAULT NULL,
  `road` varchar(45) DEFAULT NULL,
  `house` varchar(45) DEFAULT NULL,
  `flat_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'asdsd','asdsd','adsdas','dasdasd','asdsad','asdsd','sadas'),(2,'fsdf','sdfsdf','sdfsdf','sdfsdf','sdfsd','fsdfsdfs','sdfsdf'),(3,'sadasd','asdasd','sadsd','sadsad','asdasd','asdsadas','asdsa'),(6,'sdas','sds','dsd','sds','dsds','dsdasd','asdsd'),(9,'as','asa','as','ss','asas','dsdad','asdas'),(10,'sdf','dfdf','dfdf','dfdf','dfdg','hh','ghfghfg'),(11,'asdsd','asdsd','sds','dasdsds','dasdsad','asdas','dasdd'),(12,'Bangladesh','Dhaka','Hazaribagh','Azimpur','Pilkhana','64','D');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` varchar(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_details`
--

DROP TABLE IF EXISTS `course_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_details` (
  `sl_no` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(45) DEFAULT NULL,
  `week_no` varchar(45) DEFAULT NULL,
  `lecture_no` varchar(45) DEFAULT NULL,
  `vedio` varchar(45) DEFAULT NULL,
  `document` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sl_no`),
  KEY `course_details_courses_fk_idx` (`course_id`),
  CONSTRAINT `course_details_courses_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_details`
--

LOCK TABLES `course_details` WRITE;
/*!40000 ALTER TABLE `course_details` DISABLE KEYS */;
INSERT INTO `course_details` VALUES (1,'j1','1','1','j111.mp4','j111.docx'),(2,'css1','01','01','css10101.mp4','css10101.vsd'),(3,'or1','01','01','or10101.mp4','or10101.vsd');
/*!40000 ALTER TABLE `course_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_enroll`
--

DROP TABLE IF EXISTS `course_enroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_enroll` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(10) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `join_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_idx` (`course_id`),
  KEY `student_idx` (`student_id`),
  CONSTRAINT `course_enroled_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_enroled_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_enroll`
--

LOCK TABLES `course_enroll` WRITE;
/*!40000 ALTER TABLE `course_enroll` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_enroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `course_id` varchar(10) NOT NULL,
  `course_name` varchar(45) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `teacher_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `teacher_idx` (`teacher_id`),
  CONSTRAINT `teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('css1','css','2016-08-16','2016-08-31','t01'),('j1','j2ee','2016-08-01','2016-08-31','s1'),('n1','Networking','2016-08-01','2016-08-31','t05'),('or1','Oracle','2016-08-31','2016-09-30','t01');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mcq`
--

DROP TABLE IF EXISTS `mcq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mcq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(45) DEFAULT NULL,
  `q_no` int(11) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `opt_a` varchar(45) DEFAULT NULL,
  `opt_b` varchar(45) DEFAULT NULL,
  `opt_c` varchar(45) DEFAULT NULL,
  `opt_d` varchar(45) DEFAULT NULL,
  `answer` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mcq`
--

LOCK TABLES `mcq` WRITE;
/*!40000 ALTER TABLE `mcq` DISABLE KEYS */;
INSERT INTO `mcq` VALUES (1,'j1',1,'what kind of component Spring is?',' Lightweight','Heavyweight','None of one','Simplified ','a'),(2,'j1',2,'Spring’s data access module provides out-of-the-box support for ','JDBC','JDO','Hibernate','Above all','d'),(3,'j1',3,'What is spring?','database ','framework ','component ','java class ','b');
/*!40000 ALTER TABLE `mcq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password` (
  `id` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `security_ques` varchar(100) NOT NULL,
  `answer` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `sl_no` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(20) NOT NULL,
  `course_id` varchar(45) NOT NULL,
  `week` int(11) NOT NULL,
  `assignment` int(10) DEFAULT NULL,
  `exam` int(10) DEFAULT NULL,
  PRIMARY KEY (`sl_no`),
  KEY `student_result_fk_idx` (`student_id`),
  KEY `course_result_fk_idx` (`course_id`),
  CONSTRAINT `course_result_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_result_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,'s01','j1',1,95,66),(2,'s01','j1',1,95,66),(3,'s01','j1',1,95,100),(4,'s01','j1',1,95,100),(5,'s01','j1',1,95,100),(6,'s01','j1',1,95,100),(7,'s01','j1',1,95,100);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` varchar(20) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `image` varchar(100) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `std_id_UNIQUE` (`student_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `image_UNIQUE` (`image`),
  KEY `std_address_fk_idx` (`address_id`),
  CONSTRAINT `std_address_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('s01','asd','sadasd','2016-08-01',20,'male','dasdasd','asdsa','s09.jpg',11),('s102','sdsd','sdsd','2016-07-04',20,'male','sds102','sds102','s102.png',10);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacher_id` varchar(20) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `specialization` varchar(45) NOT NULL,
  `image` varchar(100) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `teacher_address_fk_idx` (`address_id`),
  CONSTRAINT `teacher_address_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('s1','asdsd','asddsad','2016-07-12',20,'male','asdsd','01912','asdsdsd','asdsd',1),('s2','asdasd','asdasd','2016-07-14',30,'male','ssefsdf','sdfsdfs','sdfsdfs','dfsdfsd',2),('t01','Hafiz','Rahman','2016-08-08',25,'male','shabuz@gmail.com','01912016260','j2ee, java script, css','t01.JPG',12),('t05','asd','sddas','2016-07-06',30,'male','sd','sdsd','sdsadasd','sdsd.jpg',6),('t232','dfdf','dfsdf','2016-07-12',20,'male','sasds0326','sasdsa9856','asdads','t232.JPG',9);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'s2','a','teacher'),(2,'s1','a','student'),(3,'t05','a','teacher'),(4,'t232','a','teacher'),(5,'s102','a','student'),(6,'s01','a','student'),(7,'t01','a','teacher');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'vversity'
--

--
-- Dumping routines for database 'vversity'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-11 12:06:35
