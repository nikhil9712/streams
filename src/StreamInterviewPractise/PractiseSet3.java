package StreamInterviewPractise;

 class Demo implements Runnable{

	
	static int fromNumber=1;
	int toNumber=20;	
	
	@Override
	public void run() {
		synchronized (this) {
			while (fromNumber<=toNumber) {
				System.out.println(Thread.currentThread()+"Printing Number "+fromNumber);
				fromNumber++;
			}
		}
	}

}

 public class PractiseSet3{
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		Thread t1=new Thread(new Demo(),"Thread1");
		Thread t2=new Thread(new Demo(),"Thread2");
		Thread t3=new Thread(new Demo(),"Thread3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
