package com.N2O2.Nitrouz_Studioz.profile;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.role.RoleEntity;
import com.N2O2.Nitrouz_Studioz.model.role.Roles;
import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ProfileEntityTest {
    private BuildProfileEntity buildProfileEntity;

    @BeforeEach
    public void intializeProfile(){
        buildProfileEntity = new BuildProfileEntity();
        buildProfileEntity.buildProfile();
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetThePrimaryKey(){
        Assertions.assertEquals(java.util.Optional.of(1L), java.util.Optional.of(buildProfileEntity.profileEntity.getId()));
    }
    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewPK(){
        buildProfileEntity.profileEntity.setId(2L);
        Assertions.assertEquals(java.util.Optional.of(2L), java.util.Optional.of(buildProfileEntity.profileEntity.getId()));
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetTheProfilePic(){
        Assertions.assertEquals("LeBron_img.jpg", buildProfileEntity.profileEntity.getProfilePic());
    }

    @Nested
    public class BuildProfileEntity {
        private ProfileEntity profileEntity;
        private Long id = 1L;
        private String profilePic = "LeBron_img.jpg";
        private String profileName = "King";
        private String name = "King James";
        private String email = "KingDev@msn.com";
        private String about = "I'm a Software Engineer and Ready to code for your company!";
        private String phone = "(111)123-4567";
        private String password = "King James";
        private boolean likes = true;
        private boolean comments = true;
        private boolean follows = true;
        private boolean general = true;
        private boolean enabled = true;

        public void buildProfile(){
            profileEntity = new ProfileEntity();
            profileEntity.setId(id);
            profileEntity.setProfilePic(profilePic);
            profileEntity.setProfileName(profileName);
            profileEntity.setName(name);
            profileEntity.setEmail(email);
            profileEntity.setAbout(about);
            profileEntity.setPhone(phone);
            profileEntity.setPassword(password);
            profileEntity.setLikes(likes);
            profileEntity.setLikes(comments);
            profileEntity.setFollows(follows);
            profileEntity.setGeneral(general);
            profileEntity.setEnabled(enabled);
            HashSet<RoleEntity> role = new HashSet<>();
            role.add(buildRoles(1, Roles.USER.name().toUpperCase()));
            role.add(buildRoles(2, Roles.ADMIN.name().toUpperCase()));
            profileEntity.setRoles(role);

        }

        private RoleEntity buildRoles(int id, String role) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setId(id);
            roleEntity.setRoles(role);

            return roleEntity;
        }


    }
}
