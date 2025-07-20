package com.raven.workflow_approval;

public class RejectedState implements IWorkflowState {

    @Override
    public String getStatus() {
        return "Rejected";
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        System.out.println(
                item.getName() + ": Re-submitting rejected item by " + user + " after potential modifications.");
        item.setCurrentState(new SubmittedState()); // Could also go to Draft or a specific 'Re-submitted' state
        item.logAudit("Re-submitted from Rejected by " + user);
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Cannot approve a rejected item directly. It needs re-submission.");
        item.logAudit("Attempted to approve from Rejected by " + user + " (Failed)");
    }

    @Override
    public void reject(WorkflowItem item, String user, String reason) {
        System.out.println(item.getName() + ": Already in Rejected state.");
        item.logAudit("Attempted to reject again from Rejected by " + user + " (No Change)");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        System.out
                .println(item.getName() + ": Rejected item doesn't need revision, it needs re-submission if desired.");
        item.logAudit("Attempted to request revision from Rejected by " + user + " (Failed)");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Rejected item cannot be cancelled directly.");
        item.logAudit("Attempted to cancel from Rejected by " + user + " (Failed)");
    }

}
