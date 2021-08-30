package com.N2O2.Nitrouz_Studioz.model.followed_and_liked_profiles;

import java.io.Serializable;

public class LikedProfilesId implements Serializable {
    private long liked_Id;
    private long liker_Id;

    public LikedProfilesId(){

    }

    public long getLiked_Id(){
        return liked_Id;
    }

    public void setLiked_Id(long liked_Id){
        this.liked_Id = liked_Id;
    }

    public long getLiker_Id(){
        return liker_Id;
    }

    public void setLiker_Id(long liker_Id){
        this.liker_Id = liker_Id;
    }
}
