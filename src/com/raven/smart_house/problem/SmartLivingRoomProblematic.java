package com.raven.smart_house.problem;

// Problematic approach (AVOID THIS FOR COMPLEX STATE LOGIC)
public class SmartLivingRoomProblematic {
    private boolean motionDetected;
    private int timeOfDayHour;
    private ERoomState currentState;

    public SmartLivingRoomProblematic() {
        currentState = ERoomState.DAY;
        motionDetected = true;
        timeOfDayHour = 8;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
        updateRoomBehavior();
    }

    public void setTimeOfDayHour(int timeOfDayHour) {
        this.timeOfDayHour = timeOfDayHour;
        updateRoomBehavior();
    }

    public void setCurrentState(ERoomState currentState) {
        this.currentState = currentState;
        updateRoomBehavior();
    }

    public void updateRoomBehavior() {
        System.out.println("\n-- Updating behavior in " + currentState + " mode ---");
        if (ERoomState.DAY.equals(currentState)) {
            System.out.println("  Blinds: Opening for sunlight.");
            System.out.println("  Lights: Off (natural light).");
            System.out.println("  Smart Speaker: Silent.");
            if (timeOfDayHour >= 19 || timeOfDayHour < 7) {
                System.out.println("  -> Warning: Time suggests switching to Night mode.");
                // Potentially transition here, making logic even more nested
            }
        } else if (ERoomState.NIGHT.equals(currentState)) {
            System.out.println("  Blinds: Closing for privacy.");
            System.out.println("  Lights: Dimmable to 40%.");
            System.out.println("  Smart Speaker: Low volume, soft music.");
            if (timeOfDayHour >= 7 && timeOfDayHour < 19) {
                System.out.println("  -> Warning: Time suggests switching to Day mode.");
            }
        } else if (ERoomState.AWAY.equals(currentState)) {
            if (!motionDetected) { // Only truly 'Away' if no motion
                System.out.println("  Blinds: Partially closed (security).");
                System.out.println("  Lights: All off (energy saving).");
                System.out.println("  Smart Speaker: Off.");
                System.out.println("  Thermostat: Set to economy.");
            } else {
                System.out.println("  Motion detected in Away mode! Reverting to Day/Night based on time.");
                // Very complex logic to figure out which state to go back to
                if (timeOfDayHour >= 7 && timeOfDayHour < 19) {
                    setCurrentState(ERoomState.DAY);
                } else {
                    setCurrentState(ERoomState.NIGHT);
                }
                return; // Stop further processing in this call
            }
        } else {
            System.out.println("  Unknown state: " + currentState + ". Taking no action.");
        }
    }
}
