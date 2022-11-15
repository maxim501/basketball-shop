package com.am.basketballshop.repository;

import com.am.basketballshop.model.security.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
