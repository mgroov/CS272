//Matthew Groover
//cs272
//09/04/18
package cs272program;

import java.util.Arrays;

public class Employee {

	
	 String name;                       //
	 int no;                            //
	 String state;                      //   Initialization of variables 
	 int zip;                           //   for employee objects/class 
	 int Age;                           //
     int[] advisors = {0,0,0};          //
     
     
     public static void main(String args[]) {
    	 Employee one = new Employee();
    	 one.setname("Eric Smith");                 //
    	 System.out.println(one.getname());         //
    	 one.setno(1);                              //
    	 one.setstate("MA");                        //  testing the set functions 
    	 one.setzip(79912);                         //  and the to string method 
    	 one.setage(52);                            //  witch tests the solo get advisors
    	 one.setadvisors(1, 2, 5);                  //
    	 System.out.println(one.toString());        //
    	 
    	 Employee two = new Employee(one);                 //
    	 two.setage((int)one.getage()/2);                  //
    	 two.setname(one.getname()+ " jr");                //     testing object based constructor
    	 System.out.println(" "+one.equals(two));          //     as well as the get commands 
    	 two.setno(2);                                     //     then tests opposite cases of equals method
    	 System.out.println(" "+one.equals(two));          //
    	 
    	 two.setadvisors(5, 6, 7);                         // setting unique advisors for object  
    	int[] advi= Employee.getAllAdvisor(one, two);      //then tests the getAlladvisors method
    	for(int k=0;k<advi.length;k++) {                   // using for loop to print the returned array where 0 represents a empty or repeat advisor
    		System.out.print(advi[k]+" ");
    		
    	}
    	System.out.print('\n');
    	System.out.println(two.toString());                 // tests the additions and  changes to object two
     }//main method                                         //from the get and set commands 
	
    public Employee (){
		
		
	 name = null;
     no=0;
	 state=null;
	 zip=0;                         // base no argument constructor initializes all values to zero or null 
	 Age=0;
	 advisors=new int[3];
	
		
}//of empty constructor
    
    public Employee(Object obj) {
    	if(obj !=null&& obj instanceof Employee) {    
    		Employee emp =(Employee)obj;                   //copy constructor 
    		no = emp.no;                                   // first checks that the object passed is of type employee and
    		zip = emp.zip;                                 //isn't null it then uses the values of the passed object 
    		Age = emp.Age;                                 //to initialize the new object 
    		name = new String(emp.name);                   //In order to not copy only reference values String use new String();
    		state = new String(emp.state);                 //And the array deep copies or copies the values one by one                        
    		for(int i=0;i<this.advisors.length;i++) {
    			this.advisors[i]=emp.advisors[i];
    		
    		}
    	}//of if null or not instance of
    	else {
    		throw new IllegalArgumentException("Error Incorect or missformated object"); //if the object is null or not employees throws an error
    	}
    }// object constructor
    
  //==========================================setters and getters=================================================================================================  
    public String getname() {     // the setters call the value based on the object calling it and the mutators change it based on the parameters passed
		return name;
	}//of name acessor
//------------------------------------------------------------------
	public void setname(String Name) {
		name = Name;
	}//of name mutator
//-------------------------------------------------------------------
	public int getno() {
		return no;
	}//of no acessor
//------------------------------------------------------------------
	public void setno(int num) {
		no = num;
	}//of no mutator
//----------------------------------------------------------------
	public String getstate() {
		return state;
	}//of state acessor
//----------------------------------------------------------------
	public void setstate(String State) {
		state = State;
	}//of state muator
//----------------------------------------------------------------
	public int getzip() {
		return zip;
	}//of state acessor
//--------------------------------------------------------------------
	public void setzip(int Zip) {
		zip = Zip;
	}//of zip mutator
//------------------------------------------------------------------
	public int getage() {
		return Age;
	}//of age acessor
//----------------------------------------------------------------------
	public void setage(int age) {
		Age = age;
	}//of age mutator

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public String getAdvisors() {                //creates an empty string then iterates a for loop and stores each value into that string then returns the string 
    	String adv = "";
    	for(int y=0;y<advisors.length;y++) {
    		 adv = adv + advisors[y];
    	}//of advisors 
    	return(adv);
    }//of get advisors 
    
 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------   
    

public void setadvisors(int a,int b, int c) {   // takes in three integers and turns the into array then copies by value to avoid overflow or reference problems
      int[] x= {a,b,c};
     
    	 advisors[0]=x[0];
          advisors[1]=x[1];
          advisors[2]=x[2];
   }//of mutate advisors
   
//=============================================================to string=====================================================================================

public String toString() {
	return(""+name+", "+no+", "+Age+", "+state+", "+zip+", "+getAdvisors()); // this method separates the information based on object calling
}//of to string method                                                       //uses the get advisors to facilitate and easy string print
//=====================================================equals================================================================================================
public boolean equals(Object obj) {
	if(obj != null && obj instanceof Employee) {                           // this method firsts checks if the object passed as a parameter 
		Employee empp = (Employee)obj;                                     // isn't null and is an instance of employee  
		if(this.no==empp.no) {                                             // it then compares the employees numbers and if they 
			return (true);                                                 // are equal then it returns true 
		}                                                                  // and if they aren't it returns false 
		else {                                                             // if the object is null or not an instance of employee 
			return(false);                                                 // it will throw an illegal argument exception
		}
	}//of instance and null check
	throw new IllegalArgumentException("Error Incorect or missformated object");	
}//of equals method
//=========================================Get all advisors==========================================================================================
public static int[] getAllAdvisor(Employee e1,Employee e2) {             // This method takes in two employee objects
	                                                                     // first it checks to see if they are not null objects
	if(e1 != null && e2 != null) {                                       // then it sorts both objects arrays into ascending order
	int [] uniqueadv = new int[6];                                       // using two for loops it adds each arrays elements to one final
	int count =0;                                                        // It then sorts the new final array
	Arrays.sort(e1.advisors);                                            // using a for loop it checks that none of the elements 
	Arrays.sort(e2.advisors);                                            // near each other match and if the do it places 
	for(int i=0;i<3;i++) {                                               // a zero where the duplicate is representing no advisor
			uniqueadv[i]=e1.advisors[i];                                 // a final sort is used so that when printed 
			count++;                                                     // the empty or null advisors are shown first 
		}//of e1 i
	for(int i=0;i<3;i++) {
		uniqueadv[count]=e2.advisors[i];
		count++;
	}//of e2 i
	Arrays.sort(uniqueadv);
	for(int i=0;i<uniqueadv.length-1;i++) {
		if(uniqueadv[i]==uniqueadv[i+1]) {
			uniqueadv[i]=0;
		}
	}
	Arrays.sort(uniqueadv);
	return(uniqueadv);

	}//if null check
	throw new IllegalArgumentException("Null Object given");	
}//of get advisors method
//========================================================================================================================================================================
}//of class employee
