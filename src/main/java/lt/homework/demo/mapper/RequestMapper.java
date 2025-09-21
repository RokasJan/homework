package lt.homework.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import lt.homework.demo.model.Order;
import lt.homework.demo.model.requests.UpdateRequest;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestMapper {
    void updateServiceRequestFromUpdate(UpdateRequest update, @MappingTarget Order existing);
}
