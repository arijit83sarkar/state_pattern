package com.raven.workflow_approval;

public class CancelledState implements IWorkflowState{

    @Override
    public String getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    @Override
    public void submit(WorkflowItem item, String user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submit'");
    }

    @Override
    public void approve(WorkflowItem item, String user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'approve'");
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
