package uva.BER;

/**
@brief Luokka Length-kentän käsittelemiseen BER-enkoodauksessa.

Tukee korkeintaan neljällä tavulla enkoodattuja arvoja.
*/
public class Length
{
	private int pituus;
	
	// Maksimi pituus, joka voidaan enkoodata indeksin mukaisella määrällä tavuja.
	public static final int[] MAX_PITUUS = { 127, 0xFFFF, 0xFFFFFF, 0xFFFFFFFF };
	
	/**
	@brief Enkoodaa annettu pituus BER-muotoon.
	
	@returns Taulukon, joka kuvaa enkoodattua pituutta.
	         Jos enkoodaus epäonnistuu, palauttaa arvon null.
	*/
	public static byte[] enkoodaa (long pituus)
	{
		byte[] taulu = null;
		int i;
		
		for (i = 0; i < MAX_PITUUS.length; ++i)
		{
			if (pituus <= MAX_PITUUS[i])
				break;
		}
		
		if (i >= MAX_PITUUS.length) return null;
		
		taulu = new byte [i + 1];
		
		for (; i >= 0; --i)
		{
			taulu[i] = (byte) (pituus & 0xFF);
			pituus &= ~0xFF;
			pituus >>= 8;
		}
		
		return taulu;
	}
	
	/**
	@brief Dekoodaa Length-kenttä annetuista biteistä käyttäen BER-enkoodausta.
	
	@returns Length-kentän pituus tavuina.
	         Arvo nolla tarkoittaa virhettä.
	*/
	public int dekoodaa (byte[] data)
	{
		if (data[0] < MAX_PITUUS[0])
		{
			pituus = data[0];
			return 1;
		}
		
		int tavuja = data[0] & MAX_PITUUS[0];
		if (data.length < tavuja + 1) return 0;
		
		pituus = 0;
		for (int i = 0; i < tavuja; ++i)
		{
			pituus <<= 8;
			pituus += data[i + 1];
		}
		
		return tavuja + 1;
	}
	
	public int kerroPituus () { return pituus; }
}