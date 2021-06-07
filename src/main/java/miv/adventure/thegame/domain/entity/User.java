package miv.adventure.thegame.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private String email;

    @ManyToMany
    private List<Game> games;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private QuestionsOrder questionsOrder;
}
