package designPatterns;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 12:45
 * @Description: 责任链模式
 */
public class Responsibility {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好！< 我是996 >");

        FilterChain chain = new FilterChain();
        chain.add(new SensitiveFilter());

        FilterChain chain2 = new FilterChain();
        chain2.add(new HtmlFilter());

        chain.add(chain2); //两链联合
        chain.doFilter(msg);
        System.out.println(msg);
    }

}

@Data
class Msg{
    String name;
    String msg;
}

interface Filter{
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String m = msg.getMsg();
        m = m.replace('<','[');
        m = m.replace('>',']');
        msg.setMsg(m);
        return true;
    }
}

class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String m = msg.getMsg();
        m = m.replace("996","965");
        msg.setMsg(m);
        return false;
    }
}

@Data
class FilterChain implements Filter{
    private List<Filter> filters = new ArrayList<>();

    public boolean doFilter(Msg msg){
        for (Filter filter : filters)
            if (!filter.doFilter(msg)) return false;
        return true;
    }

    public Filter add(Filter filter) {
        filters.add(filter);
        return this;
    }
}