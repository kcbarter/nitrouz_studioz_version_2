package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import java.io.Serializable;

public class FollowedProfilesId implements Serializable {
    private long followed_Id;
    private long follower_Id;

    public FollowedProfilesId(){

    }

    public long getFollowed_Id() {
        return followed_Id;
    }

    public void setFollowed_Id(long followed_Id) {
        this.followed_Id = followed_Id;
    }

    public long getFollower_Id() {
        return follower_Id;
    }

    public void setFollower_Id(long follower_Id) {
        this.follower_Id = follower_Id;
    }
}
