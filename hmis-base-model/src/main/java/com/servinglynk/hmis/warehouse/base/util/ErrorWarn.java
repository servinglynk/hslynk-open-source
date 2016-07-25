package com.servinglynk.hmis.warehouse.base.util;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class ErrorWarn {

    @Basic( optional = true )
    @Column( name = "model_id", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    public UUID model_id;

    @Basic( optional = true )
    @Column( name = "bulk_upload_ui", nullable = true  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    public Long bulk_upload_ui;

    @Basic( optional = true )
    @Column( name = "project_group_code", nullable = true )
    public String project_group_code;

    @Basic( optional = true )
    @Column( name = "source_system_id", nullable = true )
    public String source_system_id;

    @Basic( optional = false )
    @Column( name = "type", nullable = false )
    @Enumerated(EnumType.STRING)
    public ErrorType type;

    @Basic( optional = true )
    @Column( name = "error_description", nullable = true )
    public String error_description;

    @Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
    @Basic( optional = true )
    @Column( name = "date_created" , nullable = true)
    public LocalDateTime date_created;
}
