package com.servinglynk.hmis.warehouse.model.v2017;

import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;

import javax.persistence.*;

@javax.persistence.Entity(name = "bulk_upload_error")
@Table(name = "bulk_upload_error", catalog = "hmis", schema = "v2017")
public class Error2017 extends ErrorWarn {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "v2017.error_sequence", schema = "v2017", catalog = "hmis", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "generator", strategy= GenerationType.SEQUENCE)
    public Long id;
}
