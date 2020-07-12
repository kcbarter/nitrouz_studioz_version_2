package com.N2O2.Nitrouz_Studioz.model.role;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface RoleDoa extends JpaRepository<RoleEntity, Integer> {

    public RoleEntity findByRoles(String role);
}
