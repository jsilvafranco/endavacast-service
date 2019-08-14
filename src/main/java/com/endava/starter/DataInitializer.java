package com.endava.starter;

/**
 * @author jsilva.
 */

import com.endava.model.Playlist;
import com.endava.repository.PlaylistRepository;
import com.endava.repository.TrackRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@Component
public class DataInitializer {


  @Autowired
  private TrackRepository trackRepository;

  @Autowired
  private PlaylistRepository playlistRepository;

  @Autowired
  private WebApplicationContext context;



  private void loadInitialData() {
    ObjectMapper mapper = new ObjectMapper();
    Resource resource = context.getResource("classpath:static/sample-data.json");
    try {
      Playlist playlist = mapper.readValue(resource.getInputStream(), Playlist.class);
      if(playlist!=null && !CollectionUtils.isEmpty(playlist.getSongs())){
        playlist.getSongs().forEach(s -> trackRepository.save(s));
      }
      //refactor to persist a collection.
      playlistRepository.save(playlist);
    } catch (IOException e) {
      log.error("failed to load test file");
    }
  }

  private void logSongsFromDataBase(){
    playlistRepository.findAll().forEach(p -> System.out.println(p.getName()));
    trackRepository.findAll().forEach(s-> System.out.println(s.getTitle()));
  }


  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationEvent() {
    loadInitialData();
    logSongsFromDataBase();
  }
}
