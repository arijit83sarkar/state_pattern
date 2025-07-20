package com.raven.workflow_approval;

public class SubmittedState implements IWorkflowState {

    @Override
    public String getStatus() {
        return "Submitted";
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Already in Submitted state.");
        item.logAudit("Attempted to submit again from Submitted by " + user + " (No Change)");
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Approving by " + user);
        item.setCurrentState(new ApprovedState());
        item.logAudit("Approved by " + user);
    }

    @Override
    public void reject(WorkflowItem item, String user, String reason) {
        System.out.println(item.getName() + ": Rejecting by " + user + ". Reason: " + reason);
        item.setCurrentState(new RejectedState());
        item.logAudit("Rejected by " + user + " (Reason: " + reason + ")");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        System.out.println(item.getName() + ": Requesting revision by " + user + ". Feedback: " + feedback);
        item.setCurrentState(new NeedsRevisionState());
        item.logAudit("Revision requested by " + user + " (Feedback: " + feedback + ")");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Cancelling from Submitted state by " + user);
        item.setCurrentState(new CancelledState());
        item.logAudit("Cancelled from Submitted by " + user);
    }

}
