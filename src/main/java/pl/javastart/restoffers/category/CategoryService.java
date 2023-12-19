package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoMapper categoryDtoMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(categoryDtoMapper::mapToDto).toList();
    }

    public List<String> findAllNames() {
        return categoryRepository.findAll().stream().map(Category::getName).toList();
    }

    public CategorySaveDto save(CategoryDto categoryDto) {
        Category category = categoryDtoMapper.map(categoryDto);
        categoryRepository.save(category);
        return categoryDtoMapper.mapToSaveDto(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
