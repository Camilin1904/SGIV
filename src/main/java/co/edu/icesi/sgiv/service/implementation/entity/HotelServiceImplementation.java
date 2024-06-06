package co.edu.icesi.sgiv.service.implementation.entity;

import co.edu.icesi.sgiv.domain.entity.Accommodation;
import co.edu.icesi.sgiv.domain.entity.Destination;
import co.edu.icesi.sgiv.domain.entity.Hotel;
import co.edu.icesi.sgiv.domain.resources.DestinationImage;
import co.edu.icesi.sgiv.domain.resources.HotelImage;
import co.edu.icesi.sgiv.dto.entity.AccommodationDTO;
import co.edu.icesi.sgiv.dto.entity.HotelDTO;
import co.edu.icesi.sgiv.dto.resources.HotelImageDTO;
import co.edu.icesi.sgiv.mapper.entity.HotelMapper;
import co.edu.icesi.sgiv.mapper.resources.HotelImageMapper;
import co.edu.icesi.sgiv.repository.entity.AccommodationRepository;
import co.edu.icesi.sgiv.repository.entity.DestinationRepository;
import co.edu.icesi.sgiv.repository.entity.HotelRepository;
import co.edu.icesi.sgiv.service.abstraction.entity.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImplementation implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private DestinationRepository destinationRepository;

    private final HotelMapper hotelMapper = HotelMapper.INSTANCE;
    private final HotelImageMapper hotelImageMapper = HotelImageMapper.INSTANCE;

    @Override
    public Page<HotelDTO> findAll(Pageable page) {
        Page<Hotel> hotels = hotelRepository.findAll(page);
        return hotels.map(hotelMapper::toDTO);
    }

    @Override
    public List<HotelImageDTO> getImages(Long id) {
        return hotelRepository.getImages(id).stream().map(hotelImageMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<HotelDTO> findByFilter(Pageable pageable, String name, String address, String status, Long dID) {
        return hotelRepository.findByFilter(pageable, name, address, status, dID).map(hotelMapper::toDTO);
    }

    @Override
    public List<HotelDTO> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(hotelMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HotelDTO> findByID(Long aLong) {
        Optional<Hotel> hotel = hotelRepository.findById(aLong);
        return hotel.map(hotelMapper::toDTO);
    }

    @Override
    public HotelDTO save(HotelDTO entity) throws Exception {
        if(!hotelRepository.existsById(entity.getId()))
            return hotelMapper.toDTO(hotelRepository.findById(entity.getId()).get());
        else
            throw new Exception("Hotel already exists");
    }

    @Override
    public HotelDTO update(HotelDTO entity) throws Exception {
        if(hotelRepository.existsById(entity.getId()))
            return hotelMapper.toDTO(hotelRepository.findById(entity.getId()).get());
        else
            throw new Exception("Hotel does not exist");
    }

    @Override
    public void delete(HotelDTO entity) throws Exception {
        if(hotelRepository.existsById(entity.getId()))
            hotelRepository.delete(hotelRepository.findById(entity.getId()).get());
        else
            throw new Exception("Hotel does not exist");
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        if(hotelRepository.existsById(aLong))
            hotelRepository.deleteById(aLong);
        else
            throw new Exception("Hotel does not exist");
    }

    @Override
    public void validate(HotelDTO entity) throws Exception {

    }

    @Override
    public long count() {
        return hotelRepository.count();
    }
}
