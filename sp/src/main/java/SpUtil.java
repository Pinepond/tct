
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class spUtil {
	
	// file
	public static String fileToString(String path) throws IOException {
		return Files.lines(new File(path).toPath()).collect(Collectors.joining(System.lineSeparator()));
	}
	
	public static void writeStringToFile(String path, String data) throws IOException {
		Files.write(new File(path).toPath(), data.getBytes());
	}	
	
	
	//json
	public static String ObjectToJsonString(Object obj) throws JsonSyntaxException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		;
		return gson.toJson(obj);
	}

	public static <T> T StringToObject(String json, Class<T> targetClazz) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		return gson.fromJson(json, targetClazz);
	}

	public static <T> T jsonFileToObject(String path, Class<T> targetClazz) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		return gson.fromJson(fileToString(path), targetClazz);
	}
	
	// String

	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
	
	// sleep
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// random uuid
	public static String getRandomUUID() {
		return UUID.randomUUID().toString();
	}
	
	
	// class loading

	public static Class<?> loadClassFile(String classFilePath, String classNameWithPackgePath) throws Exception {

		ArrayList<URL> urls = new ArrayList<URL>();
		URLStreamHandler urlStHandler = null;
		File classPathFile = new File(classFilePath);

		System.out.println(classPathFile.getCanonicalPath());

		urls.add(new URL(null, "file:" + classPathFile.getCanonicalPath() + File.separator, urlStHandler));


		URLClassLoader urlLoader = new URLClassLoader((URL[]) urls.toArray(new URL[urls.size()]));

		return urlLoader.loadClass(classNameWithPackgePath);

	}

	public static Method getMethod(Class<?> clazz, String methodName) {
		return Arrays.stream(clazz.getMethods()).filter(c -> {
			return c.getName() == methodName;
		}).findFirst().get();
	}
}
