package ca.gbc.approvalservice.controller;

import ca.gbc.approvalservice.model.Approval;
import ca.gbc.approvalservice.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping
    public List<Approval> getAllApprovals() {
        return approvalService.getAllApprovals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable String id) {
        Optional<Approval> approval = approvalService.getApprovalById(id);
        return approval.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Approval> createApproval(@RequestBody Approval approval) {
        Approval createdApproval = approvalService.createApproval(approval);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApproval);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable String id, @RequestBody Approval approval) {
        Approval updatedApproval = approvalService.updateApproval(id, approval);
        return updatedApproval != null ? ResponseEntity.ok(updatedApproval) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable String id) {
        approvalService.deleteApproval(id);
        return ResponseEntity.noContent().build();
    }
}
