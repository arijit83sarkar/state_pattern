package com.raven.workflow_approval;

public class NeedsRevisionState implements IWorkflowState {

    @Override
    public String getStatus() {
        return "Needs Revision";
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Re-submitting revised item by " + user);
        item.setCurrentState(new SubmittedState());
        item.logAudit("Re-submitted from Needs Revision by " + user);
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Item needs revision, cannot approve directly.");
        item.logAudit("Attempted to approve from Needs Revision by " + user + " (Failed)");
    }

    @Override
    public void reject(WorkflowItem item, String user, String reason) {
        System.out
                .println(item.getName() + ": Item needs revision, cannot reject directly. Should be submitted first.");
        item.logAudit("Attempted to reject from Needs Revision by " + user + " (Failed)");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        System.out.println(item.getName() + ": Already marked as needing revision.");
        item.logAudit("Attempted to request revision again from Needs Revision by " + user + " (No Change)");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Cancelling from Needs Revision state by " + user);
        item.setCurrentState(new CancelledState());
        item.logAudit("Cancelled from Needs Revision by " + user);
    }

}
