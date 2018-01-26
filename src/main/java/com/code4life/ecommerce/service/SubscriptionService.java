package com.code4life.ecommerce.service;

import com.code4life.ecommerce.model.Subscription;

import java.util.List;


public interface SubscriptionService {

    Subscription saveSubscription(Subscription subscription);

    void deleteSubscription(Long id);

    List<Subscription> getAllSubscriptions();
}
