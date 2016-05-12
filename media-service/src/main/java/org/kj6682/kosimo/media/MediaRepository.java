package org.kj6682.kosimo.media;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by luigi on 23.04.16.
 */

interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByTitle(@Param("title") String title);
    List<Media> findByAuthor(@Param("author") String author);
    List<Media> findByType(@Param("type") Media.Type type);

    Optional<Media> findById(Long id);

}