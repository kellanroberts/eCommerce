package com.kellan.eCommerceProject.models;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	// UserDetails requires these, they are technically getters (is-ers?) overridden by Lombok.
	  // @Transient Makes it so these aren't persisted in the database, as they are hard coded.
	  // @Transient
	 // private boolean accountNonExpired = true;
	 // @Transient
	 // private boolean accountNonLocked = true;
	 // @Transient
	 // private boolean credentialsNonExpired = true;
	 // @Transient
	 // private boolean enabled = true;
	 // @Transient
	 // private Collection<GrantedAuthority> authorities = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	 @Email(message = "Please provide a valid email")
	    @NotEmpty(message = "Please provide an email")
	    private String email;

	    @NotEmpty(message = "Please provide a username")
	    @Length(min = 3, message = "Your username must have at least 3 characters")
	    @Length(max = 15, message = "Your username cannot have more than 15 characters")
	    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
	    private String username;

	    @Length(min = 5, message = "Your password must have at least 5 characters")
	    @NotEmpty(message = "Please provide a password")
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private String password;

	    @NotEmpty(message = "Please provide your first name")
	    private String firstName;

	    @NotEmpty(message = "Please provide your last name")
	    private String lastName;

	    private int active;
	
	@ElementCollection
	private HashMap <Product, Integer> cart= new HashMap <Product, Integer>();
	
}