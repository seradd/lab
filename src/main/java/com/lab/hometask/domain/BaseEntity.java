package com.lab.hometask.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Persistable<ID>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(
            name = "base_seq_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.OPT_PARAM, value = "pooled-lo"),
                    @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1000"),
                    @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
                    @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "BASE_SEQ"),
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_seq_generator")
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0, columnDefinition = "NUMERIC")
    protected ID id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(), getId());
    }

    @Override
    public boolean isNew() {
        return getId() == null;
    }
}
