package miv.adventure.thegame.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question_order")
public class QuestionsOrder {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;
    @OneToOne(optional = false)
    private User user;
    @OneToOne(optional = false)
    private Question question;
    private int number;
}
