package repositories;



import com.enigma.library.entities.BukuKita;

import com.enigma.library.repositories.BukuKitaRepository;

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
public class BukuKitaRepositoryTest {

    @InjectMocks
    private BukuKitaRepository repository;

    @Mock
    private EntityManager entityManager;

    @Test
    public void findByIdShouldReturnEntity() {
        BukuKita expected = new BukuKita();
        expected.setId(6);
        expected.setTitle("x");
        expected.setAuthor("x");
        expected.setPublisher("x");
        expected.setCategory(expected.getCategory());
        expected.setStatus(true);
        expected.setTax(1);


        when(entityManager.find(any(Class.class), any()))
                .thenReturn(expected);

        BukuKita actual = repository.findById(2);
        assertEquals(expected, actual);


    }


    @Test
    public void findAllIdShouldReturnList() {
        CriteriaBuilder builder = mock(CriteriaBuilder.class);
        CriteriaQuery criteria = mock(CriteriaQuery.class);
        TypedQuery query = mock(TypedQuery.class);

        List<BukuKita> expected = new ArrayList<>();

        when(entityManager.getCriteriaBuilder()).thenReturn(builder);
        when(builder.createQuery(any(Class.class))).thenReturn(criteria);
        when(entityManager.createQuery(any(CriteriaQuery.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(expected);

        List<BukuKita> actual = repository.findAll();
        assertNotNull(actual);


    }
}




