package why;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 23:54
 * @Description: TODO
 */
public class ScoreFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getScore() > 75;
    }
}
