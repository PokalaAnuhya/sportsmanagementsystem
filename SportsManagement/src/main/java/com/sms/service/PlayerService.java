package com.sms.service;
import java.util.List;





import com.sms.dto.PlayerDTO;




public interface PlayerService {
	PlayerDTO addPlayer(PlayerDTO playerDTO);
	List<PlayerDTO>getAllPlayer();
	PlayerDTO getPlayerById(int id);
	PlayerDTO	updatePlayer(int id, PlayerDTO player);
	String deletePlayer(int id);
	    }
