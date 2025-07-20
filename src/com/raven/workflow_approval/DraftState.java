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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reject'");
    }

    @Override
    public void requestRevision(WorkflowItem item, String user, String feedback) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestRevision'");
    }

    @Override
    public void cancel(WorkflowItem item, String user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancel'");
    }
}
