package org.kj6682.kosimo.dm;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by luigi on 23.04.16.
 */

interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByOwner(@Param("owner") String owner);
    Optional<Account> findById(Long id);

}