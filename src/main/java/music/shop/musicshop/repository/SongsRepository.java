package music.shop.musicshop.repository;

import music.shop.musicshop.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends JpaRepository<Song, Integer> {

}
