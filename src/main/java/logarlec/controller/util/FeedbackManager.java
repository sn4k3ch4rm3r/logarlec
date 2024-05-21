package logarlec.controller.util;

import logarlec.view.drawables.SideBarView;

public class FeedbackManager {
	private static SideBarView sideBarView;

	public static void setFeedback(String value) {
		if (sideBarView != null) {
			sideBarView.setFeedback(value);
		}
	}

	public static void setView(SideBarView view) {
		sideBarView = view;
	}
}
