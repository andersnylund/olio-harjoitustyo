package uva.BER;

public class Integer
{
	// Tuetaan korkeintaan 32-bittisiä kokonaislukuja.
	public static final int MAX_PITUUS = 4;
	
	// Maksimi positiivinen arvo, joka voidaan enkoodata indeksin mukaisella määrällä tavuja.
	public static final int[] MAX_POS_ARVO = { 127, 0x7FFF, 0x7FFFFF, 0x7FFFFFFF };
	
	// Minimi negatiivinen arvo, joka voidaan enkoodata indeksin mukaisella määrällä tavuja.
	// arvo[i] = -2^(8*i - 1)
	public static final int[] MIN_NEG_ARVO = { -128, -32768, -8388608, -2147483648 };
	
	public static final int HEX_BASE = 16;
	
	/**
	@brief Enkoodaa annettu arvo BER-muodossa.
	@returns Arvo enkoodattuna.
	*/
	public static byte[] enkoodaa (int arvo)
	{
		byte[] taulu = null;
		int i;
		
		if (arvo >= 0)
		{
			for (i = 0; i < MAX_POS_ARVO.length; ++i)
			{
				if (arvo <= MAX_POS_ARVO[i])
					break;
			}
			
			if (i >= MAX_POS_ARVO.length) return null;
			
			taulu = new byte [i + 1];
			
			for (; i >= 0; --i)
			{
				taulu[i] = (byte) (arvo & 0xFF);
				arvo &= ~0xFF;
				arvo >>= 8;
			}
			
			return taulu;
		}
		
		for (i = 0; i < MIN_NEG_ARVO.length; ++i)
		{
			if (arvo >= MIN_NEG_ARVO[i])
				break;
		}
		
		if (i >= MIN_NEG_ARVO.length) return null;
		
		taulu = new byte [i + 1];
		java.lang.String hex = java.lang.Integer.toHexString (arvo);
		int j = hex.length () - 1;
		
		for (; i >= 0; --i)
		{
			java.lang.String tavu = hex.charAt (j-1) + "" + hex.charAt (j);
			taulu[i] = (byte) java.lang.Integer.parseInt (tavu, HEX_BASE);
			j -= 2;
		}
		
		return taulu;
	}
	
	/**
	@brief Dekoodaa arvo BER-muodosta.
	@returns Arvo dekoodattuna.
	*/
	public static int dekoodaa (byte[] data, int pituus)
	{
		if (pituus > MAX_PITUUS) throw new IllegalArgumentException ();
		
		int arvo = 0;
		for (int i = 0; i < pituus; ++i)
		{
			arvo <<= 8;
			arvo |= data[i];
		}
		
		if (arvo > MAX_POS_ARVO[pituus - 1]) arvo = -arvo;
		
		return arvo;
	}
}