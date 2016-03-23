package uva.BER;

/**
@brief Luokka Type-kentän käsittelemiseen BER-enkoodauksessa.

Tukee vain yhdellä tavulla enkoodattuja arvoja.
*/
public class Type
{
	private int luokka;
	private boolean tietue;
	private int tag;
	
	// Type-kentän luokka-osan arvot.
	public static final int UNIVERSAL = 0;
	public static final int APPLICATION = 1;
	public static final int CONTEXT = 2;
	public static final int PRIVATE = 3;
	
	public static final int MAX_LUOKKA = 4;
	public static final int MAX_TAG = 30; // yhdellä tavula
	
	public static byte enkoodaa (int tag)
	{ return enkoodaa (CONTEXT, false, tag); }
	
	/**
	@brief Muodosta type-kentän arvo annetuilla arvoilla.
	
	Tukee vain yhden tavun pituisia type-kenttiä.
	
	@returns Type-kentän arvo.
	*/
	public static byte enkoodaa (int luokka, boolean tietue, int tag)
	{
		byte tulos = 0;
		
		tulos |= (luokka & 0x3) << 6;
		if (tietue) tulos |= 1 << 5;
		tulos |= tag & 0x1F;
		
		return tulos;
	}
	
	public Type () { }
	
	public Type (int luokka, boolean tietue, int tag)
	{
		this.luokka = luokka;
		this.tietue = tietue;
		this.tag = tag;
	}
	
	public byte enkoodaa ()
	{ return enkoodaa (luokka, tietue, tag); }
	
	/**
	@brief Dekoodaa annettu arvo tähän olioon.
	
	@returns Tosi jjos dekoodaus onnistui.
	*/
	public boolean dekoodaa (byte type)
	{
		luokka = (type & 0xC0) >> 6;
		if ((type & 0x20) != 0) tietue = true;
		tag = type & 0x1F;
		
		if (luokka > MAX_LUOKKA || tag > MAX_TAG)
			return false;
		return true;
	}
	
	public int kerroLuokka () { return luokka; }
	public boolean onTietue () { return tietue; }
	public int kerroTag () { return tag; }
}