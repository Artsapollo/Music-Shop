package music.shop.musicshop.controller;

import music.shop.musicshop.entity.Song;
import music.shop.musicshop.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private SongService songService;

    @PostConstruct
    public void initData() {
        saveSongs();
    }

    private void saveSongs() {
        Song kyivMiy = new Song("Як тебе не любити", "Yuriy Gulyaev", 1962);
        songService.save(kyivMiy);
        Song dayNight = new Song("Day n Night", "Kid Cudi", 2008);
        songService.save(dayNight);
        Song goldie = new Song("Goldie", "A$AP ROCKY", 2012);
        songService.save(goldie);

    }
}
