package com.N2O2.Nitrouz_Studioz.model.service;

import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenDoa;
import com.N2O2.Nitrouz_Studioz.model.newProfileRegistration.VerificationTokenEntity;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileDoa;
import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.role.RoleDoa;
import com.N2O2.Nitrouz_Studioz.model.role.RoleEntity;
import com.N2O2.Nitrouz_Studioz.model.role.Roles;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileDoa profileDoa;
    private VerificationTokenEntity verificationTokenEntity;
    @Autowired
    private VerificationTokenDoa verificationTokenDoa;
    private RoleDoa roleDoa;

    @Autowired
    JavaMailSender javaMailSender;

    public void createProfile(boolean join, ProfileEntity profileEntity){
        profileEntity.setLikes(join);
        profileEntity.setComments(join);
        profileEntity.setFollows(join);
        profileEntity.setGeneral(join);
        profileEntity.setEnabled(false);
        profileDoa.save(profileEntity);

        confirmEmail(profileEntity);
    }

    public void updateProfile(ProfileEntity profileEntity){
        profileDoa.save(profileEntity);
    }

    public void newVerificationToken(ProfileEntity profileEntity){
        confirmEmail(profileEntity);
    }

    public boolean emailExists(String email){
        return profileDoa.findByEmail(email) != null;
    }


    private void confirmEmail(ProfileEntity profileEntity){
        String token = UUID.randomUUID().toString();
        verificationTokenEntity = new VerificationTokenEntity(token, profileEntity);
        verificationTokenDoa.save(verificationTokenEntity);

        String email = profileEntity.getEmail();
        String subject = "Please Confirm Your Email";
        String confirmationURL = "/registrationComplete?token=" + token;
        String message = "Thanks for creating and joining th community of Nitrouz Studioz."
            + "/nThere is one last step to activate your account. Please click the link below to activate your account!";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message + "\r\n" + "http://localhost:8080" + confirmationURL);
        javaMailSender.send(simpleMailMessage);
    }

    public VerificationTokenEntity getVerificationToken(String token){
        return verificationTokenDoa.findByToken(token);
    }

    public void createRole(ProfileEntity profileEntity){
        //todo check to see if this works and prints out a string
        RoleEntity roleEntity = new RoleEntity(profileEntity);
        roleEntity.setRoles(Roles.USER);
        roleDoa.save(roleEntity);
        System.out.println(roleEntity.getRoleAsString(roleEntity.getRoles()));
    }
}
