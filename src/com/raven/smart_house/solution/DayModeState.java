package com.raven.smart_house.solution;

public class DayModeState implements ILivingRoomState {

    @Override
    public void handleTimeChange(SmartLivingRoom room, int hourOfDay) {
        System.out.println("Day Mode: Time changed to " + hourOfDay + "h.");
        if (hourOfDay >= 19 || hourOfDay < 7) { // 7 PM to 6:59 AM
            System.out.println("  Time suggests transitioning to Night Mode.");
            room.setState(new NightModeState()); // Transition!
        }
        applySettings();
    }

    @Override
    public void handleMotionDetection(SmartLivingRoom room, boolean motionDetected) {
        System.out.println("Day Mode: Motion detected: " + motionDetected);
        // Day mode usually doesn't change much based on motion if someone is expected
        // to be home
        applySettings();
    }

    @Override
    public void leaveRoom(SmartLivingRoom room) {
        System.out.println("Day Mode: User leaving. Transitioning to Away Mode.");
        room.setState(new AwayModeState()); // Transition!
    }

    @Override
    public void enterRoom(SmartLivingRoom room) {
        // Already in a "home" state
        System.out.println("Day Mode: User entered. Remaining in Day Mode.");
    }

    @Override
    public void applySettings() {
        System.out.println("  Blinds: Opening fully.");
        System.out.println("  Lights: Off.");
        System.out.println("  Smart Speaker: Silent.");
    }

    @Override
    public String toString() {
        return "DayModeState";
    }
}
