package program5Package;
import java.io.*;
public class TeacherClassDemo
{

	public static void main(String[] args) throws IOException 
	{	
		 	TeacherClass  PaceInventory = new TeacherClass(25);
		  	PaceInventory.getData();
		  	PaceInventory.displayOutput();
		  	PaceInventory.update();
		  	PaceInventory.displayOutput();
		  	PaceInventory.findMax();
		  	PaceInventory.sortByProfessor();
		  	PaceInventory.displayOutput();
		 	PaceInventory.sortByHighestNumber();
		  	PaceInventory.displayOutput();


		  

	}
	

}
