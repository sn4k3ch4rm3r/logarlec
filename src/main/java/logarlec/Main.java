package logarlec;

import java.util.Locale;
import logarlec.controller.Controller;
import logarlec.controller.util.SpriteManager;
import logarlec.view.utils.I18n;

public class Main {
	public static void main(String[] args) {
		Locale locale = Configuration.DEFAULT_LOCALE;

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("--lang")) {
				String lang = args[i + 1].split("_")[0];
				String country = args[i + 1].split("_")[1];
				locale = new Locale(lang, country);
			}
		}

		SpriteManager.getInstance().loadSprites();
		I18n.setLocale(locale);
		new Controller();
	}
}
