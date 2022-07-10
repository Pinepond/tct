public class MyThread extends Thread {
	String qName;
	int idx;
	boolean restore = true;

	public boolean isRestore() {
		return restore;
	}
	public void setRestore(boolean restore) {
		this.restore = restore;
	}
	public MyThread(String qName, int i) {
		this.qName = qName;
		this.idx = i ;
	}
	public void run(){
		

	}

	// Usage
	/*
	MyThread tempThread = new MyThread("qName",1);
    tempThread.start();
    tempThread.join();
        */
}
