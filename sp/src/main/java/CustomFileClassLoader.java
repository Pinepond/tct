import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.ArrayList;

public class CustomFileClassLoader {

    public Class getClass(String classPath, String className) throws Exception{
        //ArrayList<Class> out = new ArrayList<Class>();

        ArrayList<URL> urls = new ArrayList<URL>();
        URLStreamHandler urlStHandler = null;
        File classPathFile = new File(classPath);

        System.out.println(classPathFile.getCanonicalPath());

        urls.add( new URL(null, "file:" + classPathFile.getCanonicalPath() + File.separator, urlStHandler));

        //jar형태 등으로 압축되어있는 class파일들을 읽으려면 위 urls.add부분을 주석처리하고 이 아래에 작성한다
        /*
        File[] files = classPathFile.listFiles();
        for(File f : files){
            //jar 인지 확인하는 과정 추가
            //urls.add
        }
        */

        URLClassLoader urlLoader = new URLClassLoader( (URL[])urls.toArray(new URL[urls.size()]));
//        for( String className : classNames){
//            Class clazz = urlLoader.loadClass(className);
//            out.add(clazz);
//        }
        return urlLoader.loadClass(className);
    }
}