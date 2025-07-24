package com.raven.workflow_approval;

public class WorkflowDemo {
    public static void main(String[] args) {

        // Scenario 1: Successful Approval //
        // System.out.println("--- Scenario 1: Successful Approval ---");
        // WorkflowItem vacationRequest = new WorkflowItem("Vacation Request", "Week off
        // in August", "Alice");
        // System.out.println("Initial status: " + vacationRequest.getStatus());

        // vacationRequest.submit("Alice");
        // System.out.println("Current status: " + vacationRequest.getStatus());

        // vacationRequest.approve("Bob");
        // System.out.println("Current status: " + vacationRequest.getStatus());

        // System.out.println("Audit Trail for " + vacationRequest.getName() + ":");
        // vacationRequest.getAuditTrail().forEach(System.out::println);

        //
        // Scenario 2: Rejected and Re-submitted //
        // System.out.println("\n--- Scenario 2: Rejected and Re-submitted ---");
        // WorkflowItem expenseReport = new WorkflowItem("Expense Report Q2", "Travel expenses for April-June", "Charlie");
        // System.out.println("Initial status: " + expenseReport.getStatus());
        // expenseReport.submit("Charlie");

        // expenseReport.reject("David", "Missing receipts for hotel.");
        // System.out.println("Current status: " + expenseReport.getStatus());

        // expenseReport.approve("David"); // Attempt to approve a rejected item
        // expenseReport.submit("Charlie"); // Re-submit after fixing
        // expenseReport.approve("David");
        // System.out.println("Current status: " + expenseReport.getStatus());

        // System.out.println("Audit Trail for " + expenseReport.getName() + ":");
        // expenseReport.getAuditTrail().forEach(System.out::println);

        //
        // Scenario 3: Needs Revision and Cancelled //
        System.out.println("\n--- Scenario 3: Needs Revision and Cancelled ---");
        WorkflowItem projectProposal = new WorkflowItem("New Project X Proposal", "Proposal for AI initiative", "Eve");
        System.out.println("Initial status: " + projectProposal.getStatus());
        projectProposal.submit("Eve");
        projectProposal.requestRevision("Frank", "Need more detailed budget breakdown.");
        System.out.println("Current status: " + projectProposal.getStatus());
        projectProposal.submit("Eve"); // After revision
        projectProposal.cancel("Frank"); // Supervisor decides to cancel
        System.out.println("Current status: " + projectProposal.getStatus());
        projectProposal.approve("Garry"); // Attempt to approve a cancelled item
        System.out.println("Audit Trail for " + projectProposal.getName() + ":");
        projectProposal.getAuditTrail().forEach(System.out::println);
    }
}
