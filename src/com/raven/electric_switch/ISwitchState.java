package com.raven.electric_switch;

public interface ISwitchState {
	void switchStateChanges(SwitchContext context, boolean state);

	void applySetting();
}
