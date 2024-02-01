package com.tm30.softposclient.service.core.interfaces;


import com.tm30.softposclient.entities.Processor;
import com.tm30.softposclient.entities.users.Acquirer;

public interface ProcessorEntityService extends IService<Processor>{

    Processor findByAcquirerAndInstitutionBin(Acquirer acquirer, String id);
    Processor findByInstitutionBin(String bin);

}
