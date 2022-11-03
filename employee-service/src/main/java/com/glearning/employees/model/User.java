package com.glearning.employees.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.FetchType;
import javax.persistence.*;

import org.apache.catalina.Role;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;

    private String username;

    private String password;

    private String emailAddress;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;

    	public void addRole(Role role) {
    		if(this.roles == null) {
    			this.roles = new HashSet<>();
    		}
    		this.roles.add(role);
    		role.setUser(this);
    	}

}

