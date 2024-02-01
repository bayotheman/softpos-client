package com.tm30.softposclient.service.jpa.specification;


import com.tm30.softposclient.entities.Processor;
import com.tm30.softposclient.entities.users.Acquirer;
import org.springframework.data.jpa.domain.Specification;

public final class ProcessorJpaSpecification {

    public static Specification<Processor> equalsId(String id){
        return (root, query, criteriaBuilder) -> {
            if(id == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("id"), id);
        };
    }

    public static Specification<Processor> equalsFactoryId(String id){
        return (root, query, criteriaBuilder) -> {
            if(id == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("factoryId"), id);
        };
    }

    public static Specification<Processor> equalsInstitutionBin(String bin){
        return (root, query, criteriaBuilder) -> {
            if(bin == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("institutionBin"), bin);
        };
    }

    public static Specification<Processor> equalsAcquirer(Acquirer acquirer){
        return (root, query, criteriaBuilder) -> {
            if(acquirer == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("acquirer"), acquirer);
        };
    }
}

