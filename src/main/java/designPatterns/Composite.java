package designPatterns;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 14:07
 * @Description: 组合
 */
public class Composite {

    public static void main(String[] args) {
        DirNode dirA = new DirNode("目录A");
        dirA.add(new FileNode("A_111"))
                .add(new DirNode("目录B").add(new FileNode("B_111")))
                .add(new FileNode("A_222"));
        DirNode.print(dirA, 0);
    }

}

//一个节点
interface Node{
    String p();
}

@Data
class FileNode implements Node{
    String content;
    @Override
    public String p() {
        return content;
    }

    public FileNode(String content) {
        this.content = content;
    }
}
@Data
class DirNode implements Node{
    List<Node> nodes = new ArrayList<>();
    String dirName;
    @Override
    public String p() {
        return dirName;
    }

    public DirNode(String dirName) {
        this.dirName = dirName;
    }

    public DirNode add(Node node){
        nodes.add(node);
        return this;
    }

    static public void print(Node b, int depth){
        for (int i = 0; i < depth; i++) System.out.print("\t");
        System.out.println(b.p());
        if (b instanceof DirNode){
            for (Node n : ((DirNode) b).nodes) {
                print(n, depth + 1);
            }
        }
    }
}
