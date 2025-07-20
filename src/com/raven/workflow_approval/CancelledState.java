package com.raven.workflow_approval;

public class CancelledState implements IWorkflowState {

    @Override
    public String getStatus() {
        return "Cancelled";
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Item is cancelled and cannot be submitted.");
        item.logAudit("Attempted to submit from Cancelled by " + user + " (Failed)");
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Item is cancelled and cannot be approved.");
        item.logAudit("Attempted to approve from Cancelled by " + user + " (Failed)");
    }

    @Override
    public void reject(WorkflowItem item, String user, String reason) {
        System.out.println(item.getName() + ": Item is cancelled and cannot be rejected.");
        item.logAudit("Attempted to reject from Cancelled by " + user + " (Failed)");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        System.out.println(item.getName() + ": Item is cancelled and cannot be revised.");
        item.logAudit("Attempted to request revision from Cancelled by " + user + " (Failed)");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Item is already cancelled.");
        item.logAudit("Attempted to cancel again from Cancelled by " + user + " (No Change)");
    }

}
