package top.taoeer.simplecms.services;

import top.taoeer.simplecms.domain.Student;

public interface StudentService {
    Student selectOne(int id);
    void insert(Student student);
    void delete(int id);
}
