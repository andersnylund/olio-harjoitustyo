/**
 * 
 */

package uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * For reading input from user
 * @author Johanna Aalto, Hannu Niinimäki
 * Translated by Anders Nylund, w101302
 *
 */
public class Lue
{
  static BufferedReader stdin =
     new BufferedReader (new InputStreamReader (System.in));

  public static String rivi ()
  {
    String arvo = null;
    boolean ok;
	
    do
	{
      try
	  {
        arvo = stdin.readLine ();
        ok = true;
      }
	  catch (Exception e)
	  {
		System.out.println ("Error reading the line. Try again!");
        ok = false;
      }
    }
    while (!ok);
	
    return arvo;
  }

  public static int kluku ()
  {
    int arvo = -1;
    boolean ok;
	
    do
	{
      try
	  {
        arvo = Integer.parseInt (stdin.readLine ());
        ok = true;
      }
	  catch (Exception e)
	  {
		System.out.println ("Invalid integer. Try again!");
        ok = false;
      }
    }
    while (!ok);
	
    return arvo;
  }

  public static double dluku ()
  {
    double arvo = -1;
    boolean ok;
	
    do
	{
      try
	  {
        arvo = new Double (stdin.readLine ()).doubleValue ();
        ok = true;
      }
	  catch (Exception e)
	  {
		System.out.println("Invalid decimalnumber. Try again!");
        ok = false;
      }
    }
    while (!ok);
	
    return arvo;
  }

  public static char merkki ()
  {
    String rivi = rivi ();
	
    try
	{
      return rivi.charAt (0);
    }
	catch (Exception e)
	{
      return ' ';
    }
  }
}
