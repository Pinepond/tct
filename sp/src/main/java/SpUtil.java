
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class SpUtil {

	// thread sample
	// ExecutorService service = Executors.newFixedThreadPool(300);
	// service.execute(() -> {
	// });
	// service.submit(() -> {
	// return something;
	// });

	// file
	public static String fileToString(String path) throws IOException {
		return Files.lines(new File(path).toPath()).collect(Collectors.joining(System.lineSeparator()));
	}

	public static List<String> fileToStrings(String path) throws IOException {
		return Files.lines(new File(path).toPath()).collect(Collectors.toList());
	}

	public static void writeStringToFile(String path, String data) throws IOException {
		Files.write(new File(path).toPath(), data.getBytes());
	}

	// send http request
	public static ContentResponse sendHttpPostWithContent(String contentJson, String uri) {
		HttpClient httpClient = new HttpClient();
		ContentResponse contentRes = null;
		try {
			httpClient.start();
			contentRes = httpClient.newRequest(uri).method(HttpMethod.POST)
					.content(new StringContentProvider(contentJson)).send();
			httpClient.stop();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentRes;
	}

	public static ContentResponse sendHttpGet(String uri) {
		ContentResponse contentRes = null;
		HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			contentRes = httpClient.newRequest(uri).method(HttpMethod.GET).send();
			System.out.println("contentRes.getContentAsString() : " + contentRes.getContentAsString());
			httpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentRes;
	}

	// json
	public static String objectToJsonString(Object obj) throws JsonSyntaxException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		;
		return gson.toJson(obj);
	}

	public static <T> T jsonStringToObject(String json, Class<T> targetClazz) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		return gson.fromJson(json, targetClazz);
	}

	public static <T> T jsonFileToObject(String path, Class<T> targetClazz) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		// Gson gson = new GsonBuilder().setFieldNamingStrategy(f ->
		// f.getName().toUpperCase()).create();
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

	// execute new process
	public static void execProc(String batFileName, String... params) {
		String path = System.getProperty("user.dir");
		Process process = null;
		List<String> command = Arrays.asList(new String[] { "cmd.exe", "/C", path + File.separator + batFileName });
		command.addAll(Arrays.asList(params));
		ProcessBuilder builder = new ProcessBuilder(command);

		try {
			// 프로세스 빌더를 통하여 외부 프로그램 실행
			process = builder.start();
			// 외부 프로그램의 표준출력 상태 버퍼에 저장
			BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// 표준출력 상태를 출력
			String str = "";
			while ((str = stdOut.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// encrypt sha-256
	public static String encryptSHA256(String text) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
		}
		md.update(text.getBytes());

		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
	
	// get time diff
	public static long timeDiffSecs(long beforeTime, long afterTime) {
		if(afterTime == 0) {
			afterTime = System.currentTimeMillis();
		}
		return (afterTime - beforeTime) / 1000;
	}
	
	public static boolean isTimeDelayedOverSec(long beforeTime, long delayedSec) {
		long afterTime = System.currentTimeMillis();		
		long calc = (afterTime - beforeTime) / 1000;
		return calc > delayedSec ? true : false;
	}
}
