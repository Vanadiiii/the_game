package miv.adventure.thegame.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuestionsOrder {
    @Id
    private UUID id;
    @OneToOne(optional = false)
    private User user;
    @OneToOne(optional = false)
    private Question question;
    private int number;
}
