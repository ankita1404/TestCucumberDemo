/* Utility class for delaying program by 250 ms
 * 
 * @author Joseph Lalor
 * 
 */

package Unipupil.TestFramework.utilities;

public class ThreadSleep 
{
	String programClassName = "ThreadSleep";
	
	public ThreadSleep(){
		System.out.println(programClassName+" default constructor");
	}
	
	/*public ThreadSleep(int interval){
		System.out.println(programClassName+" constructor");

	}*/
	
	public static void sleep(){
		System.out.println("Running Threedsleep.sleep()");
		try{
		    Thread.sleep(250);
	    }
	    catch(InterruptedException ie){
		    ie.printStackTrace();
	    }
	}
	
	public static void sleep(int interval){
		try{
		    Thread.sleep(interval);
	    }
	    catch(InterruptedException ie){
		    ie.printStackTrace();
	    }
	}
	

}