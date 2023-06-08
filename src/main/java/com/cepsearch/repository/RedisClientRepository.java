package com.cepsearch.repository;

import com.cepsearch.dto.response.PostalCodeResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisClientRepository extends CrudRepository<PostalCodeResponse, String> {
}
