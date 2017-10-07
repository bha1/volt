package com.hbm.volt.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/rooms")
public class RoomRestController {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Room> getRooms(@RequestParam(value="room",required=false)String name){
		Iterable<Room> iterable = this.roomRepository.findAll();
		ArrayList<Room> list = new ArrayList<>();
		iterable.forEach(p->{
			//if(p.getBedInfo().equals("1K"))
			list.add(p);
		});
		return list;
	}
}
