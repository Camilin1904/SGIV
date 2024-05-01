package co.edu.icesi.sgiv.service.abstraction.type;

import co.edu.icesi.sgiv.domain.type.UserType;
import co.edu.icesi.sgiv.service.abstraction.GenericService;
import org.springframework.stereotype.Service;

@Service
public interface UserTypeService extends GenericService<UserType, Long> {
}
