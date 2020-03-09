package music.shop.musicshop.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "year")
    private Integer year;

    public Song(String title, String artist, Integer year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

}
