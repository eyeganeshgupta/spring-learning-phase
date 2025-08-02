package io.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique id of the document", example = "101")
    private Long id;

    @Schema(description = "Title of the document", example = "API Design Guide")
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private User owner;

    public Document(String title, String content, User owner) {
        this.title = title;
        this.content = content;
        this.owner = owner;
    }

}
