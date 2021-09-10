package top.taoeer.simplecms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.taoeer.simplecms.domain.Student;
import top.taoeer.simplecms.mapper.StudentMapper;
import top.taoeer.simplecms.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectOne(int id) {
        return studentMapper.selectOne(id);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(int id) {
        studentMapper.delete(id);
    }
}
