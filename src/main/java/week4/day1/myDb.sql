CREATE TABLE Teacher (
  TeacherID int,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  Age int,
  Salary DECIMAL
);
CREATE TABLE Student (
  StudentID int,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  Grade int,
  GPA DECIMAL
);
CREATE TABLE Class (
  ClassID int,
  Name VARCHAR(50),
  Description VARCHAR(50),
  TeacherID int
  );
CREATE TABLE ClassStudent (
  ClassStudentID int,
  ClassID int,
  StudentID int
);

INSERT INTO Teacher (TeacherID, FirstName, LastName, Age, Salary)
  VALUES (1,'Zoey', 'Zenon', 36, 75000);
INSERT INTO Teacher VALUES (2, 'Anna', 'Bobanna', 70, 69000.99);
INSERT INTO Teacher VALUES (3, 'Casper', 'deGhost', 170, 1.99);

INSERT INTO Class VALUES  (1, 'Math', 'Calculus', 1);
INSERT INTO Class VALUES  (2, 'Science', 'BioAlgorithms', 1);
INSERT INTO Class VALUES  (3, 'English', 'English Literature', 2);
INSERT INTO Class VALUES  (4, 'English', 'Composition', 2);
INSERT INTO Class VALUES  (5, 'Art', 'Classic', 3);
INSERT INTO Class VALUES  (6, 'Art', 'Modern', 4);

INSERT INTO Student VALUES  (1, 'Andy', 'McFly', 3.667, 3.5);
INSERT INTO Student VALUES  (2, 'Bob', 'Jones', 3.333, 3.1);
INSERT INTO Student VALUES  (3, 'Lisa', 'Marie', 2, 3.5);
INSERT INTO Student VALUES  (4, 'Carletta', 'Eastman', 4, 3.5);
INSERT INTO Student VALUES  (5, 'Travis', 'Coleman', 4, 3.5);
INSERT INTO Student VALUES  (6, 'Roberto', 'Samone', 3.333, 3.5);
INSERT INTO Student VALUES  (7, 'Rich', 'Boye', 2, 3.5);
INSERT INTO Student VALUES  (8, 'Debbie', 'Donning', 3.333, 3.5);
INSERT INTO Student VALUES  (9, 'Frank', 'Mirr', 1.667, 3.5);
INSERT INTO Student VALUES  (10, 'Petra', 'Zolanski', 3.677, 3.5);

INSERT INTO ClassStudent VALUES (1, 1, 1);
INSERT INTO ClassStudent VALUES (2, 5, 1);
INSERT INTO ClassStudent VALUES (3, 6, 1);
INSERT INTO ClassStudent VALUES (4, 2, 2);
INSERT INTO ClassStudent VALUES (5, 3, 2);
INSERT INTO ClassStudent VALUES (6, 4, 2);
INSERT INTO ClassStudent VALUES (7, 4, 3);
INSERT INTO ClassStudent VALUES (8, 1, 3);
INSERT INTO ClassStudent VALUES (9, 6, 3);
INSERT INTO ClassStudent VALUES (10, 1, 4);
INSERT INTO ClassStudent VALUES (11, 2, 4);
INSERT INTO ClassStudent VALUES (12, 5, 4);
INSERT INTO ClassStudent VALUES (13, 3, 5);
INSERT INTO ClassStudent VALUES (14, 5, 5);
INSERT INTO ClassStudent VALUES (15, 2, 5);
INSERT INTO ClassStudent VALUES (16, 6, 6);
INSERT INTO ClassStudent VALUES (17, 1, 6);
INSERT INTO ClassStudent VALUES (18, 4, 7);
INSERT INTO ClassStudent VALUES (19, 5, 7);
INSERT INTO ClassStudent VALUES (20, 1, 8);
INSERT INTO ClassStudent VALUES (21, 2, 8);
INSERT INTO ClassStudent VALUES (22, 4, 9);
INSERT INTO ClassStudent VALUES (23, 3, 9);
INSERT INTO ClassStudent VALUES (24, 5, 10);
INSERT INTO ClassStudent VALUES (25, 6, 10);

SELECT * FROM Teacher;
SELECT * FROM Class;
SELECT * FROM Student;
SELECT * FROM Class WHERE TeacherID = 1;
SELECT * FROM ClassStudent WHERE ClassID = 1;
SELECT * FROM ClassStudent WHERE StudentID = 1;
SELECT * FROM ClassStudent WHERE StudentID = 1;
SELECT * FROM Student WHERE FirstName = 'a%';

UPDATE Teacher SET FirstName = 'Jumbo', LastName = 'Jim' WHERE TeacherID = 1;
UPDATE Class SET Name = 'Bubble Blowing' WHERE ClassID = 1;
UPDATE Student SET FirstName = 'Saca', LastName = 'Tooya' WHERE StudentID=1;

DELETE FROM Student WHERE StudentID = 10;

SELECT Teacher.FirstName, Teacher.LastName, Class.Name
  FROM Teacher, Class
  WHERE Teacher.TeacherID = Class.TeacherID;