## 외부 프로그램 호출
### 외부프로그램 호출 ( 단일호출 )
```java
try{
    Process p = Runtime.getRuntime().exec("notepad.exe example.txt  ");
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line = null;
    
    while((line = br.readLine()) != null){
        System.out.println(line);
    }
}catch(Exception e){
    System.out.println(e);
}
```
### 외부프로그램 호출 ( 대화형호출 )
```java
String line;
OutputStream stdin = null;
InputStream stderr = null;
InputStream stdout = null;

  // launch EXE and grab stdin/stdout and stderr
  Process process = Runtime.getRuntime ().exec ("/folder/exec.exe");
  stdin = process.getOutputStream ();
  stderr = process.getErrorStream ();
  stdout = process.getInputStream ();

  // "write" the parms into stdin
  line = "param1" + "\n";
  stdin.write(line.getBytes() );
  stdin.flush();

  line = "param2" + "\n";
  stdin.write(line.getBytes() );
  stdin.flush();

  line = "param3" + "\n";
  stdin.write(line.getBytes() );
  stdin.flush();

  stdin.close();

  // clean up if any output in stdout
  BufferedReader brCleanUp =
    new BufferedReader (new InputStreamReader (stdout));
  while ((line = brCleanUp.readLine ()) != null) {
    //System.out.println ("[Stdout] " + line);
  }
  brCleanUp.close();

  // clean up if any output in stderr
  brCleanUp =
    new BufferedReader (new InputStreamReader (stderr));
  while ((line = brCleanUp.readLine ()) != null) {
    //System.out.println ("[Stderr] " + line);
  }
  brCleanUp.close();
```