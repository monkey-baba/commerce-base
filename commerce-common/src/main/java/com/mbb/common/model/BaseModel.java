package com.mbb.common.model;

import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;

@Data
public class BaseModel {

    @Id
    private Long id;

    @Version
    private Integer version;

}
