package logarlec.view.utils;

import java.awt.Color;

public class Palette {
	private static Color[] palette = {new Color(23, 32, 56), new Color(37, 58, 94),
			new Color(60, 94, 139), new Color(79, 143, 186), new Color(115, 190, 211),
			new Color(164, 221, 219), new Color(25, 51, 45), new Color(37, 86, 46),
			new Color(70, 130, 50), new Color(117, 167, 67), new Color(168, 202, 88),
			new Color(208, 218, 145), new Color(77, 43, 50), new Color(122, 72, 65),
			new Color(173, 119, 87), new Color(192, 148, 115), new Color(215, 181, 148),
			new Color(231, 213, 179), new Color(52, 28, 39), new Color(96, 44, 44),
			new Color(136, 75, 43), new Color(190, 119, 43), new Color(222, 158, 65),
			new Color(232, 193, 112), new Color(36, 21, 39), new Color(65, 29, 49),
			new Color(117, 36, 56), new Color(165, 48, 48), new Color(207, 87, 60),
			new Color(218, 134, 62), new Color(30, 29, 57), new Color(64, 39, 81),
			new Color(122, 54, 123), new Color(162, 62, 140), new Color(198, 81, 151),
			new Color(223, 132, 165), new Color(9, 10, 20), new Color(16, 20, 31),
			new Color(21, 29, 40), new Color(32, 46, 55), new Color(57, 74, 80),
			new Color(87, 114, 119), new Color(129, 151, 150), new Color(168, 181, 178),
			new Color(199, 207, 204), new Color(235, 237, 233)};

	/**
	 * Visszaad egy színt az indexelt palettából. A paletta orrása:
	 * https://lospec.com/palette-list/apollo
	 * 
	 * @param idx A szín indexe
	 * @return A kiválasztott szín <code>Color</code> objektumként.
	 */
	public static Color getColor(int idx) {
		return palette[idx];
	}
}
