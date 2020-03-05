package music.shop.musicshop.controller;

import music.shop.musicshop.entity.Song;
import music.shop.musicshop.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> allSongs() {
        return songService.findAll();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable("id") int id) {
        return songService.findById(id).orElseThrow(() -> new EntityNotFoundException("Custom message"));
    }

    @PostMapping
    public void addSong(Song song) {
        songService.save(song);
    }

    @PutMapping
    public Song update(@PathVariable("id") int id, Song song) {
        return null;
    }

    @DeleteMapping
    public void delete(@PathVariable("id") int id) {
        songService.delete(id);
    }

}
