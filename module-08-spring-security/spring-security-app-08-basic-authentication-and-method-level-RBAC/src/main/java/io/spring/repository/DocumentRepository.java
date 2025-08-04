package io.spring.repository;

import io.spring.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByOwnerId(Long ownerId);

    List<Document> findByTitleContainingIgnoreCase(String title);

}
