package miv.adventure.thegame.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "game")
public class Game {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Round> rounds;
    private LocalDateTime start;
    @Enumerated(value = EnumType.STRING)
    private GameStatus status;

    @ManyToMany(mappedBy = "games")
    private List<User> users;
}
