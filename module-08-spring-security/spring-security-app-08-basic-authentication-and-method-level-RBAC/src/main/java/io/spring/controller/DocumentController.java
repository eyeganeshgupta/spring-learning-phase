package io.spring.controller;

import io.spring.model.Document;
import io.spring.response.ApiResponse;
import io.spring.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
@Tag(name = "Document Controller", description = "APIs for managing documents")
@SecurityRequirement(name = "basicAuth")
public class DocumentController {

    private final DocumentService documentService;
    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Operation(summary = "Create a new document")
    @PostMapping
    public ResponseEntity<ApiResponse<Document>> createDocument(@RequestBody Document document) {
        logger.info("Creating new document: {}", document);
        Document createdDocument = documentService.createDocument(document);
        ApiResponse<Document> response = new ApiResponse<>(true, "Document created successfully", createdDocument);
        logger.info("Document created successfully with ID: {}", createdDocument.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a document")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Document>> updateDocument(@PathVariable Long id, @RequestBody Document document) {
        logger.info("Updating document with ID: {}", id);
        Document updatedDocument = documentService.updateDocument(id, document);
        ApiResponse<Document> response = new ApiResponse<>(true, "Document updated successfully", updatedDocument);
        logger.info("Document with ID: {} updated successfully.", updatedDocument.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Delete a document by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteDocument(@PathVariable Long id) {
        logger.info("Deleting document with ID: {}", id);
        documentService.deleteDocument(id);
        ApiResponse<String> response = new ApiResponse<>(true, "Document deleted successfully", null);
        logger.info("Document with ID: {} deleted successfully.", id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Get a document by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Document>>> getDocument(@PathVariable Long id) {
        logger.info("Retrieving document with ID: {}", id);
        Optional<Document> document = documentService.getDocument(id);
        if (document.isPresent()) {
            ApiResponse<Optional<Document>> response = new ApiResponse<>(true, "Document retrieved successfully", document);
            logger.info("Document with ID: {} retrieved successfully.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ApiResponse<Optional<Document>> response = new ApiResponse<>(false, "Document not found", null);
            logger.warn("Document with ID: {} not found.", id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Get documents by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<Document>>> getDocumentsByUser(@PathVariable Long userId) {
        logger.info("Retrieving documents for user ID: {}", userId);
        List<Document> documents = documentService.getDocumentsByUser(userId);
        ApiResponse<List<Document>> response = new ApiResponse<>(true, "Documents retrieved successfully", documents);
        logger.info("Found {} documents for user ID: {}", documents.size(), userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Search documents by title", description = "Requires ADMIN, EDITOR, or VIEWER role")
    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EDITOR') or hasRole('VIEWER')")
    public ResponseEntity<ApiResponse<List<Document>>> searchDocuments(@RequestParam String title) {

        List<Document> docs = documentService.searchDocumentsByTitle(title);

        if (docs.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse<>(false, "No documents found", null));
        }

        return ResponseEntity.ok(new ApiResponse<>(true, "Documents found", docs));
    }

}
