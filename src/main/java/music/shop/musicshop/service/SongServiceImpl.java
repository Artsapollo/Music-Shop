package music.shop.musicshop.service;

import music.shop.musicshop.entity.Song;
import music.shop.musicshop.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongsRepository songsRepository;

    @Override
    public Optional<Song> findById(int id) {
        return songsRepository.findById(id);
    }

    @Override
    public List<Song> findAll() {
        return songsRepository.findAll();
    }

    @Override
    public Song save(Song song) {
        return songsRepository.save(song);
    }

    @Override
    public void delete(int id) {
        songsRepository.deleteById(id);
    }
}
