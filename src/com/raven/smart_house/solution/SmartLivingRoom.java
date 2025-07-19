package com.raven.smart_house.solution;

public class SmartLivingRoom {
    private ILivingRoomState roomState;
    private int timeOfDayHour;
    private boolean motionDetected;

    public SmartLivingRoom() {
        // Initial state of the living room (e.g., Day mode at 8 AM)
        this.roomState = new DayModeState();
        this.timeOfDayHour = 8;
        this.motionDetected = true; // Assume someone is home
        System.out.println("Smart Living Room initialized. Current State: " + roomState);
        roomState.applySettings(); // Apply initial settings
    }

    // --- Methods to change the state ---
    public void setState(ILivingRoomState newState) {
        System.out.println("\n--- Smart Living Room: Transitioning from "
                + this.roomState + " to " + newState + " ---");
        this.roomState = newState;
        newState.applySettings(); // Apply settings of the new state immediately
    }

    // --- Methods that delegate to the current state ---
    public void updateTime(int hourOfDay) {
        this.timeOfDayHour = hourOfDay;
        roomState.handleTimeChange(this, hourOfDay);
    }

    public void updateMotion(boolean detected) {
        this.motionDetected = detected;
        roomState.handleMotionDetection(this, detected);
    }

    public void userEntersRoom() {
        roomState.enterRoom(this);
    }

    // Getter for state to aid in transitions (e.g., in AwayModeState)
    public int getTimeOfDayHour() {
        return timeOfDayHour;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public ILivingRoomState getCurrentState() {
        return roomState;
    }
}
