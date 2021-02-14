package service;


import com.enigma.library.entities.User;
import com.enigma.library.repositories.UserRepository;
import com.enigma.library.service.UserService;
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
public class UserServiceTest {
    @InjectMocks
    private UserService service;

    @Mock
    private EntityManager entityManager;

    @Mock
    private UserRepository repository;

    @Test
    public void findByIdShoultReturnEntity() {
        service = new UserService(entityManager, repository);
        User expected = new User();
        expected.setId(1);
        expected.setName("x");
        expected.setAddress("x");
        expected.setPhone_num("x");
        expected.setGender("x");
        expected.setStatus_delete(true);
        expected.setStatus_loan(true);

        EntityTransaction transaction = mock(EntityTransaction.class);

        when(entityManager.getTransaction())
                .thenReturn(transaction);
        when(repository.findById(any(Integer.class))).thenReturn(expected);

        User actual = service.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldReturnList() {
        service = new UserService(entityManager, repository);
        List<User> expected = new ArrayList<>();

        EntityTransaction transaction = mock(EntityTransaction.class);

        when(entityManager.getTransaction())
                .thenReturn(transaction);
        when(repository.findAll()).thenReturn(expected);

        List<User> actual = service.findAll();
        assertEquals(expected, actual);
    }
}