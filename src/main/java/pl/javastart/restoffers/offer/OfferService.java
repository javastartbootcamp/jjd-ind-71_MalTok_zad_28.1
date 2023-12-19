package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final OfferDtoMapper offerDtoMapper;

    public OfferService(OfferRepository offerRepository, OfferDtoMapper offerDtoMapper) {
        this.offerRepository = offerRepository;
        this.offerDtoMapper = offerDtoMapper;
    }

    public List<OfferDto> findAll() {
        return offerDtoMapper.maptoDtos(offerRepository.findAll());
    }

    public List<OfferDto> findByTitleContaining(String title) {
        return offerDtoMapper.maptoDtos(offerRepository.findAllByTitleContainingIgnoreCase(title));
    }

    public OfferDto save(OfferDto offerDto) {
        Offer offer = offerDtoMapper.map(offerDto);
        offerRepository.save(offer);
        return offerDtoMapper.mapToDto(offer);
    }

    public Optional<OfferDto> findById(Long id) {
        return offerRepository.findById(id).map(offerDtoMapper::mapToDto);
    }

    public void delete(Long id) {
        offerRepository.deleteById(id);
    }
}
