package com.derich.Dao;

import com.derich.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
    //implement a private map for the students
    private static Map<Integer, Student> students;
    //Initialize the students in a static block
    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Derich", "Computer Science"));
                put(2, new Student(2, "Smith", "Science"));
                put(3, new Student(3, "Major", "Maths"));
            }
        };

    }

    //A method that returns the collection of students from the hashmap
    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }
    
    //Get student by Id
    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }
    //Update student
    @Override
    public void updateStudent(Student student){
        Student std = students.get(student.getId());
        std.setCourse(student.getCourse());
        std.setName(student.getName());
        students.put(student.getId(), student);

        // Or
        //students.put(student.getId(), student);

    }

    //Insert new student to data base
    @Override
    public void insertStudentToDb(Student student) {
        students.put(student.getId(), student);
    }
}
