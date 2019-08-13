package com.endava.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jsilva.
 */
@Data
@NoArgsConstructor
public class Track {

  private String id;
  private String title;
  private String artistId;
  private String artistName;
  private String album;
  private String albumArtUrl;
  private String playbackTime;
  private String releaseYear;

}
