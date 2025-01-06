package com.kshrd.springdatajpacrud.dto.request;
import com.kshrd.springdatajpacrud.entity.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequest {
    private String resourceName;
    private String labelNo;
    private String description;
    private Integer resourceTypeId;
    private Integer createdBy;
}
