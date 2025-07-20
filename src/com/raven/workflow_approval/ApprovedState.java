package com.raven.workflow_approval;

public class ApprovedState implements IWorkflowState {

    @Override
    public String getStatus() {
        return "Approved";
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Already approved, cannot be submitted again.");
        item.logAudit("Attempted to submit from Approved by " + user + " (Failed)");
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Already in Approved state.");
        item.logAudit("Attempted to approve again from Approved by " + user + " (No Change)");
    }

    @Override
    public void reject(WorkflowItem item, String user, String reason) {
        System.out.println(item.getName() + ": Cannot reject an already approved item.");
        item.logAudit("Attempted to reject from Approved by " + user + " (Failed)");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        System.out.println(item.getName() + ": Cannot request revision for an approved item.");
        item.logAudit("Attempted to request revision from Approved by " + user + " (Failed)");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Approved item cannot be cancelled directly. Requires special process.");
        item.logAudit("Attempted to cancel from Approved by " + user + " (Failed)");
    }

}
