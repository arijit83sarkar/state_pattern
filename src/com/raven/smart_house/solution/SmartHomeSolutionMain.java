package com.raven.smart_house.solution;

public class SmartHomeSolutionMain {
    public static void main(String[] args) {
        SmartLivingRoom livingRoom = new SmartLivingRoom();

        // Scenario 1: Transition from Day to Night automatically
        System.out.println("\n--- Scenario 1: Automatic Day to Night Transition ---");
        livingRoom.updateTime(18);
        livingRoom.updateTime(20);
    }
}
