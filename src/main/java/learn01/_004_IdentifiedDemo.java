package learn01;

/**
 * @Author: Derek
 * @DateTime: 2021/1/18 21:20
 * @Description: TODO
 */
/*
标识符命名规范
	硬性规定：
		1、标识符必须以字母，下划线或者美元符号开头
		2、其他部分必须是字母，数字，下划线或者美元符号，但是不能出现特殊符号
		3、标识符大小写敏感
		4、不能是java的关键字或者保留字（留给系统使用的表示特殊含义的字符串）
	常规建议：
		1、驼峰标识
			1、类名，接口名称在命名的时候要首字符大写
			2、方法，变量命名的时候首字符要小写
			3、多个单词拼接表示一个标识符的时候，每个单词的首字符都大写
		2、见名知义
			通过标识符的名称能知道代表的含义
			千万不要写拼音
*/
public class _004_IdentifiedDemo{
    public static void main(String[] args){
        int _a = 10;
        int $b=20;
        //int a+b=30
        int a = 10;
        //int public = 20;
        int getValueById = 12;
    }
}
