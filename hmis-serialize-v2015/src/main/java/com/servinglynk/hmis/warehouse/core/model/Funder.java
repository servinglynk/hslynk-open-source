package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("funder")
public class Funder extends ClientModel{

    private UUID funderId;

    private LocalDateTime enddate;

    private Integer funder;

    private UUID grantid;

    private LocalDateTime startdate;



    public UUID getFunderId(){
        return funderId;
    }
    public void setFunderId(UUID funderId){
        this.funderId = funderId;
    }
    public LocalDateTime getEnddate(){
        return enddate;
    }
    public void setEnddate(LocalDateTime enddate){
        this.enddate = enddate;
    }
    public Integer getFunder(){
        return funder;
    }
    public void setFunder(Integer funder){
        this.funder = funder;
    }
    public UUID getGrantid(){
        return grantid;
    }
    public void setGrantid(UUID grantid){
        this.grantid = grantid;
    }
    public LocalDateTime getStartdate(){
        return startdate;
    }
    public void setStartdate(LocalDateTime startdate){
        this.startdate = startdate;
    }
 }
