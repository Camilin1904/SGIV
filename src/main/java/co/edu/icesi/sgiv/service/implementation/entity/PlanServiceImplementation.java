package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Plan;
import co.edu.icesi.sgiv.domain.entity.PlanDetail;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.dto.entity.DestinationDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDTO;
import co.edu.icesi.sgiv.dto.entity.PlanDetailDTO;
import co.edu.icesi.sgiv.mapper.entity.DestinationMapper;
import co.edu.icesi.sgiv.mapper.entity.PlanMapper;
import co.edu.icesi.sgiv.repository.entity.ClientRepository;
import co.edu.icesi.sgiv.repository.entity.PlanDetailRepository;
import co.edu.icesi.sgiv.repository.entity.PlanRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PlanServiceImplementation implements PlanService {
    

    PlanMapper planMapper = PlanMapper.INSTANCE;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PlanDetailRepository planDetailRepository;

    DestinationMapper destinationMapper = DestinationMapper.INSTANCE;

    @Override
    public Optional<PlanDTO> findByID(Long aLong) {
        Optional<Plan> plan = planRepository.findById(aLong);
        if(plan.isPresent())
            return Optional.of(planMapper.toDTO(plan.get()));
        else
            return Optional.empty();
    }

    @Override
    public PlanDTO save(PlanDTO entity) throws Exception {
        if (planRepository.findById(entity.getId()).isPresent())
            throw new Exception("The entity already exists.");
        else{
            Plan plan = planMapper.toEntity(entity);
            return planMapper.toDTO(planRepository.save(plan));
        }

    }

    @Override
    public PlanDTO update(PlanDTO entity) throws Exception {
        if (planRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            Plan plan = planMapper.toEntity(entity);
            return planMapper.toDTO(planRepository.save(plan));
        }
    }

    @Override
    public void delete(PlanDTO entity) throws Exception {
        if (planRepository.findById(entity.getId()).isEmpty())
            throw new Exception("The entity does not exist.");
        else{
            Plan plan = planMapper.toEntity(entity);
            planRepository.delete(plan);
        }
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        planRepository.delete(planRepository.findById(aLong).get());
    }

    @Override
    public void validate(PlanDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return planRepository.count();
    }

    @Override
    public List<PlanDTO> findAll() {
        List<Plan> dest = planRepository.findAll();
        return dest.stream().map(planMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlanDTO> findPlanByClient(ClientDTO clientDTO) {
        Client client = clientRepository.findById(clientDTO.getId()).get();
        List<Plan> dest = planRepository.findPlanByClient(client);
        return dest.stream().map(planMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlanDTO> findPlanByStartDateBetween(Date beginning, Date end) {
        List<Plan> dest = planRepository.findPlanByStartDateBetween(beginning,end);
        return dest.stream().map(planMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlanDTO> findPlanByPlanDetail(PlanDetailDTO planDetailDTO) {
        PlanDetail planDetail = planDetailRepository.findById(planDetailDTO.getId()).get();
        List<Plan> dest = planRepository.findPlanByPlanDetail(planDetail);
        return dest.stream().map(planMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlanDTO> findByValue(Double value) {
        List<Plan> dest = planRepository.findByValue(value);
        return dest.stream().map(planMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DestinationDTO> getDestinations(Long pID) {
        List<Destination> dest = planRepository.getDestinations(pID);

        return dest.stream().map(destinationMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<Long> getMostPopularDestination(){
        return planRepository.getMostPopularDestination();
    };

    public List<Plan> findByCreationDate(Date date){
        return planRepository.findByCreationDate(date);
    }

    public Long countByCreationDate(Date date){
        return planRepository.countByCreationDate(date);
    }

    public Optional<Long> getLeastPopularDestination(){
        return planRepository.getLeastPopularDestination();
    }

    public Optional<Long> getTotalEarnings(){
        return planRepository.getTotalEarnings();
    }

    @Override
    public Optional<Long> getMostPopularPlanDetail() {
        return planRepository.getMostPopularPlanDetail();
    }

    public Page<PlanDTO> findAll(Pageable pageable){
        Page<Plan> planPage = planRepository.findAll(pageable);
        return planPage.map(planMapper::toDTO);
    }

    public Page<PlanDTO> findByFilter(String code,Double tvm, Double tvl, String clientName, String status, Pageable pageable){
        Page<Plan> planResult = planRepository.findByFilter(code,tvm,tvl,clientName,status,pageable);
        return planResult.map(planMapper::toDTO);
    }


}
