package music.shop.musicshop.controller;

import music.shop.musicshop.entity.Song;
import music.shop.musicshop.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongsController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> allSongs(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                               @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
                               @RequestParam(value = "sortOrder", required = false, defaultValue = "asc") String sortOrder) {
        Sort.Direction orderDirection = Sort.Direction.fromString(sortOrder);
        Sort sortByRequest = Sort.by(orderDirection, sortBy);
        Pageable pageRequest = PageRequest.of(page, limit, sortByRequest);
        return songService.findAll(pageRequest);
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable("id") int id) {
        return songService.findById(id).orElseThrow(() -> new EntityNotFoundException("Custom message"));
    }

    @PostMapping
    public void addSong(Song song) {
        songService.save(song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        songService.delete(id);
    }

}
