package org.kj6682.kosimo.dm;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by luigi on 23.04.16.
 */

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByOwner(@Param("owner") String owner);

}