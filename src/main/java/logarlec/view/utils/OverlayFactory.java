package logarlec.view.utils;

import logarlec.controller.util.SpriteManager;
import logarlec.model.effects.Effect;
import logarlec.model.effects.GasEffect;
import logarlec.model.effects.JanitorEffect;
import logarlec.model.effects.RagEffect;
import logarlec.model.gameobjects.Janitor;
import logarlec.view.drawables.Overlay;

public class OverlayFactory {
    public static Overlay createOverlay(GasEffect effect) {
        return new Overlay(SpriteManager.getInstance().getSprite("gas"));
    }

    public static Overlay createOverlay(JanitorEffect effect) {
        return new Overlay(SpriteManager.getInstance().getSprite("mask"));
    }
}
