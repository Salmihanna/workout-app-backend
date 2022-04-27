package com.js.workoutappbackend.security;


import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;
import static com.js.workoutappbackend.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, ADMIN_READ, ADMIN_WRITE ));

    // INIT
    private final Set<ApplicationUserPermission> permissions;

    // CONSTRUCTOR
    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    // GETTER
    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    // Boiler plate code - .authorities()
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
