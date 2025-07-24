package com.raven.workflow_approval;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WorkflowItem {
    private String id;
    private String name;
    private String description;
    private String creator;
    private IWorkflowState currentState;
    private List<String> auditTrail;

    public WorkflowItem() {
    }

    public WorkflowItem(String name, String description, String creator) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.currentState = new DraftState(); // Initial state
        this.auditTrail = new ArrayList<>();
        logAudit("Created in Draft state by " + creator);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreator() {
        return creator;
    }

    public IWorkflowState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IWorkflowState newState) {
        System.out.println("Transitioning from " + this.currentState.getStatus() + " to " + newState.getStatus());
        this.currentState = newState;
        logAudit("Transitioned to " + newState.getStatus());
    }

    public void logAudit(String event) {
        auditTrail.add(LocalDateTime.now() + ": " + event);
    }

    public List<String> getAuditTrail() {
        return new ArrayList<>(auditTrail); // Return a copy for immutability
    }

    // Delegate actions to the current state
    public void submit(String user) {
        currentState.submit(this, user);
    }

    public void approve(String user) {
        currentState.approve(this, user);
    }

    public void reject(String user, String reason) {
        currentState.reject(this, user, reason);
    }

    public void requestRevision(String user, String feedback) {
        currentState.requestRevision(this, user, feedback);
    }

    public void cancel(String user) {
        currentState.cancel(this, user);
    }

    public String getStatus() {
        return currentState.getStatus();
    }
}
