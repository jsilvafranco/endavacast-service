package com.endava.repository;

import com.endava.model.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author jsilva.
 */
@RepositoryRestResource(collectionResourceRel = "playlists", path = "playlists")
public interface PlaylistRepository extends CrudRepository<Playlist, String> {

}
