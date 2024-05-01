package co.edu.icesi.sgiv.service.abstraction;

import co.edu.icesi.sgiv.dto.entity.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {
    public List<T> findAll();
    public Optional<T> findByID(ID id);
    public T save(T entity) throws Exception;
    public T update(T entity) throws Exception;
    public void delete(T entity) throws Exception;
    public void deleteById(ID id) throws Exception;
    public void validate(T entity) throws Exception;
    public long count();
}
