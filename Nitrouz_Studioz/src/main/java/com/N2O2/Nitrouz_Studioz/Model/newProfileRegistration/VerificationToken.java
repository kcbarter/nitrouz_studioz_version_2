package com.N2O2.Nitrouz_Studioz.model.newProfileRegistration;

import com.N2O2.Nitrouz_Studioz.model.profileService.Profile;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "verification_token")
public class VerificationToken {
    private final static int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verfication_token_id")
    private long id;
    @Column(name = "token")
    private String token;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "expire_date")
    private Date expiredDate;
    @OneToOne(targetEntity = Profile.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    public VerificationToken(){

    }

    public VerificationToken(String token){
        this.token = token;
        this.expiredDate = calculateExpiredDate(EXPIRATION);
    }

    public VerificationToken(String token, Profile profile){
        Calendar calendar = Calendar.getInstance();

        this.token = token;
        this.profile = profile;
        this.createdDate = new Date(calendar.getTime().getTime());
        this.expiredDate = calculateExpiredDate(EXPIRATION);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    private Date calculateExpiredDate(int expiredTimeMinutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));

        calendar.add(Calendar.MINUTE, expiredTimeMinutes);
        return new Date(calendar.getTime().getTime());
    }
}
