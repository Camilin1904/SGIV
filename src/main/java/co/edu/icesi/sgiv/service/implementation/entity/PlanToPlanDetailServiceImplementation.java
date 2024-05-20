package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.PlanToPlanDetail;
import co.edu.icesi.sgiv.dto.entity.PlanToPlanDetailDTO;
import co.edu.icesi.sgiv.dto.entity.PlanToPlanDetailDTO;
import co.edu.icesi.sgiv.mapper.entity.PlanToPlanDetailMapper;
import co.edu.icesi.sgiv.repository.entity.PlanToPlanDetailRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanToPlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanToPlanDetailServiceImplementation implements PlanToPlanDetailService {
    
    @Autowired
    private PlanToPlanDetailRepository planToPlanDetailRepository;

    private final PlanToPlanDetailMapper planToPlanDetailMapper = PlanToPlanDetailMapper.INSTANCE;

    @Override
    public Page<PlanToPlanDetailDTO> findAll(Pageable page) {
        Page<PlanToPlanDetail> planToPlanDetail = planToPlanDetailRepository.findAll(page);
        return planToPlanDetail.map(planToPlanDetailMapper::toDTO);
    }

    @Override
    public List<PlanToPlanDetailDTO> findAll() {
        List<PlanToPlanDetail> planToPlanDetail = planToPlanDetailRepository.findAll();
        return planToPlanDetail.stream().map(planToPlanDetailMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PlanToPlanDetailDTO> findByID(Long aLong) {
        Optional<PlanToPlanDetail> planToPlanDetail = planToPlanDetailRepository.findById(aLong);
        return planToPlanDetail.map(planToPlanDetailMapper::toDTO);
    }

    @Override
    public PlanToPlanDetailDTO save(PlanToPlanDetailDTO entity) throws Exception {
        if(!planToPlanDetailRepository.existsById(entity.getId()))
            return planToPlanDetailMapper.toDTO(planToPlanDetailRepository.findById(entity.getId()).get());
        else
            throw new Exception("The planToPlanDetail already exists");
    }

    @Override
    public PlanToPlanDetailDTO update(PlanToPlanDetailDTO entity) throws Exception {
        if(planToPlanDetailRepository.existsById(entity.getId()))
            return planToPlanDetailMapper.toDTO(planToPlanDetailRepository.findById(entity.getId()).get());
        else
            throw new Exception("The planToPlanDetail does not exists");
    }

    @Override
    public void delete(PlanToPlanDetailDTO entity) throws Exception {
        if(planToPlanDetailRepository.existsById(entity.getId()))
            planToPlanDetailRepository.delete(planToPlanDetailRepository.findById(entity.getId()).get());
        else
            throw new Exception("The planToPlanDetail does not exists");
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(planToPlanDetailRepository.existsById(aLong))
            planToPlanDetailRepository.deleteById(aLong);
        else
            throw new Exception("The planToPlanDetail does not exists");
    }

    @Override
    public void validate(PlanToPlanDetailDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return planToPlanDetailRepository.count();
    }
}
