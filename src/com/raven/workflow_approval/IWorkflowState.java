package com.raven.workflow_approval;

public interface IWorkflowState {
    String getStatus();

    void submit(WorkflowItem item, String user);

    void approve(WorkflowItem item, String user);

    void reject(WorkflowItem item, String user, String reason);

    void requestRevision(WorkflowItem item, String user, String feedback);

    void cancel(WorkflowItem item, String user);
}
