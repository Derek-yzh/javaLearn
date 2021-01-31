package designPatterns;

import lombok.Data;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 17:37
 * @Description: 命令 动作 事务
 */
public class CommandDemo {
    public static void main(String[] args) {
        Content content = new Content();
        InsertCommand command = new InsertCommand(content);

        System.out.println(content);
        command.done();
        System.out.println(content);
        command.undone();
        System.out.println(content);
    }
}

abstract class Command {
    abstract void done();
    abstract void undone();
}

class InsertCommand extends Command{
    Content c;
    String strIoInsert = "insert";
    public InsertCommand(Content c) {
        this.c = c;
    }
    @Override
    void done() {
        c.msg = c.msg + strIoInsert;
    }
    @Override
    void undone() {
        c.msg = c.msg.substring(0,c.msg.length() - strIoInsert.length());
    }
}

@Data
class Content{
    String msg = "hello ";
}


