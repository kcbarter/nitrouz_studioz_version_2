package com.N2O2.Nitrouz_Studioz.model.newProfileRegistration;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface VerificationTokenDoa extends JpaRepository<VerificationTokenEntity, Long> {

}
