package miv.adventure.thegame.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    private UUID id;
    private String preview;
    private String text;
    private String answer;
    @Column(columnDefinition = "duration in minutes for that question")
    private int duration;
}
