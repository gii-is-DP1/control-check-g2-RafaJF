package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingRepository extends CrudRepository<Feeding,Integer>{
    List<Feeding> findAll();

    @Query("SELECT fed FROM FeedingType fed")
    List<FeedingType> findAllFeedingTypes();

    @Query("SELECT ft FROM FeedingType ft WHERE ft.name LIKE :name")
    FeedingType getFeedingType(@Param("name") String name);

    Optional<Feeding> findById(int id);
    Feeding save(Feeding p);
}
