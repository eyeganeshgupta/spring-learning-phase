package io.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Personal Information
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "gender", length = 15)
    private String gender;

    @Column(name = "address", length = 255)
    private String address;

    // Role and Status
    @Column(name = "role", length = 20, columnDefinition = "varchar(20) default 'USER'")
    private String role;

    @Column(name = "status", columnDefinition = "varchar(20) default 'ACTIVE'")
    private String status;

    // Timestamps
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public User(String name, String email, String phoneNumber, String gender, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender.toLowerCase(); // Ensure gender is stored in lowercase
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = (gender != null) ? gender.toLowerCase() : null;
    }

    public void setRole(String role) {
        this.role = (role != null) ? role.toUpperCase() : "USER";
    }

    public void setStatus(String status) {
        this.status = (status != null) ? status.toUpperCase() : "ACTIVE";
    }
}
