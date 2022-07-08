import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class UrlClassLoadTest {
    public static void main(String[] args) throws Exception {
        System.out.println("testset");
        CustomFileClassLoader cfcLoader = new CustomFileClassLoader();

        Class clazz = cfcLoader.getClass("./sp/src/main/resources/extClass",
                "sample.test.ClassLoadingSample");
        System.out.println("Class Name : " + clazz.getName());
        for(Field field : clazz.getDeclaredFields()){
            System.out.println("field Name : " + field.getName() + "    field Type : " + field.getType());
        }

        Object obj = clazz.newInstance();
        Method addStrToList = clazz.getDeclaredMethod("addStrToList",String.class);
        Method printInfo = clazz.getDeclaredMethod("printInfo");

        addStrToList.invoke(obj, "won");
        printInfo.invoke(obj);

        addStrToList.invoke(obj, "song");
        printInfo.invoke(obj);

        addStrToList.invoke(obj, "yeon");
        printInfo.invoke(obj);
    }
}
//C:\Users\songy\IdeaProjects\tct\sp\src\main\resources\extClass\sample\test