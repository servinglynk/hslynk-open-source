package com.servinglynk.hmis.warehouse.model.v2016;

import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;

import javax.persistence.*;

@javax.persistence.Entity(name = "bulk_upload_error")
@Table(name = "bulk_upload_error", catalog = "hmis", schema = "v2016")
public class Error2016 extends ErrorWarn {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "v2016.error_sequence", schema = "v2016", catalog = "hmis", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "generator", strategy= GenerationType.SEQUENCE)
    public Long id;
}
