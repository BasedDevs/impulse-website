package com.baseddevs.impulsebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role_permissions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Role cannot be null")
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @NotNull(message = "Permission cannot be null")
    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

}
