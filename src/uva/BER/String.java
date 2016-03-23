package uva.BER;

import java.io.UnsupportedEncodingException;

public class String
{
	/**
	@brief Enkoodaa annettu arvo BER-muodossa.
	Merkkijono enkoodataan UTF-8 muodossa.
	@returns Arvo enkoodattuna.
	*/
	public static byte[] enkoodaa (java.lang.String arvo)
	{
		try { return arvo.getBytes ("UTF-8"); }
		catch (UnsupportedEncodingException e)
		{ throw new BERException ("Enkoodaus", e); }
	}
	
	/**
	@brief Dekoodaa arvo BER-muodosta.
	@returns Dekoodattu arvo.
	*/
	public static java.lang.String dekoodaa (byte[] data, int pituus)
	{
		try
		{
			byte[] tavut = java.util.Arrays.copyOfRange (data, 0, pituus);
			return new java.lang.String (tavut, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{ throw new BERException ("Enkoodaus", e); }
	}
}