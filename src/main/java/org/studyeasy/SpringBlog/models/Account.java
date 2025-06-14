package org.studyeasy.SpringBlog.models;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private String role; 

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
        name="account_authority",
        joinColumns = {@JoinColumn(name="account_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public String toString() {
        return "Account [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
                + ", lastname=" + lastname + ", role=" + role + ", posts=" + posts + ", authorities=" + authorities
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }


    
}
