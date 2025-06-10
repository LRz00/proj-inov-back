package com.ifba.proj_inov.core.repository.projection;

public interface UserDetailsProjection {
    String getEmail();
    String getPassword();
    Long getRoleId();
    String getAuthority();
}
