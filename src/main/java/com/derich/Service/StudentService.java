package com.derich.Service;

import com.derich.Dao.StudentDao;
import com.derich.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    //Initialize the studentDao so as to access it's methods.
    @Autowired
    @Qualifier("fakeData")
    private StudentDao studentDao;

    //A method that gets all the student in our fake database
    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    //Get student by Id
    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }

    public void deleteStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);

    }

    public void insertStudent(Student student) {
        studentDao.insertStudentToDb(student);
    }
}
