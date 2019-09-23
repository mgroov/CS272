//Matthew Groover
//cs 272
//08/10/19
package cs272program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeSet {
 Employee emphold[] = new Employee[0];   // declaration of the set class and the variables 
 public int capacity=0;
 int employees = 0;
 
  

 //===========================<Main>====================================================================================================================================
 public static void main(String[] args) {
	EmployeeSet o1 = new EmployeeSet();                                    //calls the empty constructor
	 o1.read("core_dataset.csv");                                        // calls the read function
    for(int i=0;i<o1.employees;i++) {
	 System.out.println(o1.emphold[i].toString());                      //checks that the employees are unique and the employee count 
    }
    System.out.println(" "+ o1.size()+" "+o1.capacity());                   // tests the get for capacity and initialized employees
    EmployeeSet o2 = new EmployeeSet(o1);
    
    for(int i=0;i<o2.employees;i++) {
   	 System.out.println(o2.emphold[i].toString());                       //checks that the copy constructor for EmployeeSet works
       }
    Employee test = new Employee(o2.emphold[20]);
    test.no=1;//
    o1.addOrdered(test);                                                   //tests the add ordered function and removal
    System.out.println(""+o1.rem(test.no));                                //prints reult of true to show removed item
    
                                                                          //A quick note contains is not tested here because it is tested in the add function
    
 }//of main
 //=================================================Empty Constructor==============================================================================================
 EmployeeSet(){
	 capacity = 10;
	 employees =0;
	 emphold = new Employee[capacity];
 }//of no parameter constructor
 
 //=====================================EmployeeSet Copy Constructor===============================================================================================
	
	EmployeeSet(Object obj) {
		if(obj != null && obj instanceof EmployeeSet) {
			EmployeeSet old = (EmployeeSet)obj;
			this.emphold = new Employee[old.capacity];     // checks if not null and if instance of then 
			for(int i=0;i<old.capacity;i++) {              // Initializes the new object based on the values of the old
				if(old.emphold[i]!= null) {                
					this.emphold[i]=new Employee(old.emphold[i]);
				}//of not null check
			}//of for copy loop
			
			this.employees = old.employees;
			this.capacity = old.capacity;
		}//of null and instance check
	}//of object constructor
 //===================================== size =================================================================================================================	
	public int size() {
		return(employees);//returns the amount of actual instanced objects with values
	}//of size get 
 //===================================capacity============================================================================================================
	public int capacity() {
		
		return(capacity); // returns capacity/length of the array
	}//of capacity get
 //========================================<Add>================================================================================================================
	public void add(Employee a) {
		if(a != null) {
			if(contains(a)) {
				
			}//runs nothing if the set contains the passed object                            //The method checks if the set has the object first
		                                                                                     // if it does it doesn't run anything 
			else  {                                                                          //If it doesn't it checks that the set has enough room
				EnsureCapacity(employees+1);                                                 // then using a copy constructor it goes to the next 
				   emphold[employees]= new Employee(a);                                     // open space then adds it to the set and then increments 
		      		employees++;                                                            // the size variable
					                                                                        //if the object passed is null it will throw an exception
				}// checking till null
		}//of null check
		else {
			throw new IllegalArgumentException("Cannot add this object Initialized as Null!! \n");
		}// if object is null
	}//of add employee to set method
 //=====================================contains==========================================================================================================
	public boolean contains(Employee a) {
		boolean z;
		if(employees !=0) {                                                      //if the employee count equals zero it doesn't need to check after 0 it
		for(int i=0;i<employees-1;i++) {                                         //runs through array using for loop and  a comparison
			if(emphold[i].no==a.no) {                                            // against every object  in the set 
		     	z=true;  
		     	//System.out.println(emphold[i].no +" "+a.no);//test statement
		     	                                                                // to verify that it doesn't already exist will return true 
				return z;                                                       //f it does false if it doesn't
			}//of equals check
		}//of for loop run through
		}//if employees ==0 it cant check against anything
		z=false;
		return z;
		
		
	}//of contains method
	
 //=================================rem or remove===================================================================================================	
	public boolean rem(int eno) {
		//System.out.println("hi");
		if(eno != 0) {
			for(int y=0;y<employees;y++) {
				System.out.println("hi"+emphold[y].toString());
				if(eno==this.emphold[y].no) {                   // runs through the set as long as the 
					emphold[y]=new Employee(emphold[employees]);
					employees--;                            // object wasn't initiated as null
					return true;                           // then checks against the employee no in the set
				}//of equals check                         // returns true and replaces the object if it finds a match
			}//of for loop iteration                       // returns false and does nothing if null or doesn't find a match
			   
			return false; //if its not null but also not in the array
		}//of not null check
		return false;
	}//of employee remove method
 //==============================Ensure Capacity======================================================================================================
	public void EnsureCapacity(int mincapacity){
		if(mincapacity>0) {
			capacity= emphold.length;
		if(capacity<=mincapacity) {   
		                                                                     // first checks if the requested value is positive or > 0
			Employee[] newdata = new Employee[emphold.length*2];             //then checks to see if the current capacity is equal or lesser to the requested 
			System.arraycopy(emphold, 0, newdata, 0, emphold.length);  
			emphold=newdata;                                                 // if it is then sets the old array to twice the size by storing 
			capacity= capacity*2;                                            // into then copying into an array twice its size
		}//of capacity v min check                                           //I found the System.arraycopy and emp=new
		}//of positive check                                                 //in your lecture notes online
	}//of ensure capacity
 //============================================================Add ordered ==================================================================================	
	public void addOrdered(Employee a) {
		int y=0;
		if(a != null) {
			EnsureCapacity(employees+3);
			for(int i=0;i<employees-1;i++) {
				if(a.no<this.emphold[i].no) {
					int pos=i;
					if(pos==0) {
						Employee[] temp = new Employee[capacity+4];
						System.arraycopy(emphold, 0, temp, 1,capacity);                     // first checks that the object isn't null
						temp[0]=new Employee(a);                                            //then using a for loop checks for where the new object  
						emphold=temp;                                                       // should go. If the object needs to go to position zero
						                                                                    // It uses array copy to move all objects one position forward
						}//if pos is zero                                                   //in a temp array. then adds the object in pos 0
					else {                                                                  //if its not zero then it cuts the old up to the new object
						Employee[] temp = new Employee[emphold.length+2];                   // adds the object then adds the rest back after
						System.arraycopy(emphold, 0, temp, 0, pos);                         // If the Object is not < than any other it is put in the 
						temp[i]=new Employee(a);                                            //last position of the set 
						System.arraycopy(emphold, pos, temp, pos, capacity);
						emphold=temp;  
						y++;
						}//of if pos is anyhting else but zero
					}//if the number is smaller check
				else if(emphold[i]==null){
					emphold[i]=new Employee(a);
					employees+=1;
				}//if not smaller
			}//of run through for loop
		}//of null check
	}//of add employee by order
 //========================================================READ============================================================================================================
	  public void read(String s)  {
		   System.out.println("hi");
		
		String temp = "";                                                 // this is a version of the read function from lab1
		String first="";                                                  // It parses out the information via string manipulation
		int y =0;                                                         // it then stores that information into temp variables
		int commap =0;                                                    // it then puts that information into a temporary object 
		int count=0;                                                     //	 it then adds that object to the set 	                                                                
		int notemp=0;                                                    // if it cannot find or read the file then it throws exceptions
		String nametemp="";                                              // the read ends when it finds the eof marks aka a comma line then null 
		String tempstate="";
		int tempzip=0;
		int tempage=0;
		
		try {
			FileReader filereader = new FileReader(s);
			BufferedReader br = new BufferedReader(filereader);
			
			while((temp=br.readLine()) != null) {
				Employee tempe = new Employee();
			
				if(temp.charAt(0)!=',') {
				if(y==0) {
		      first=temp;
		      temp = br.readLine();
				}
				y++;
			
		      
		      //System.out.println(temp.length());
		      commap = temp.indexOf(',');
		      if(commap==13) {
		    	  commap= temp.indexOf(' ');
		    	  nametemp=temp.substring(0,commap);
		    	  temp = temp.substring(commap,temp.length());
		    	  commap = temp.indexOf(',');
		    	  nametemp = nametemp + temp.substring(0,commap); 
		    	  temp = temp.substring(commap+1,temp.length());
		      }
		      else {
		     // System.out.println(commap);
		    	  nametemp = temp.substring(0,commap);
		      temp = temp.substring(commap+1,temp.length());
		      commap = temp.indexOf(',');
		      nametemp = nametemp + temp.substring(0,commap);          
		      temp = temp.substring(commap+1,temp.length());
		      }
		      
		      
		     // System.out.println(temp);
		      
		      commap = temp.indexOf(',');
		      notemp =Integer.parseInt(temp.substring(0,commap));
		      temp = temp.substring(commap+1,temp.length());
		      
		   //   System.out.println(employees[count].Number);
		      
		      commap = temp.indexOf(',');
		     tempstate = temp.substring(0,commap);
		      temp = temp.substring(commap+1,temp.length());
		      
		      
		      
		      commap = temp.indexOf(',');
		      String ziptemp = temp.substring(0,commap);
		      tempzip = Integer.parseInt(ziptemp.trim());
		      temp = temp.substring(commap+1,temp.length());
		 
		   //   System.out.println(tempe.zip);
		     
		      commap = temp.indexOf(',');
		     temp = temp.substring(commap+1,temp.length());
		      
		     // System.out.println("hi "+ tempe.name);
		      //System.out.println(temp);
		      
		      //System.out.println(temp);
		      commap = temp.indexOf(',');
		      tempage =Integer.parseInt(temp.substring(0,commap));
		      temp = temp.substring(commap+1,temp.length());
		   //   System.out.println(employees[count].Age);
		      
		      
		        tempe.no=notemp;
				tempe.name= nametemp;
				tempe.state=tempstate;
				tempe.Age=tempage;
				tempe.zip=tempzip;
		     
		     // System.out.println(tempe.toString());
				
		     add(tempe);
				
				}
			}//of not eof check
			System.out.println("done reading");
			br.close();
		
			
		
		}//of try
		catch(FileNotFoundException e) {
			System.out.println("file not read");
		}//of catch 1
		catch(IOException e) {
			System.out.print("error processing");
		}//of catch 2
		
}//of read function
 //=========================================================================================================================================================================	  
}//of EmployeeSet class 
