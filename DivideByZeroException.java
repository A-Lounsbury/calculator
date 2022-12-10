
public class DivideByZeroException extends Exception
{
	public DivideByZeroException()
	{ super("UNDEFINED: cannot divide by zero."); }
	
	public DivideByZeroException(String message)
	{ super(message); } // constructor of Exception class
}
