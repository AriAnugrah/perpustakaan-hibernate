package service;

import com.enigma.library.entities.Category;
import com.enigma.library.repositories.CategoryRepository;
import com.enigma.library.service.CategoryService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @InjectMocks
    private CategoryService service;

    @Mock
    private EntityManager entityManager;

    @Mock
    private CategoryRepository repository;

    @Test
    public void findByIdShoultReturnEntity() {
        service = new CategoryService(entityManager, repository);
        Category expected = new Category();
        expected.setId(1);
        expected.setName_cat("x");
        expected.setRent_price(10000);
        expected.setRent_duration(12);

        EntityTransaction transaction = mock(EntityTransaction.class);

        when(entityManager.getTransaction())
                .thenReturn(transaction);
        when(repository.findById(any(Integer.class))).thenReturn(expected);

        Category actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnList() {
        service = new CategoryService(entityManager, repository);
        List<Category> expected = new ArrayList<>();

        EntityTransaction transaction = mock(EntityTransaction.class);

        when(entityManager.getTransaction())
                .thenReturn(transaction);
        when(repository.findAll()).thenReturn(expected);

        List<Category> actual = service.findAll();
        assertEquals(expected, actual);
    }
}