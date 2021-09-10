package top.taoeer.simplecms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.taoeer.simplecms.domain.Student;
import top.taoeer.simplecms.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student select(@PathVariable int id) {
        return studentService.selectOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void del(@PathVariable int id) {
        studentService.delete(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Student student) {
        studentService.insert(student);
    }
}
