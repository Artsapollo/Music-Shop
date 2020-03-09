package music.shop.musicshop.service;

import music.shop.musicshop.entity.Song;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface SongService {
    List<Song> findAll(Pageable pageable);

    Optional<Song> findById(int id);

    Song save(Song song);

    void delete(int id);
}
