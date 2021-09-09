package top.taoeer.simplecms.domain;

import lombok.Data;

import java.util.List;

@Data
public class Clazz {
    private Integer id;
    private String code;
    private List<Student> students;
}
