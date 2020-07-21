package com.N2O2.Nitrouz_Studioz.profile;

import com.N2O2.Nitrouz_Studioz.model.profile.ProfileEntity;
import com.N2O2.Nitrouz_Studioz.model.role.RoleEntity;
import com.N2O2.Nitrouz_Studioz.model.role.Roles;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class ProfileEntityTest {
    private BuildProfileEntity buildProfileEntity;

    @BeforeEach
    public void intializeProfile(){
        buildProfileEntity = new BuildProfileEntity();
        buildProfileEntity.buildProfile();
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
            role.add(buildRoles(role));
            profileEntity.setRoles(role);

        }

        private RoleEntity buildRoles(HashSet<RoleEntity> role) {
            RoleEntity roleEntityOne = new RoleEntity();
            RoleEntity roleEntityTwo = new RoleEntity();
            roleEntityOne.setId(1);
            roleEntityOne.setRoles(Roles.USER.name().toUpperCase());
            roleEntityTwo.setId(2);
            roleEntityTwo.setRoles(Roles.ADMIN.name().toUpperCase());
            role.add(roleEntityOne);
            role.add(roleEntityTwo);
        }


    }
}
