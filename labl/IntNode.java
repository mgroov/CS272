package cs272labs;
/**
 * 
 * @author Matthew Groover
 *
 */
public class IntNode {

	private IntNode link;
    private int data;
//===========================================================================================
/**
 * sets the starting values to zero and null
 * @param none
 * @return none 
 */
public IntNode() {
	
	link = null;
	data =0;
	
}//of no argument constructor
//===========================================================================================
/**
 * This method takes in values from user and creates a linked list based on the
 * parameters passed
 * @param olddata data from old object 
 * @param oldlink link from old object 
 * @return none
 */
public IntNode(int olddata, IntNode oldlink) {
	
	setLink(oldlink);
	setData(olddata);
	
}//of two argument constructor
//===========================================================================================
/**
 * Returns the reference link based on the node calling it 
 * @param none
 * @return IntNode AKA link 
 */
public IntNode getLink() {
	return link;

}//of get link
//===========================================================================================
/**
 * takes link passed through and sets current based on passed parameter
 * @param link
 * @return none
 */
public void setLink(IntNode link) {
	this.link = link;
}//of set Link
//===========================================================================================
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
}//of IntNode class 
