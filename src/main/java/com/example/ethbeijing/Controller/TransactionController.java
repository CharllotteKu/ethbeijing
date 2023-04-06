package com.example.ethbeijing.Controller;

import com.example.ethbeijing.common.R;

import com.example.ethbeijing.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/data")
public class TransactionController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/{hash}")
    public R<Transaction> get(@PathVariable String hash){
        Transaction transaction = mongoTemplate.findOne(new Query(Criteria.where("tx_hash").is(hash.toString())),Transaction.class);
        return R.success(transaction);
    }
}
