package lambda;

import lombok.Data;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 23:51
 * @Description: TODO
 */
@Data
public class Student {

    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
