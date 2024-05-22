package logarlec.view.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import logarlec.Configuration;
import logarlec.view.components.Button;
import logarlec.view.utils.I18n;
import logarlec.view.utils.Palette;
import logarlec.view.utils.TextRenderer;

public class MenuPanel extends JPanel {
	private int localeIndex = 0;
	private Locale[] locales = {new Locale("la"), new Locale("en", "US"), new Locale("hu")};

	public MenuPanel(Runnable startButtonCallback) {
		this.setPreferredSize(
				new Dimension(Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT));
		this.setBackground(Palette.getColor(26));

		Button btnStart = new Button(I18n.getString("start-game"));
		Button btnExit = new Button(I18n.getString("exit"));
		Button btnLanguage = new Button(I18n.getString("language"));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBorder(
				BorderFactory.createEmptyBorder((int) (144 * Configuration.SCALE), 0, 0, 0));
		buttonPanel.setOpaque(false);


		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets =
				new Insets((int) (0 * Configuration.SCALE), 0, (int) (8 * Configuration.SCALE), 0);

		buttonPanel.add(btnStart, gbc);
		buttonPanel.add(btnLanguage, gbc);
		buttonPanel.add(btnExit, gbc);

		this.add(buttonPanel);

		btnStart.addActionListener(e -> {
			startButtonCallback.run();
		});

		btnLanguage.addActionListener(e -> {
			localeIndex++;
			if (localeIndex >= locales.length) {
				localeIndex = 0;
			}
			I18n.setLocale(locales[localeIndex]);
			btnStart.setText(I18n.getString("start-game"));
			btnLanguage.setText(I18n.getString("language"));
			btnExit.setText(I18n.getString("exit"));
			((JFrame) SwingUtilities.windowForComponent(this))
					.setTitle(I18n.getString("slide-rule"));
			repaint();
		});

		btnExit.addActionListener(e -> {
			System.exit(0);
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		BufferedImage title =
				TextRenderer.draw(I18n.getString("slide-rule"), (int) (32 * Configuration.SCALE));
		g.drawImage(title, (getPreferredSize().width - title.getWidth()) / 2,
				(int) (50 * Configuration.SCALE), null);
	}
}
