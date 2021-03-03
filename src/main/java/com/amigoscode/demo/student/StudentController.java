package com.amigoscode.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Student> getAllStudents () {
        //throw new ApiRequestException("oops Internal server error!");
       return studentService.getAllStudents();
    }

    @GetMapping(path="{studentId}/courses")
    public List<StudentCourse> getAllCoursesForStudent(
                    @PathVariable("studentId") UUID studentId) {
        return studentService.getAllCoursesForStudent(studentId);

    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student){
        studentService.addNewStudent(student);
    }
}
