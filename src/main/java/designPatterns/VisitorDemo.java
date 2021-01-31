package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 16:09
 * @Description: 访问者
 *
 *  访问结构固定的类 （ComputerPart）
 */
public class VisitorDemo {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        PersonalVisitor p = new PersonalVisitor();
        new VisitorDemo().accept(p);
        System.out.println(p.totalPrice);
    }
}

abstract class ComputerPart {
    abstract void accept(Visitor v);
    //some other operations eg:getName getBrand
    abstract double getPrice();
}

class CPU extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }
    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }
    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }
    @Override
    double getPrice() {
        return 200;
    }
}



interface Visitor {
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}

class PersonalVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.85;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.95;
    }
}

class CorpVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice()*0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.75;
    }
}
