package com.coderscampus.SpringSecurityJWTDemo.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User implements UserDetails {
    private static final long serialVersionUID = 2025389852147750927L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Authority> authorities = new ArrayList<>();
    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_reviews",
        	   joinColumns = @JoinColumn(name = "user_id"),
        	   inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviews = new ArrayList<>();
    
    /*
     * enable if you want to have the confirm password to be checked in the back end + their corresponding getters and setters
     * private String confirmPassword;
     */
    
  
    
    @Override
    public Collection<Authority> getAuthorities() {
        return authorities;
    }


	public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getUsername() {
        // email in our case
        return email;
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
    public String getPassword() {
        return this.password;
    }
    
    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public User email(String email) {
        this.email = email;
        return this;
    }

    public User authority(String authority) {
        Authority auth = new Authority(authority, this);
        this.getAuthorities().add(auth);
        return this;
    }
    
    public User password(String password) {
        this.password = password;
        return this;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }


    public User build () {
        return this;
    }
    
    public List<Review> getReviews() {
        return reviews;
    }

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + "]";
	}
    

}