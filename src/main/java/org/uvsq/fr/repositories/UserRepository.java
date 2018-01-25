package org.uvsq.fr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uvsq.fr.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
