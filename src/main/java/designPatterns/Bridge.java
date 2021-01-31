package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 17:25
 * @Description: 桥接
 */
public class Bridge {
}

class GG{
    public void chase(MM mm){
        Gift g = new WarmGift(new Book()); //温暖的书
        give(mm, g);
    }
    public void give(MM mm, Gift gift){

    }
}
class MM{
    String name;
}

abstract class Gift{
    GiftImpl impl;
}
class WarmGift extends Gift{
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }
}
//聚合
class GiftImpl{}
class Book extends GiftImpl{
}