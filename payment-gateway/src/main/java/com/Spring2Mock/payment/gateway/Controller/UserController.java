package com.Spring2Mock.payment.gateway.Controller;

import com.Spring2Mock.payment.gateway.Entity.Transaction;
import com.Spring2Mock.payment.gateway.Entity.User;
import com.Spring2Mock.payment.gateway.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User added succeffuly";
    }

    //GET API - Find the total amount over successful transactions for a user
    @GetMapping("/get-total-amount")
    public int totalAmount(@RequestParam("userId") int userId){
        return userService.totalAmount(userId);
    }

     // DELETE API - Delete all transactions that are failed
    @DeleteMapping("/delete-transaction")
    public String deleteTransaction(){
        userService.deleteTransaction();
        return "Succeffully deleted all transaction";
    }

//    GET API - Return UserId with maximum refund amount

    @GetMapping("/get-refund")
    public int refundAmount(){
        return userService.refundAmount();
    }
}
