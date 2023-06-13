package com.cepsearch.repository;

import com.cepsearch.dto.response.PostalCodeResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RedisClientRepositoryTest {

    @Mock
    private CrudRepository<PostalCodeResponse, String> crudRepository;

    private RedisClientRepository redisClientRepository;

    @Before
    public void setUp() {

        redisClientRepository = new RedisClientRepository() {
            @Override
            public <S extends PostalCodeResponse> S save(S entity) {
                return crudRepository.save(entity);
            }

            @Override
            public <S extends PostalCodeResponse> Iterable<S> saveAll(Iterable<S> entities) {
                return crudRepository.saveAll(entities);
            }

            @Override
            public Optional<PostalCodeResponse> findById(String id) {
                return crudRepository.findById(id);
            }

            @Override
            public boolean existsById(String id) {
                return crudRepository.existsById(id);
            }

            @Override
            public Iterable<PostalCodeResponse> findAll() {
                return crudRepository.findAll();
            }

            @Override
            public Iterable<PostalCodeResponse> findAllById(Iterable<String> ids) {
                return crudRepository.findAllById(ids);
            }

            @Override
            public long count() {
                return crudRepository.count();
            }

            @Override
            public void deleteById(String id) {
                crudRepository.deleteById(id);
            }

            @Override
            public void delete(PostalCodeResponse entity) {
                crudRepository.delete(entity);
            }

            @Override
            public void deleteAllById(Iterable<? extends String> strings) {
                crudRepository.deleteAllById(strings);
            }

            @Override
            public void deleteAll(Iterable<? extends PostalCodeResponse> entities) {
                crudRepository.deleteAll(entities);
            }

            @Override
            public void deleteAll() {
                crudRepository.deleteAll();
            }
        };
    }

    @Test
    public void testFindById_Exists() {
        // Arrange
        String postalCode = "12345678";
        PostalCodeResponse response = new PostalCodeResponse();
        when(crudRepository.findById(postalCode)).thenReturn(Optional.of(response));

        // Act
        Optional<PostalCodeResponse> result = redisClientRepository.findById(postalCode);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(response, result.get());
        verify(crudRepository, times(1)).findById(postalCode);
    }

    @Test
    public void testFindById_NotExists() {
        // Arrange
        String postalCode = "12345678";
        when(crudRepository.findById(postalCode)).thenReturn(Optional.empty());

        // Act
        Optional<PostalCodeResponse> result = redisClientRepository.findById(postalCode);

        // Assert
        assertFalse(result.isPresent());
        verify(crudRepository, times(1)).findById(postalCode);
    }

    @Test
    public void testSave() {
        // Arrange
        PostalCodeResponse response = new PostalCodeResponse();
        when(crudRepository.save(response)).thenReturn(response);

        // Act
        PostalCodeResponse result = redisClientRepository.save(response);

        // Assert
        assertEquals(response, result);
        verify(crudRepository, times(1)).save(response);
    }

}
