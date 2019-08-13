package com.endava.repository;

import com.endava.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsilva.
 */
@Repository
public interface TrackRepository extends CrudRepository<Track, String> {

}
