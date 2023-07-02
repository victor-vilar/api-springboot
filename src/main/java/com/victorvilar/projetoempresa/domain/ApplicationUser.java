package com.victorvilar.projetoempresa.domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="application_users")
public class ApplicationUser implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(name="users_roles", joinColumns = @JoinColumn(name="application_user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<ApplicationUserRole> applicationUserRoles = new HashSet<>();


    public ApplicationUser() {
    }

    public ApplicationUser(Long id, String username, String password, Set<ApplicationUserRole> applicationUserRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.applicationUserRoles = applicationUserRoles;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password){this.password = password;}
    @Override
    public String getPassword() {
        return this.password;
    }

    public void setRoles(Set<ApplicationUserRole> roles){
        this.applicationUserRoles = roles;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.applicationUserRoles;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUser that = (ApplicationUser) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(applicationUserRoles, that.applicationUserRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, applicationUserRoles);
    }
}
