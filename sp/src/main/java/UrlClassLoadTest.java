import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class UrlClassLoadTest {
    public static void main(String[] args) throws Exception {
//        System.out.println("testset");
//        CustomFileClassLoader cfcLoader = new CustomFileClassLoader();

        Class<?> clazz = SpUtil.loadClassFile("./sp/src/main/resources/extClass",
                "sample.test.ClassLoadingSample");

        Object obj = clazz.newInstance();

        Method addStrToList = SpUtil.getMethod(clazz,"addStrToList");
        Method printInfo = SpUtil.getMethod(clazz,"printInfo");

        addStrToList.invoke(obj, "won");
        printInfo.invoke(obj);

        addStrToList.invoke(obj, "song");
        printInfo.invoke(obj);

        addStrToList.invoke(obj, "yeon");
        printInfo.invoke(obj);
    }
}
//C:\Users\songy\IdeaProjects\tct\sp\src\main\resources\extClass\sample\test