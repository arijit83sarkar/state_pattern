package com.raven.smart_house.solution;

public class AwayModeState implements ILivingRoomState {

    @Override
    public void handleTimeChange(SmartLivingRoom room, int hourOfDay) {
        System.out.println("Away Mode: Time changed to " + hourOfDay + "h. (System is conserving energy)");
        // Time changes don't directly affect Away mode, but could be used for security
        // simulation
        applySettings();
    }

    @Override
    public void handleMotionDetection(SmartLivingRoom room, boolean motionDetected) {
        System.out.println("Away Mode: Motion detected: " + motionDetected);
        if (motionDetected) {
            System.out.println("  Intruder alert or user returned! Transitioning based on time.");
            // Determine state based on time of day
            if (room.getTimeOfDayHour() >= 7 && room.getTimeOfDayHour() < 19) {
                room.setState(new DayModeState());
            } else {
                room.setState(new NightModeState());
            }
        } else {
            System.out.println("  No motion. Remaining in Away Mode.");
        }
        applySettings(); // Re-apply or confirm settings
    }

    @Override
    public void leaveRoom(SmartLivingRoom room) {
        System.out.println("Away Mode: Already in Away Mode. No change.");
    }

    @Override
    public void enterRoom(SmartLivingRoom room) {
        System.out.println("Away Mode: User entered. Transitioning to Day/Night mode based on time.");
        if (room.getTimeOfDayHour() >= 7 && room.getTimeOfDayHour() < 19) {
            room.setState(new DayModeState());
        } else {
            room.setState(new NightModeState());
        }
    }

    @Override
    public void applySettings() {
        System.out.println("  Blinds: Partially closed (security).");
        System.out.println("  Lights: All off (energy saving).");
        System.out.println("  Smart Speaker: Off.");
        System.out.println("  Thermostat: Economy temperature.");
    }

    @Override
    public String toString() {
        return "AwayModeState";
    }
}
