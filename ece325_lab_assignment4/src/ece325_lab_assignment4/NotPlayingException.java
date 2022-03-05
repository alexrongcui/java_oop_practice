package ece325_lab_assignment4;

//This exception should be a checked exception
//Below is the explanation
/* 	According to The Java™ Tutorials
	If a client can reasonably be expected to recover from an exception, make it a checked exception.
	Since the exception does not force the program to exit, it should be checked and handled.
	
	Also, the exception must be handled or thrown according to the requirement of the lab.
	thus, it must be checked.
	
	Since it is checked, we extend the Exception class instead of the RuntimeException class.
*/
public class NotPlayingException extends Exception{

	public NotPlayingException() {
		
		// a message saying music not playing
		super("Not playing, can't feed"); }
	
}
