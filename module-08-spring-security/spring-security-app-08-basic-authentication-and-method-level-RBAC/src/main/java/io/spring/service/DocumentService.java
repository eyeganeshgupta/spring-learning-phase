package io.spring.service;

import io.spring.model.Document;
import io.spring.model.User;
import io.spring.repository.DocumentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @PreAuthorize("hasRole('ADMIN') or (hasRole('EDITOR') and @documentService.isOwner(#documentId, principal))")
    public Document updateDocument(Long documentId, Document document) {
        Document existingDocument = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        existingDocument.setTitle(document.getTitle());
        existingDocument.setContent(document.getContent());
        return documentRepository.save(existingDocument);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('EDITOR') or hasRole('VIEWER')")
    public Optional<Document> getDocument(Long documentId) {
        return documentRepository.findById(documentId);
    }

    public boolean isOwner(Long documentId, Object principal) {
        User user = (User) principal;
        Document document = documentRepository.findById(documentId).orElse(null);
        return document != null && document.getOwner().getId().equals(user.getId());
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('EDITOR') or hasRole('VIEWER')")
    public List<Document> getDocumentsByUser(Long userId) {
        return documentRepository.findByOwnerId(userId);
    }

    public List<Document> searchDocumentsByTitle(String title) {
        return documentRepository.findByTitleContainingIgnoreCase(title);
    }
}
