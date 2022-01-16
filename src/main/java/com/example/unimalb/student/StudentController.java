package com.example.unimalb.student;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @ApiOperation(value = "Usered for returning all student from database")
    @GetMapping
    public List<Student> getStudents(){
        return  studentService.getStudents();
    }
    @ApiOperation(value = "Usered for inserting new student into database")
    @PostMapping
    public void  registerNewStudent(@RequestBody Student student){
            studentService.addNewStudent(student);
    }
    @ApiOperation(value = "For deleting student, by providing id eg 1,2 etc. but if provided id does not exist it throw error  ")
    @DeleteMapping(path= "{studentId}")
    public  void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }
//    @INFI-TECH CODE

    @ApiOperation(value = "For updating student, by providing id and followed by parameter eg email=yourname@domain.com etc. but if provided id does not exist it throw error and email already taken it throw error ")

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId, name, email);
    }
}
