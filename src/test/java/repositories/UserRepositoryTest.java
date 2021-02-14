package repositories;




import com.enigma.library.entities.User;

import com.enigma.library.repositories.UserRepository;
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
public class UserRepositoryTest {

    @InjectMocks
    private UserRepository repository;

    @Mock
    private EntityManager entityManager;

    @Test
    public void findByIdShouldReturnEntity() {
        User expected = new User();
        expected.setId(6);
        expected.setName("x");
        expected.setAddress("x");
        expected.setPhone_num("x");
        expected.setGender("x");
        expected.setStatus_loan(true);
        expected.setStatus_delete(true);


        when(entityManager.find(any(Class.class), any()))
                .thenReturn(expected);

        User actual = repository.findById(2);
        assertEquals(expected, actual);


    }


    @Test
    public void findAllIdShouldReturnList() {
        CriteriaBuilder builder = mock(CriteriaBuilder.class);
        CriteriaQuery criteria = mock(CriteriaQuery.class);
        TypedQuery query = mock(TypedQuery.class);

        List<User> expected = new ArrayList<>();

        when(entityManager.getCriteriaBuilder()).thenReturn(builder);
        when(builder.createQuery(any(Class.class))).thenReturn(criteria);
        when(entityManager.createQuery(any(CriteriaQuery.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(expected);

        List<User> actual = repository.findAll();
        assertNotNull(actual);


    }
}




