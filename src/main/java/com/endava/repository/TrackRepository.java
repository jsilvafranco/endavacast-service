package com.endava.repository;

import com.endava.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author jsilva.
 */
@RepositoryRestResource(collectionResourceRel = "tracks", path = "tracks")
public interface TrackRepository extends CrudRepository<Track, String> {

}
