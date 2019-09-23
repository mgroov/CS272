//Matthew Groover
//cs272

package cs272program;
import java.io.*;
public class EmployeeFileOp{
	String fname = "core_dataset.csv";
	employee[] employees = new employee[500];
	String first ="";
	int count=0;
	 static EmployeeFileOp re = new EmployeeFileOp();
	
	public static void main(String[] args) {
		re.read("core_dataset.csv");
		re.write();
	}
	class employee{
		
			String frname;
			String lname;
			String name;
			String Number;
			String state;
			String zip;
			int Age;
			String sex;
			
		
	}
	   public void read(String s)  {
		   System.out.println("hi");
		
		String temp = "";
		int y =0;
		int commap =0;
		
		try {
			FileReader filereader = new FileReader(s);
			BufferedReader br = new BufferedReader(filereader);
			while((temp =br.readLine()) != null) {
			if(temp.charAt(0)!=',') {
				if(y==0) {
		      first=temp;
		      temp = br.readLine();
				}
				y++;
			
		      employees[count]= new employee();
		      System.out.println(temp);
		      //System.out.println(temp.length());
		      commap = temp.indexOf(',');
		      if(commap==13) {
		    	  commap= temp.indexOf(' ');
		    	  employees[count].name=temp.substring(0,commap);
		    	  temp = temp.substring(commap,temp.length());
		    	  commap = temp.indexOf(',');
			      employees[count].name = employees[count].name + temp.substring(0,commap); 
		    	  temp = temp.substring(commap+1,temp.length());
		      }
		      else {
		     // System.out.println(commap);
		      employees[count].name = temp.substring(0,commap);
		      temp = temp.substring(commap+1,temp.length());
		      commap = temp.indexOf(',');
		      employees[count].name = employees[count].name + temp.substring(0,commap);          
		      temp = temp.substring(commap+1,temp.length());
		      }
		      
		      
		      System.out.println(temp);
		      
		      commap = temp.indexOf(',');
		      employees[count].Number = temp.substring(0,commap);
		      temp = temp.substring(commap+1,temp.length());
		      
		      commap = temp.indexOf(',');
		      employees[count].state = temp.substring(0,commap);
		      temp = temp.substring(commap+1,temp.length());
		      
		      commap = temp.indexOf(',');
		      employees[count].zip = temp.substring(0,commap);
		      temp = temp.substring(commap+1,temp.length());
		 
		     
		      commap = temp.indexOf(',');
		     temp = temp.substring(commap+1,temp.length());
		      
		      System.out.println("hi "+ employees[count].name);
		      System.out.println(temp);
		      
		      //System.out.println(temp);
		      commap = temp.indexOf(',');
		      employees[count].Age =Integer.parseInt(temp.substring(0,commap));
		      temp = temp.substring(commap+1,temp.length());
		      System.out.println(employees[count].Age);
		      
		      
		      
		      commap = temp.indexOf(',');
		      employees[count].sex = temp.substring(0,commap);
		    
		      temp = temp.substring(commap+1,temp.length());
		      
		      count++;
		      System.out.println(temp);
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
	   public void write() { 

	  
		   
	  try {
	    	  File ne = new File("young_employee.csv");
	    	  FileWriter fw = new FileWriter(ne.getAbsoluteFile());
	    	  BufferedWriter bw = new BufferedWriter(fw);
	    	  
	    	  bw.write(first+"\n");
	    	  
	    	  for(int i=0;i<count;i++) {
			      if(employees[i].Age<31) {
			    	  bw.write(" "+employees[i].name + ',' + employees[i].Number + ',' + employees[i].state +','+ employees[i].zip + ','+ employees[i].Age + ','+ employees[i].sex + ','+"\n");
			      }//of if 
		   
		           }//of for
	    		
	    		 
	    	 
	    	  bw.close();
	  		  fw.close();
	      }
	 
	   catch(IOException e) {
		   
	   }
	   System.out.println("writing done");
	   
	   }//of write
	   
	   
	
}//of employeefileop 
