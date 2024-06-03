package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Meals;
import co.edu.icesi.sgiv.dto.entity.MealsDTO;
import co.edu.icesi.sgiv.dto.entity.MealsDTO;
import co.edu.icesi.sgiv.mapper.entity.MealsMapper;
import co.edu.icesi.sgiv.repository.entity.MealsRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealsServiceImplementation implements MealsService {

    @Autowired
    private MealsRepository mealsRepository;

    private final MealsMapper mealsMapper = MealsMapper.INSTANCE;
    @Override
    public Page<MealsDTO> findAll(Pageable page) {
        Page<Meals> mealss = mealsRepository.findAll(page);
        return mealss.map(mealsMapper::toDTO);
    }

    @Override
    public List<MealsDTO> findAll() {
        List<Meals> mealss = mealsRepository.findAll();
        return mealss.stream().map(mealsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<MealsDTO> findByID(Long aLong) {
        Optional<Meals> meals = mealsRepository.findById(aLong);
        return meals.map(mealsMapper::toDTO);
    }

    @Override
    public MealsDTO save(MealsDTO entity) throws Exception {
        if(!mealsRepository.existsById(entity.getId()))
            return mealsMapper.toDTO(mealsRepository.findById(entity.getId()).get());
        else
            throw new Exception("Meals already exists");
    }

    @Override
    public MealsDTO update(MealsDTO entity) throws Exception {
        if(mealsRepository.existsById(entity.getId()))
            return mealsMapper.toDTO(mealsRepository.findById(entity.getId()).get());
        else
            throw new Exception("Meals does not exist");
    }

    @Override
    public void delete(MealsDTO entity) throws Exception {
        if(mealsRepository.existsById(entity.getId()))
            mealsRepository.delete(mealsRepository.findById(entity.getId()).get());
        else
            throw new Exception("Meals does not exist");
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(mealsRepository.existsById(aLong))
            mealsRepository.deleteById(aLong);
        else
            throw new Exception("Meals does not exist");
    }

    @Override
    public void validate(MealsDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return mealsRepository.count();
    }

    public Page<MealsDTO> findByFilter(@Param("name") String name, @Param("status") String status, Pageable page){
        return mealsRepository.findByFilter(name,status,page).map(mealsMapper::toDTO);
    }
}
