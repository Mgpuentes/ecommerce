package com.code4life.ecommerce.repositories;

import com.code4life.ecommerce.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    List<Subscription> findAll();
}
