package com.sms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.dto.PlayerDTO;
import com.sms.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> 

{

	Player save(PlayerDTO playerDTO);
}
