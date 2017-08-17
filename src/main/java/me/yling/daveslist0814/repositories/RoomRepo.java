package me.yling.daveslist0814.repositories;

import me.yling.daveslist0814.models.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepo extends CrudRepository <Room, Long> {

    Iterable<Room> findAllByStatusIs(String partialString);


}
