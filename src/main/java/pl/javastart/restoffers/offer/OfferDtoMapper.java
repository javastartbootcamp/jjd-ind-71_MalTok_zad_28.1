package pl.javastart.restoffers.offer;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.category.Category;
import pl.javastart.restoffers.category.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OfferDtoMapper {
    private final CategoryRepository categoryRepository;

    public OfferDtoMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Offer map(OfferDto offerDto) {
        Offer offer = new Offer();
        offer.setId(offerDto.getId());
        offer.setTitle(offerDto.getTitle());
        offer.setDescription(offerDto.getDescription());
        offer.setImgUrl(offerDto.getImgUrl());
        offer.setPrice(offerDto.getPrice());
        Optional<Category> categoryOptional = categoryRepository.findByName(offerDto.getCategory());
        categoryOptional.ifPresent(offer::setCategory);
        return offer;
    }

    public OfferDto mapToDto(Offer offer) {
        OfferDto offerDto = new OfferDto();
        offerDto.setId(offer.getId());
        offerDto.setTitle(offer.getTitle());
        offerDto.setDescription(offer.getDescription());
        offerDto.setImgUrl(offer.getImgUrl());
        offerDto.setPrice(offer.getPrice());
        offerDto.setCategory(offer.getCategory().getName());
        return offerDto;
    }

    public List<OfferDto> maptoDtos(List<Offer> offerList) {
        return offerList.stream()
                .map(this::mapToDto)
                .toList();
    }
}
