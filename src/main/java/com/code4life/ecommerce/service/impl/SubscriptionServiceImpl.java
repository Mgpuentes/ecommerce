package com.code4life.ecommerce.service.impl;

import com.code4life.ecommerce.model.Subscription;
import com.code4life.ecommerce.repositories.SubscriptionRepository;
import com.code4life.ecommerce.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    //Used by Spring for dependency injection
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.delete(id);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
