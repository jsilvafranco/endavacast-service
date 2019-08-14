// Copyright (c) 2019 Sotheby's, Inc.
package com.endava.repository;

import com.endava.model.Playlist;
import org.springframework.data.repository.CrudRepository;

/**
 * @author jsilva.
 */
public interface PlaylistRepository extends CrudRepository<Playlist, String> {

}
