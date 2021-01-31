package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 10:02
 * @Description: 策略者模式 自定义Comparator
 */
public class Strategy {

    public static void main(String[] args) {
        Dog[] arr = {new Dog(3),new Dog(5),new Dog(1)};
        new Sorter<Dog>().sort(arr, (o1, o2) -> o1.food - o2.food);
        for (Dog dog : arr)
            System.out.println(dog);
    }

}
class Sorter<T>{
    public void sort(T[] arr, Comparator<T> comparator){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = comparator.compareTo(arr[j],arr[minPos]) < 0 ? j : minPos;
            }
            swap(arr,i,minPos);
        }
    }

    private void swap(T[] arr, int i, int minPos) {
        T temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }

}

interface Comparator<T> {
    int compareTo(T o1, T o2);
}

class Dog{

    int food;

    public Dog(int food){ this.food = food;}

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

}