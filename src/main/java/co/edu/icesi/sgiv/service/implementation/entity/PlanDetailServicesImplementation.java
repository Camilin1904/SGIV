package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.domain.status.PlanDetailStatus;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.dto.status.PlanDetailStatusDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import co.edu.icesi.sgiv.mapper.entity.PlanDetailMapper;
import co.edu.icesi.sgiv.mapper.status.PlanDetailStatusMapper;
import co.edu.icesi.sgiv.repository.entity.PlanDetailRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanDetailServicesImplementation implements PlanDetailService {
    
    @Autowired
    PlanDetailRepository planDetailRepository;

    PlanDetailMapper planDetailMapper = PlanDetailMapper.INSTANCE;

    DestinationMapper destinationMapper = DestinationMapper.INSTANCE;

    PlanDetailStatusMapper planDetailStatusMapper = PlanDetailStatusMapper.INSTANCE;
    
    
    @Override
    public Optional<PlanDetailDTO> findByID(Long aLong) {
        Optional<PlanDetail> planDetail = planDetailRepository.findById(aLong);
        return planDetail.map(detail -> planDetailMapper.toDTO(detail));
    }

    @Override
    public PlanDetailDTO save(PlanDetailDTO entity) throws Exception {
        if (planDetailRepository.findById(entity.getId()).isPresent())
            throw new Exception("The entity already exists.");
        else{
            PlanDetail planDetail = planDetailMapper.toEntity(entity);
            return planDetailMapper.toDTO(planDetailRepository.save(planDetail));
        }

    }

    @Override
    public PlanDetailDTO update(PlanDetailDTO entity) throws Exception {
        if (planDetailRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            PlanDetail planDetail = planDetailMapper.toEntity(entity);
            return planDetailMapper.toDTO(planDetailRepository.save(planDetail));
        }
    }

    @Override
    public void delete(PlanDetailDTO entity) throws Exception {
        if (planDetailRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            PlanDetail planDetail = planDetailMapper.toEntity(entity);
            planDetailRepository.delete(planDetail);
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        planDetailRepository.delete(planDetailRepository.findById(aLong).get());
    }

    @Override
    public void validate(PlanDetailDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return planDetailRepository.count();
    }

    @Override
    public List<PlanDetailDTO> findAll() {
        List<PlanDetail> dest = planDetailRepository.findAll();
        return dest.stream().map(planDetailMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DestinationDTO> getDestinations(Long planDID) {
        List<Destination> dest = planDetailRepository.getDestinations(planDID);
        return dest.stream().map(destinationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PlanDetailStatusDTO> getStatus(Long PlanDID) {
        Optional<PlanDetailStatus> dest = planDetailRepository.getStatus(PlanDID);
        return dest.map(planDetailStatus -> planDetailStatusMapper.toDTO(planDetailStatus));
    }

    public Page<PlanDetailDTO> findAll(Pageable pageable){
        Page<PlanDetail> planDetails = planDetailRepository.findAll(pageable);
        return planDetails.map(planDetailMapper::toDTO);
    }

    public Long countAll(){
        return planDetailRepository.count();
    }

}
