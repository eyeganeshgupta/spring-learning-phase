package com.organizeu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Todo.TABLE_NAME)
public class Todo {

    public static final String TABLE_NAME = "todos";
    public static final String COL_TITLE = "title";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_IS_COMPLETED = "is_completed";
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_UPDATED_AT = "updated_at";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = COL_TITLE, nullable = false, length = 100)
    private String title;

    @Column(name = COL_DESCRIPTION, nullable = false, length = 500)
    private String description;

    @Column(name = COL_IS_COMPLETED, nullable = false)
    private boolean isCompleted;

    @CreationTimestamp
    @Column(name = COL_CREATED_AT, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = COL_UPDATED_AT)
    private LocalDateTime updatedAt;
}
