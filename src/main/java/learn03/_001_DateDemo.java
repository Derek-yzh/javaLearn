package learn03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Derek
 * @DateTime: 2021/1/20 19:32
 * @Description: TODO
 */
public class _001_DateDemo {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); //毫秒值
        System.out.println("----------------------------------------");

        //时间格式类
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        System.out.println(dateFormat.parse("2010-10-10 20:20:20"));

        System.out.println("----------------------------------------");
        Calendar calendar = Calendar.getInstance();//获取的当前系统的时间
        calendar.setTime(date);
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));


    }

}
