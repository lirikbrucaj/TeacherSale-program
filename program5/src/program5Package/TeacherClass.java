package program5Package;
import java.io.*;
import java.util.*;

public class TeacherClass
{


	
	        private  int [] quantity;
	        private  int [] sold;
		    private String[] name;
	        private int numOfClasses;
private int max;
	 public  TeacherClass ( int size)
		{      numOfClasses = size;
	           quantity = new int[size];
	           name = new String[size];
	           sold = new int[size];
	           for(int x = 0; x<size;x++)
	           {
	        	   sold[x]= 0;
	           }
	        }

		public void getData( ) throws IOException
		{
			Scanner input = new Scanner  (new FileReader("C:\\users\\lirik\\Documents\\eclispe\\cookies.txt"));
	        numOfClasses = input.nextInt ( );  
	        for(int i = 0; i < numOfClasses; i++)
			{
	        	name[i] = input.next();
				 quantity[i] = input.nextInt();	   
			} 
		}
		public void displayOutput() 
		 {
		   System.out.println( "The number of classes is "+numOfClasses);
		   System.out.println( "Teacher            Boxes");
		   for (int  i =0;i< numOfClasses; i++)
		   	System.out.println(name[i] + "        \t " + quantity[i]);
		 }
		public void update() throws IOException
		{   // reading the update from the keyboard
			int subscript, quantitySold, numberTransactions;
			String transaction;
			Scanner reader = new Scanner (new FileReader("C:\\Users\\lirik\\Documents\\eclispe\\update.txt"));  
			
			int	numberUpdates = reader.nextInt();

			while(reader.hasNext())
			{
				
				
				transaction = reader.next();
				quantitySold = reader.nextInt();
			 subscript = search( transaction);
			 if ( subscript >=0)
			 {
					quantity[subscript]= quantity[subscript]+ quantitySold;
					sold[subscript]= quantitySold;
			 }	
			 else
				System.out.println( transaction + " was never found");
			 
			}
			
			
		}
		public int search(String key)
		{
			boolean found= false;
			int i =0;
			while(!found&&i<numOfClasses)
			{
				if(name[i].equals(key))
					found=true;
				else
					i= i +1;
			}
			if (found==true)
				return i;
			else 
				return -1; 
		}
		public void findMax()
		{
			
			int max = 0;
			int x;
			for(x =0;x<sold.length;x++)
			
				if(sold[x]>max)
					max=x;
			
			System.out.println("the class that won is "+name[max]+", and they sold "+sold[max]+" boxes");

		}
		 public void sortByProfessor()
		   {  int i, j, minSubscript;
		    
		     // System.out.println( "i  j  minSubscript");
			  
		      for ( i = 0; i < numOfClasses -1; i++)
		      {
			    minSubscript = i;
		        for ( j = i; j<numOfClasses; j++)
		        {
		          if ( name[j].compareTo(name[minSubscript])<0)
		                minSubscript = j;

		       //   System.out.println( i + "  "  +  j + "  "  +  minSubscript);
		         // printList();
		        }
		        swap(i, minSubscript);
		      }
		   }
		   
		   public void swap( int first, int second)
		   {
			 String temp=name[first];
		     name[first] = name[second];
			 name[second] = temp;
			 int temp2= quantity[first];
		     quantity[first] = quantity[second];	    
		     quantity[second] = temp2;
		   }

		  public void printList ()
		  { 
			System.out.print ( "    " );
		    for ( int i = 0; i < numOfClasses; i++)
		      System.out.print ( i + "         " );
		    System.out.println();
		    System.out.print ("      " );
		    for ( int i = 0 ; i < numOfClasses; i ++)
		        System.out.print ( name[i] + "     ");
		    System.out.println();
		  } 
		  public void sortByHighestNumber()
		   {  int i, j, maxSubscript;
		    
		     // System.out.println( "i  j  minSubscript");
			  
		      for ( i = 0; i < numOfClasses -1; i++)
		      {
			    maxSubscript = i;
		        for ( j = i ; j<numOfClasses; j++)
		        {
		          if ( quantity[j]>quantity[maxSubscript])
		                maxSubscript = j;

		       //   System.out.println( i + "  "  +  j + "  "  +  minSubscript);
		       //   printList();
		        }
		        swap(i, maxSubscript);
		      }
		   }
		   
		}