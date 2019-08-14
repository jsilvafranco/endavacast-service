package com.endava.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jsilva.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tracks")
public class Track {

  @Id
  private String id;
  private String title;
  private String artistId;
  private String artistName;
  private String album;
  private String albumArtUrl;
  private String playbackTime;
  private String releaseYear;

}
