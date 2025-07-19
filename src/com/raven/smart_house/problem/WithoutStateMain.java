package com.raven.smart_house.problem;

public class WithoutStateMain {
    public static void main(String[] args) {
        SmartLivingRoomProblematic room = new SmartLivingRoomProblematic();
        room.updateRoomBehavior(); // Initial state

        room.setTimeOfDayHour(20); // 8 PM
        room.setMotionDetected(true);
        // Notice the spaghetti code of trying to figure out which state to be in based
        // on time
        room.setCurrentState(ERoomState.NIGHT); // Manually setting for demo

        room.setMotionDetected(false);
        room.setCurrentState(ERoomState.AWAY); // Simulate leaving home
        room.setMotionDetected(true); // Simulate returning home briefly
    }
}