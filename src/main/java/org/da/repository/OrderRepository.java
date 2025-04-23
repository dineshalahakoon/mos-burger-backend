package org.da.repository;

import org.da.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,String> {
    Optional<Object> findByOrderid(String id);

    boolean existsByOrderid(String id);

    void deleteByOrderid(String id);
}
