package miv.adventure.thegame.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private UUID id;
    @OneToOne
    private Game game;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private QuestionsOrder questionsOrder;
}
