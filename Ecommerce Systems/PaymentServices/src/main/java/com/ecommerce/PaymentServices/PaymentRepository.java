package com.ecommerce.PaymentServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByPaymentId(Long payment_id);
    Payment findByUserId(Long userId);
    Payment findByItemId(Long item_id);

    Payment findByItemIdAndUserId(Long item_id, Long userId);
}
