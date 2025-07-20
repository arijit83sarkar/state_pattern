package com.raven.workflow_approval;

public class DraftState implements IWorkflowState {

    @Override
    public String getStatus() {
        return "Draft";
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": submitted for approval by " + user);
        item.setCurrentState(new SubmittedState());
        item.logAudit("Submitted by " + user);
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": cannot approve from Draft state.");
        item.logAudit("Attempted to approve from Draft by " + user + " (Failed)");
    }

    @Override
    public void reject(WorkflowItem item, String user, String reason) {
        System.out.println(item.getName() + ": cannot request for Reject for a draft.");
        item.logAudit("Attempted to approve from Reject by " + user + " (Failed)");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        System.out.println(item.getName() + ": cannot request for Revision for a draft.");
        item.logAudit("Attempted to approve from Revision by " + user + " (Failed)");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        System.out.println(item.getName() + ": Cancelling item from Draft state by " + user);
        item.setCurrentState(new CancelledState());
        item.logAudit("Cancelling from Draft state by " + user);
    }
}
