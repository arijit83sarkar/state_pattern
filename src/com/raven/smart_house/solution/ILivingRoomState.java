package com.raven.smart_house.solution;

public interface ILivingRoomState {
    void handleTimeChange(SmartLivingRoom room, int hourOfDay);

    void handleMotionDetection(SmartLivingRoom room, boolean motionDetected);

    // Simulate going to Away mode
    void leaveRoom(SmartLivingRoom room);

    // Simulate returning from Away mode
    void enterRoom(SmartLivingRoom room);

    // Method to apply the state's specific device settings
    void applySettings();
}
