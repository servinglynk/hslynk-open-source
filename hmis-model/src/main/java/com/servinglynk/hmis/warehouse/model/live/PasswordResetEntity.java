package com.servinglynk.hmis.warehouse.model.live;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * Model class representing a password reset.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_password_reset")

public class PasswordResetEntity extends BaseModel{
   
	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
    private UUID id;

    @Column(name = "new_password")
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "verification_id", nullable = false, referencedColumnName = "id")
    private VerificationEntity verification;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private HmisUser account;

    @Column(name = "status")
    private String status;


    public UUID getId() {
        return this.id;
    }


    protected void setId(UUID id) {
        this.id = id;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VerificationEntity getVerification() {
        return this.verification;
    }

    public void setVerification(VerificationEntity verification) {
        this.verification = verification;
    }

    public HmisUser getAccount() {
        return this.account;
    }

    public void setAccount(HmisUser account) {
        this.account = account;
    }
    
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
