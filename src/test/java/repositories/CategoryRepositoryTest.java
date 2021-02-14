package repositories;

import com.enigma.library.entities.Category;
import com.enigma.library.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CategoryRepositoryTest {

    @InjectMocks
    private CategoryRepository repository;

    @Mock
    private EntityManager entityManager;

    @Test
    public void findByIdShouldReturnEntity() {
        Category expected = new Category();
        expected.setId(6);
        expected.setName_cat("x");
        expected.setRent_price(5);
        expected.setRent_duration(23000);
        when(entityManager.find(any(Class.class), any()))
                .thenReturn(expected);

        Category actual = repository.findById(2);
        assertEquals(expected, actual);


    }


    @Test
    public void findAllIdShouldReturnList() {
        CriteriaBuilder builder = mock(CriteriaBuilder.class);
        CriteriaQuery criteria = mock(CriteriaQuery.class);
        TypedQuery query = mock(TypedQuery.class);

        List<Category> expected = new ArrayList<>();

        when(entityManager.getCriteriaBuilder()).thenReturn(builder);
        when(builder.createQuery(any(Class.class))).thenReturn(criteria);
        when(entityManager.createQuery(any(CriteriaQuery.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(expected);

        List<Category> actual = repository.findAll();
        assertNotNull(actual);


    }
}



