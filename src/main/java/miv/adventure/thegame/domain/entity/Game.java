package miv.adventure.thegame.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    private UUID id;
    private String name;
    @JoinTable(name = "game_round",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "round_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private List<Round> rounds;
    private LocalDateTime start;
    @Enumerated(value = EnumType.STRING)
    private GameStatus status;
}
