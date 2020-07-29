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
        String testProfilePic = "LeBron_img.jpg";
        Assertions.assertEquals(testProfilePic, buildProfileEntity.profileEntity.getProfilePic());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewProfilePic(){
        String newTestProfilePic = "Kobe_img.jpg";
        buildProfileEntity.profileEntity.setProfilePic(newTestProfilePic);
        Assertions.assertEquals(newTestProfilePic, buildProfileEntity.profileEntity.getProfilePic());
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetProfileName(){
        String testProfileName = "King";
        Assertions.assertEquals(testProfileName, buildProfileEntity.profileEntity.getProfileName());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewProfileName(){
        String newTestProfileName = "Kobe";
        buildProfileEntity.profileEntity.setProfileName(newTestProfileName);
        Assertions.assertEquals(newTestProfileName, buildProfileEntity.profileEntity.getProfileName());
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetTheName(){
        String testName = "King James";
        Assertions.assertEquals(testName, buildProfileEntity.profileEntity.getName());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewName(){
        String newTestName = "Black Mamba";
        buildProfileEntity.profileEntity.setName(newTestName);
        Assertions.assertEquals(newTestName, buildProfileEntity.profileEntity.getName());
    }

    @Test
    public void whenIHaveAProfileThenICanGetTheEmail(){
        String testEmail = "KingDev@msn.com";
        Assertions.assertEquals(testEmail, buildProfileEntity.profileEntity.getEmail());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewEmail(){
        String newTestEmail = "BlackMamba@msn.com";
        buildProfileEntity.profileEntity.setEmail(newTestEmail);
        Assertions.assertEquals(newTestEmail, buildProfileEntity.profileEntity.getEmail());
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetAboutInfo(){
        String testAbout = "I'm a Software Engineer and Ready to code for your company!";
        Assertions.assertEquals(testAbout, buildProfileEntity.profileEntity.getAbout());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewAboutInfo(){
        String testNewAbout = "I'm a basketball player and playing in the NBA. I also enjoy Gaming";
        buildProfileEntity.profileEntity.setAbout(testNewAbout);
        Assertions.assertEquals(testNewAbout, buildProfileEntity.profileEntity.getAbout());
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetThePhoneNumber(){
        String testPhone = "(111)123-4567";
        Assertions.assertEquals(testPhone, buildProfileEntity.profileEntity.getPhone());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewPhoneNumber(){
        String newTestPhone = "(222)234-7687";
        buildProfileEntity.profileEntity.setPhone(newTestPhone);
        Assertions.assertEquals(newTestPhone, buildProfileEntity.profileEntity.getPhone());
    }

    @Test
    public void whenIHaveAProfileEntityThenICanGetThePassword(){
        String testPassword = "King James";
        Assertions.assertEquals(testPassword, buildProfileEntity.profileEntity.getPassword());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewPassword(){
        String newTestPassword = "BlackMamba";
        buildProfileEntity.profileEntity.setPassword(newTestPassword);
        Assertions.assertEquals(newTestPassword, buildProfileEntity.profileEntity.getPassword());
    }

    @Test
    public void whenIHaveAProfileEntityICanGetTheBooleanValueOfLikes(){
        Assertions.assertTrue(buildProfileEntity.profileEntity.isLikes());
    }

    @Test
    public void whenISetProfileEntityToANewEntityThenICanGetTheNewBooleanValueOfLikes(){
        boolean newLikes = false;
        buildProfileEntity.profileEntity.setLikes(newLikes);
        Assertions.assertFalse(buildProfileEntity.profileEntity.isLikes());
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
