package why;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 23:52
 * @Description: 策略者模式
 */
public interface StudentFilter {
    boolean compare(Student student);
}
