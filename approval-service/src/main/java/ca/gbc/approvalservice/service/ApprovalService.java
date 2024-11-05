package ca.gbc.approvalservice.service;

import ca.gbc.approvalservice.model.Approval;
import ca.gbc.approvalservice.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    public Optional<Approval> getApprovalById(String id) {
        return approvalRepository.findById(id);
    }

    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    public Approval updateApproval(String id, Approval updatedApproval) {
        if (approvalRepository.existsById(id)) {
            updatedApproval.setId(id);
            return approvalRepository.save(updatedApproval);
        }
        return null;
    }

    public void deleteApproval(String id) {
        approvalRepository.deleteById(id);
    }
}
