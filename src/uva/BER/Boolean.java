package uva.BER;

public class Boolean
{
	/**
	@brief Enkoodaa annettu arvo BER-muodossa.
	@returns Arvo enkoodattuna.
	*/
	public static byte[] enkoodaa (boolean arvo)
	{
		byte[] taulu = new byte [1];
		if (arvo) taulu[0] = (byte) 0xFF;
		else taulu[0] = 0x00;
		return taulu;
	}
	
	// Boolean arvo enkoodataan aina yhdellä tavulla.
	public static boolean dekoodaa (byte[] data) { return dekoodaa (data, 1); }
	
	/**
	@brief Dekoodaa arvo BER-muodosta.
	@throws IllegalArgumentException  Jos enkoodaus on väärin.
	@returns Dekoodattu arvo.
	*/
	public static boolean dekoodaa (byte[] data, int pituus)
	{
		if (data.length < 1) throw new IllegalArgumentException ();
		if (data[0] == 0) return false;
		else return true;
	}
}