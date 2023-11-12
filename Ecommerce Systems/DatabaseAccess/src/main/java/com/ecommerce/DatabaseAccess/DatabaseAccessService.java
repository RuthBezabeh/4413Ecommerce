package com.ecommerce.DatabaseAccess;

import com.ecommerce.DatabaseAccess.models.AuctionRepository;
import com.ecommerce.DatabaseAccess.models.CatalogRepository;
import com.ecommerce.DatabaseAccess.models.PaymentRepository;
import com.ecommerce.DatabaseAccess.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class DatabaseAccessService {

    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CatalogRepository catalogRepository;

    public DatabaseAccessService() {

    }

    public void getAuctionItem(){

    }


    public void createAuctionItem(){

    }


    public void updateAuctionItem(){

    }


    public void DeleteAuctionItem(){

    }


    public void getCatalogItem(){

    }


    public void createCatalogItem(){

    }


    public void updateCatalogItem(){

    }


    public void DeleteCatalogItem(){

    }


    public void getUserItem(){

    }


    public void createUserItem(){

    }


    public void updateUserItem(){

    }


    public void DeleteUserItem(){

    }


    public void getPaymentItem(){


    }


    public void createPaymentItem(){

    }


    public void updatePaymentItem(){

    }


    public void DeletePaymentItem(){

    }
}
