package com.kshrd.springdatajpacrud.service.resource;

import com.kshrd.springdatajpacrud.dto.request.ResourceRequest;
import com.kshrd.springdatajpacrud.entity.Resource;

import java.util.List;

public interface ResourceService {
    public List<Resource> getAllResources();

  public   Resource addRecource(ResourceRequest resourceRequest);
}
