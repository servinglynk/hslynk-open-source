package com.servinglynk.hmis.warehouse.model.v2014;

import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;

import javax.persistence.*;

@javax.persistence.Entity(name = "bulk_upload_error")
@Table(name = "bulk_upload_error", catalog = "hmis", schema = "v2014")
public class Error2014 extends ErrorWarn{

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "v2014.error_sequence", schema = "v2014", catalog = "hmis", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "generator", strategy= GenerationType.SEQUENCE)
    public Long id;

}
