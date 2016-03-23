package uva.BER;

public class BERException extends RuntimeException
{
	public BERException () {}
	
	public BERException (java.lang.String viesti)
	{ super (viesti); }
	
	public BERException (java.lang.String viesti, Throwable syy)
	{ super (viesti, syy); }
}