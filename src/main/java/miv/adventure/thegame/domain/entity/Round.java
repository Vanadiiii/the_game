package miv.adventure.thegame.domain.entity;

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
public class Round {
    @Id
    private UUID id;
    private String name;
    @JoinTable(name = "round_question",
            joinColumns = @JoinColumn(name = "round_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;
}
