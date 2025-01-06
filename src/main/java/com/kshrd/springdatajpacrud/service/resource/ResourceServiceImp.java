package com.kshrd.springdatajpacrud.service.resource;

import com.kshrd.springdatajpacrud.dto.request.ResourceRequest;
import com.kshrd.springdatajpacrud.entity.Resource;
import com.kshrd.springdatajpacrud.entity.ResourceType;
import com.kshrd.springdatajpacrud.entity.User;
import com.kshrd.springdatajpacrud.exception.specificException.NotFoundException;
import com.kshrd.springdatajpacrud.repository.ResourceRepository;
import com.kshrd.springdatajpacrud.repository.ResourceTypeRepository;
import com.kshrd.springdatajpacrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResourceServiceImp implements ResourceService {
    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;
    private final ResourceTypeRepository resourceTypeRepository;

    public ResourceServiceImp(ResourceRepository resourceRepository, UserRepository userRepository, ResourceTypeRepository resourceTypeRepository) {
        this.resourceRepository = resourceRepository;
        this.userRepository = userRepository;
        this.resourceTypeRepository = resourceTypeRepository;
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource addRecource(ResourceRequest resourceRequest) {
        Resource resource = new Resource();

        resource.setResourceName(resourceRequest.getResourceName());
        resource.setDescription(resourceRequest.getDescription());
        resource.setLabelNo(resourceRequest.getLabelNo());
        resource.setImportedOn(Timestamp.valueOf(LocalDateTime.now()));
        //type, and user need to find before request
        if (resourceTypeRepository.existsById(resourceRequest.getResourceTypeId()) && userRepository.existsById(resourceRequest.getCreatedBy())) {
            ResourceType resourceType = resourceTypeRepository.findById(resourceRequest.getResourceTypeId()).orElse(null);
            resource.setResourceType(resourceType);

            User user = userRepository.findById(resourceRequest.getCreatedBy()).orElse(null);
            resource.setUser(user);

            return resourceRepository.save(resource);
        } else {
            throw new NotFoundException("Please check user id and resource type id");
        }


    }
}
