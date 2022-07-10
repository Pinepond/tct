import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonInfo {
    public String color;
    public String value;

    public String testStr;
    public String[] testArr;
    public List<String> testList = new ArrayList<String>();


//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String[] getTest() {
//        return test;
//    }
//
//    public void setTest(String[] test) {
//        this.test = test;
//    }


    @Override
    public String toString() {
        return "JsonInfo{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                ", testStr='" + testStr + '\'' +
                ", testArr=" + Arrays.toString(testArr) +
                ", testList=" + testList +
                '}';
    }
}
