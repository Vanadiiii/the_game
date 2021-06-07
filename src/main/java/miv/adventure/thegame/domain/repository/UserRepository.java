package miv.adventure.thegame.domain.repository;

import miv.adventure.thegame.domain.entity.Game;
import miv.adventure.thegame.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
