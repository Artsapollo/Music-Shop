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
        Song kyivMiy2 = new Song("Як тебе не любити", "Yuriy Gulyaev", 1962);
        kyivMiy2.setArtist("Pavlo Zibrov");
        songService.save(kyivMiy2);

        Song kyivMiy = new Song("Як тебе не любити", "Yuriy Gulyaev", 1962);
        songService.save(kyivMiy);
        Song dayNight = new Song("Day n Night", "Kid Cudi", 2008);
        songService.save(dayNight);
        Song goldie = new Song("Goldie", "A$AP ROCKY", 2012);
        songService.save(goldie);

        for (int i = 0; i < 3000; i++) {
            Song song = new Song("Song" + i, "Artist" + i, (int) (Math.random() * 100));
            songService.save(song);
        }

    }
}
