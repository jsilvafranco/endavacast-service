// Copyright (c) 2019 Sotheby's, Inc.
package com.endava.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jsilva.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="playlists")
public class Playlist {

  @Id
  private String id;
  private String name;
  private String ownerId;
  private Integer numberOfTracks;
  private boolean visible;
  private boolean featuredPlaylist;
  private String  totalPlayTime;
  @OneToMany(targetEntity=Track.class, fetch=FetchType.EAGER)
  private List<Track> songs;

}
