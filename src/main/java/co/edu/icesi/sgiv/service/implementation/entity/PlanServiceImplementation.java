package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.*;
import co.edu.icesi.sgiv.dto.entity.*;
import co.edu.icesi.sgiv.mapper.entity.*;
import co.edu.icesi.sgiv.repository.entity.ClientRepository;
import co.edu.icesi.sgiv.repository.entity.PlanDetailRepository;
import co.edu.icesi.sgiv.repository.entity.PlanRepository;
import co.edu.icesi.sgiv.repository.entity.UserRepository;
import co.edu.icesi.sgiv.request.CreatePlanRequest;
import co.edu.icesi.sgiv.service.abstraction.entity.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
    UserRepository userRepository;
    @Autowired
    PlanDetailRepository planDetailRepository;

    DestinationMapper destinationMapper = DestinationMapper.INSTANCE;
    ClientMapper clientMapper = ClientMapper.INSTANCE;
    UserMapper userMapper = UserMapper.INSTANCE;

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

    public Page<PlanDTO> findByFilter(String code,Double tvm, Double tvl, String status, Pageable pageable){
        try{
            Page<Plan> planResult = planRepository.findByFilter(code,tvm,tvl,status,pageable);
            return planResult.map(planMapper::toDTO);
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Object[]> getPlansCountByDateLast30Days() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(30);
        return planRepository.findPlansCountByDateBetween(startDate, endDate);
    }

    public PlanDTO createPlan(CreatePlanRequest createPlanRequest) {
        Long userId = createPlanRequest.getUser().getId();
        Long clientId = createPlanRequest.getClient().getId();

        System.out.println(createPlanRequest);
        System.out.println(userId);
        System.out.println(clientId);

        Optional<User> oUser = userRepository.findById(userId);
        Optional<Client> oClient = clientRepository.findById(clientId);

        if(oUser.isPresent() && oClient.isPresent()){
            User user = oUser.get();
            Client client = oClient.get();

            Plan plan = new Plan();
            plan.setCode(createPlanRequest.getCode());
            plan.setNumberOfPeople(createPlanRequest.getNumberOfPeople());
            plan.setCreationDate(new Date(System.currentTimeMillis()));
            plan.setUser(user);
            plan.setClient(client);
            plan.setStatus("Activo");
            plan.setTotalValue(0.0);

            List<PlanToPlanDetail> planToPlanDetails = new ArrayList<>();

            for (PlanToPlanDetailDTO detailDTO : createPlanRequest.getPlanDetails()) {
                PlanDetail planDetail = planDetailRepository.findById(detailDTO.getPlanDetail().getId()).orElseThrow();
                PlanToPlanDetail planToPlanDetail = new PlanToPlanDetail();
                planToPlanDetail.setPlan(plan);
                planToPlanDetail.setPlanDetail(planDetail);
                planToPlanDetail.setStartDate(detailDTO.getStartDate());
                planToPlanDetail.setEndDate(detailDTO.getEndDate());
                planToPlanDetail.setStatus("Activo");

                plan.setTotalValue(plan.getTotalValue() + planToPlanDetail.getPlanDetail().getValue()*plan.getNumberOfPeople());
                planToPlanDetails.add(planToPlanDetail);
            }

            plan.setPlanDetail(planToPlanDetails);

            Date startDate = planToPlanDetails.stream().map(PlanToPlanDetail::getStartDate).min(Date::compareTo).orElse(null);
            Date endDate = planToPlanDetails.stream().map(PlanToPlanDetail::getEndDate).max(Date::compareTo).orElse(null);
            plan.setStartDate(startDate);
            plan.setEndDate(endDate);

            planRepository.save(plan);

            return planMapper.toDTO(plan);
        }

        return null;
    }



}
