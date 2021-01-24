package lambda;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 23:53
 * @Description: TODO
 */
public class AgeFilter implements StudentFilter{

    @Override
    public boolean compare(Student student){
        return student.getAge() > 14;
    }

}
