package miv.adventure.thegame.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;
    @Column(nullable = false)
    private String preview;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private String answer;
    //    @Column(columnDefinition = "duration in minutes for that question") // todo unlock for prod
    private int duration;

    @ManyToOne(optional = false)
    private Round round;
}
