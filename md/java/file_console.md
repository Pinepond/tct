## Console 입력
```java
Scanner scan = new Scanner(System.in);
String input = scan.nextLine();
```

## File 읽기
```java
 BufferedReader in = new BufferedReader(new FileReader("filePath"));
 String str;

 while ((str = in.readLine()) != null) {
 	String words[] = str.split(" ");
 	
 }
 in.close();
```
## File 쓰기
```java
BufferedWriter out = new BufferedWriter(new FileWriter("filePath"));
out.write("data");
out.close();
```
## File 복사
```java
static void CopyFile(String inputFile, String outputFile) {
	final int BUFFER_SIZE = 4096;
	int readLen;
	try {
		InputStream inputStream = new FileInputStream(inputFile);
		OutputStream outputStream = new FileOutputStream(outputFile);
		byte[] buffer = new byte[BUFFER_SIZE];
		while ((readLen = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, readLen);
		}
		inputStream.close();
		outputStream.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
}
```
## 파일 이동
```java
private void moveFileToBackup(String path, String name) {
		File fileFrom = new File(path); // source
		File fileTo = new File("..//BACKUP//" + name); // destination
		fileTo.delete();
		fileFrom.renameTo(fileTo);
	}
```
## 폴더 생성
```java
static void CreateDir(String dirPath) {
	File destFolder = new File(dirPath);
	if (!destFolder.exists()) {
		destFolder.mkdirs();
	}
}
```

## 폴더 탐색 (하위 전체 재귀)
```java
static void FileDirList(String dirPath) {
    File directory = new File(dirPath);
    File[] fList = directory.listFiles();
    try {
        for (File file : fList) {
            if (file.isDirectory()) {
                // System.out.println("[" + file.getName() + "]");
                    FileDirList(file.getCanonicalPath());
                } else {
                System.out.println(file.getPath()+" "+file.getName() + ": " + file.length() + " bytes");
            }
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
```