package com.derich.Dao;

import com.derich.Entity.Student;

import java.util.Collection;

public interface StudentDao {
    //A method that returns the collection of students from the hashmap
    Collection<Student> getAllStudents();

    //Get student by Id
    Student getStudentById(int id);

    void removeStudentById(int id);

    //Update student
    void updateStudent(Student student);

    //Insert new student to data base
    void insertStudentToDb(Student student);
}
