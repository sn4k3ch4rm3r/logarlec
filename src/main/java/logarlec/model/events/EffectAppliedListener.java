package logarlec.model.events;

import logarlec.model.effects.GasEffect;
import logarlec.model.effects.JanitorEffect;

public interface EffectAppliedListener {
    void onEffectApplied(GasEffect g);

    void onEffectApplied(JanitorEffect j);
}
