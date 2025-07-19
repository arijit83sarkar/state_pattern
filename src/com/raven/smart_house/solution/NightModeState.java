package com.raven.smart_house.solution;

public class NightModeState implements ILivingRoomState {

    @Override
    public void handleTimeChange(SmartLivingRoom room, int hourOfDay) {
        System.out.println("Night Mode: Time changed to " + hourOfDay + "h.");
        if (hourOfDay >= 7 && hourOfDay < 19) { // 7 AM to 6:59 PM
            System.out.println("  Time suggests transitioning to Day Mode.");
            room.setState(new DayModeState()); // Transition!
        }
        applySettings();
    }

    @Override
    public void handleMotionDetection(SmartLivingRoom room, boolean motionDetected) {
        System.out.println("Night Mode: Motion detected: " + motionDetected);
        // Might adjust dimness based on prolonged absence even at night
        applySettings();
    }

    @Override
    public void leaveRoom(SmartLivingRoom room) {
        System.out.println("Night Mode: User leaving. Transitioning to Away Mode.");
        room.setState(new AwayModeState()); // Transition!
    }

    @Override
    public void enterRoom(SmartLivingRoom room) {
        System.out.println("Night Mode: User entered. Remaining in Night Mode.");
    }

    @Override
    public void applySettings() {
        System.out.println("  Blinds: Closing fully.");
        System.out.println("  Lights: Dimmable to 40% (warm white).");
        System.out.println("  Smart Speaker: Low volume, soft background music.");
    }

    @Override
    public String toString() {
        return "NightModeState";
    }
}
