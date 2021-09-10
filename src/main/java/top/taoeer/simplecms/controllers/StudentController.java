package top.taoeer.simplecms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.taoeer.simplecms.domain.Student;
import top.taoeer.simplecms.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public Student select(@PathVariable int id) {
        return studentService.selectOne(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable int id) {
        studentService.delete(id);
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.insert(student);
    }
}
