package com.endava.starter;

/**
 * @author jsilva.
 */

import com.endava.model.Playlist;
import com.endava.repository.TrackRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@Component
public class DataInitializer implements
    ApplicationListener<ContextRefreshedEvent> {

  private TrackRepository trackRepository;
  private WebApplicationContext context;

  public DataInitializer(TrackRepository trackRepository, WebApplicationContext context){
    this.trackRepository = trackRepository;
    this.context = context;
  }





  private void loadInitialData() {
    ObjectMapper mapper = new ObjectMapper();
    Resource resource = context.getResource("classpath:static/sample-data.json");
    try {
      Playlist playlist = mapper.readValue(resource.getInputStream(), Playlist.class);
      if(playlist!=null && !CollectionUtils.isEmpty(playlist.getSongs())){
        Stream.of(playlist.getSongs()).forEach(s -> trackRepository.save(s));
      }
    } catch (IOException e) {
      log.error("failed to load test file");
    }
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    loadInitialData();
  }
}
