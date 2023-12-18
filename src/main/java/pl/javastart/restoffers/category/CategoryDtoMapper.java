package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;
import pl.javastart.restoffers.offer.Offer;

import java.util.List;

@Service
public class CategoryDtoMapper {
    public Category map(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    public CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        List<Offer> offers = category.getOffers();
        categoryDto.setOffers(offers.size());
        return categoryDto;
    }
}
