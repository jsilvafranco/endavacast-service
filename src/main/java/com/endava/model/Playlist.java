// Copyright (c) 2019 Sotheby's, Inc.
package com.endava.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jsilva.
 */
@Data
@NoArgsConstructor
public class Playlist {

  private String id;
  private String name;
  private String ownerId;
  private Integer numberOfTracks;
  private boolean visible;
  private boolean featuredPlaylist;
  private String  totalPlayTime;
  private List<Track> songs;

}
