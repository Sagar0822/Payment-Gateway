package com.Spring2Mock.payment.gateway.Service;

import com.Spring2Mock.payment.gateway.Entity.Refund;
import com.Spring2Mock.payment.gateway.Entity.Transaction;
import com.Spring2Mock.payment.gateway.Entity.User;
import com.Spring2Mock.payment.gateway.Enum.TransactionStatus;
import com.Spring2Mock.payment.gateway.Repository.TransactionRepository;
import com.Spring2Mock.payment.gateway.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository tRepository;

    public void addUser(User user){
      userRepository.save(user);
    }


    //GET API - Find the total amount over successful transactions for a user
    public int totalAmount(int userId){
        User user = userRepository.findById(userId).get();
        int totalAmount = 0;
        for(Transaction tnxList : user.getTransactions()){
            if(tnxList.getStatus() == TransactionStatus.SUCCESS){
                totalAmount += tnxList.getAmount();
            }
        }
        return totalAmount;
    }
    // DELETE API - Delete all transactions that are failed
    public void deleteTransaction(){
        List<User> userList = userRepository.findAll();

        for(User user1 :userList){
            for(Transaction transaction : user1.getTransactions()){
                if(transaction.getStatus() == TransactionStatus.FAILED)
                    tRepository.delete(transaction);
            }
        }
    }
    //    GET API - Return UserId with maximum refund amount
    public int refundAmount(){
        List<User> userList = userRepository.findAll();
        int userId = 0;
        int maxRefund = 0;
        int totalRefund = 0;
        for(User user1 :userList){
            for(Refund refund : user1.getRefunds()){
                totalRefund += refundAmount();
            }
            if(maxRefund < totalRefund) {
                userId = user1.getUserId();
            }
            maxRefund = Math.max(maxRefund, totalRefund);
        }
        return userId;
    }

}
