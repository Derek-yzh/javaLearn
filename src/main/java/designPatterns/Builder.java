package designPatterns;

import lombok.Data;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 16:48
 * @Description: 构造者
 */
public class Builder {

    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain terrain = builder.builderFort().builderMine().builderWall().builder();
        System.out.println(terrain);

        Person person = new Person.PersonBuilder()
                .id(1)
                .age(10)
                .weight(250.01)
                .build()
                .toBuilder()
                .name("aaa")
                .build();
        System.out.println(person);
    }


}
class Person{
    private int id;
    private String name;
    private int age;
    private double weight;
    Person(){}
    public PersonBuilder toBuilder(){
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public static class PersonBuilder{
        private Person p = new Person();
        public PersonBuilder basicInfo(int id, String name, int age, double weight){
            p.id = id;
            p.age = age;
            p.name = name;
            p.weight = weight;
            return this;
        }
        public PersonBuilder id(int id){
            p.id = id;
            return this;
        }
        public PersonBuilder name(String name){
            p.name = name;
            return this;
        }
        public PersonBuilder age(int age){
            p.age = age;
            return this;
        }
        public PersonBuilder weight(double weight){
            p.weight = weight;
            return this;
        }
        public Person build(){
            return p;
        }
    }
}



interface TerrainBuilder{
    TerrainBuilder builderWall();
    TerrainBuilder builderFort();
    TerrainBuilder builderMine();
    Terrain builder();
}

class ComplexTerrainBuilder implements TerrainBuilder{
    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder builderWall() {
        terrain.w = new Wall(10,10,50,50);
        return this;
    }

    @Override
    public TerrainBuilder builderFort() {
        terrain.f = new Fort(10,10,50,50);
        return this;
    }

    @Override
    public TerrainBuilder builderMine() {
        terrain.m = new Mine(10,10,50,50);
        return this;
    }

    @Override
    public Terrain builder() {
        return terrain;
    }
}

@Data
class Terrain {
    Wall w;
    Fort f;
    Mine m;
}
@Data
class Wall {
    int x, y, w, h;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
@Data
class Fort {
    int x, y, w, h;

    public Fort(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

}
@Data
class Mine {
    int x, y, w, h;

    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}