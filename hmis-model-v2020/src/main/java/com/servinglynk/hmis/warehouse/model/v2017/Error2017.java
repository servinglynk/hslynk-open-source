package com.servinglynk.hmis.warehouse.model.v2017;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.servinglynk.hmis.warehouse.base.util.ErrorWarn;

@javax.persistence.Entity(name = "bulk_upload_error")
@Table(name = "bulk_upload_error", catalog = "hmis", schema = "v2017")
public class Error2017 extends ErrorWarn {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "v2017.error_sequence", schema = "v2017", catalog = "hmis", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "generator", strategy= GenerationType.SEQUENCE)
    public Long id;
}
