package jota.server.util;

public class UtilsJava {

	public static class Numeros {  
	}
	public static class Cadenas {
		public static String concat( String... cadenas ) {
			return concatWS( " ", cadenas );
		}

		public static String concatWS( String separator, String... cadenas ) {
			String dev = "";
			for ( String cadena : cadenas ) {
				if ( cadena != null ) {
					dev += separator + cadena;
				}
			}
			if ( dev.length() > separator.length() ) {
				dev = dev.substring( separator.length() );
			}
			return dev;
		}		
	}
}