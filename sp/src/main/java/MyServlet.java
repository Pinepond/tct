import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.*;

public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("--------------------------------------------");
        int serverPort = req.getLocalPort();

        System.out.println("[GET] [ req.getRequestURL() : " + req.getRequestURL() + " ]");
        // PATH Parsing 처리
        String path = req.getServletPath().substring(1);
        String pathArr[] = path.split("/");
        String cmd = pathArr[0];

        // URL Query Param
        for (String key : req.getParameterMap().keySet()) {
            System.out.println("[GET] [ req.getParameter(" + key + ") : " + req.getParameter(key) + " ]");
        }

        // Header
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + " : " + req.getHeader(headerName));
        }
        System.out.println("--------------------------------------------");

        if ("GETHEADER".equals(cmd)) {
            System.out.println("req.getHeader(headerName) : " + req.getHeader("trace"));
            resp.setHeader("trace", req.getHeader("trace"));
//            writeResp(resp, jsonMap);
        } else if ("DLQ".equals(cmd)) {
//            writeResp(resp, jsonMap);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------------------------------------");
        int serverPort = req.getLocalPort();

        System.out.println("[POST] [ req.getRequestURL() : " + req.getRequestURL() + " ]");
        // PATH Parsing 처리
        String path = req.getServletPath().substring(1);
        String pathArr[] = path.split("/");
        String cmd = pathArr[0];

        // URL Query Param
        for (String key : req.getParameterMap().keySet()) {
            System.out.println("[POST] [ req.getParameter(" + key + ") : " + req.getParameter(key) + " ]");
        }

        // Header
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + " : " + req.getHeader(headerName));
        }

        // Set Map or Object from JSON parameter
        String jsonString = jsonParamToString(req);
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        // Map 으로 json 받기 - json 에 단순 String 인경우 Object 로 받지 않고 String 으로 받는게 편함
        Map<String, Object> jsonMap = gson.fromJson(jsonString, type);
        // Object 로  json 받기
        JsonInfo jsonInfo = gson.fromJson(jsonString, JsonInfo.class);

        System.out.println("--------------------------------------------");

        if ("SETHEADER".equals(cmd)) {

//            writeResp(resp, jsonMap);
        } else if ("SEND".equals(cmd)) {
//            writeResp(resp, jsonMap);
        } else if ("ACK".equals(cmd)) {
//            writeResp(resp, jsonMap);
        }
    }

    // 응답 json 샘플
    public static void writeResp(HttpServletResponse resp, Map<String, Object> resMap) throws IOException {
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(resMap));
        //resp.flushBuffer();
        resp.getWriter().flush();
    }

    public String jsonParamToString(HttpServletRequest req) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            sb.append(buffer.trim());
        }
        input.close();
        return sb.toString();
    }


    // http clinet request 샘플
    public static void httpClientSend() {
        String uuid = UUID.randomUUID().toString();
        HttpClient httpClient = new HttpClient();
        try {
            httpClient.start();
            ContentResponse contentRes =
                    httpClient.newRequest("http://127.0.0.1:8090/GETHEADER").method(HttpMethod.GET).header("trace", uuid).send();
            System.out.println("contentRes.getContentAsString() : " + contentRes.getHeaders());
            httpClient.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
