package logarlec.view.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
	private static ResourceBundle strings;

	/**
	 * Beállítja a használt nyelvet. Jelenleg támogatott nyelvek:
	 * <ul>
	 * <li>la - Latin</li>
	 * <li>en_US - Angol</li>
	 * <li>hu_HU - Magyar</li>
	 * </ul>
	 * 
	 * @param locale Nyelvi konfigurációs <code>Locale</code> objektum
	 */
	public static void setLocale(Locale locale) {
		strings = ResourceBundle.getBundle("lang/Strings", locale);
	}

	/**
	 * <code>String</code>-ek lekérdezése a <code>setLocale</code> által beállított nyelven.
	 * 
	 * @param key A string kulcsa
	 * @return A string a beállított nyelven.
	 */
	public static String getString(String key) {
		return strings.getString(key);
	}
}
