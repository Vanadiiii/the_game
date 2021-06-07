package miv.adventure.thegame.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "round")
public class Round {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @ManyToOne(optional = false)
    private Game game;
}
