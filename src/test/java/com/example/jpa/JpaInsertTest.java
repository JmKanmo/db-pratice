package com.example.jpa;

import com.example.querydsl.QuerydslApplication;
import com.example.querydsl.shop.entity.Customer;
import com.example.querydsl.game.entity.User;
import com.example.querydsl.shop.repository.CustomerRepository;
import com.example.querydsl.shop.repository.batch.JdbcCustomerBatchRepo;
import com.example.querydsl.game.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = QuerydslApplication.class)
public class JpaInsertTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcCustomerBatchRepo jdbcCustomerBatchRepo;

    @Test
    @Transactional
    @DisplayName("No IDENTITY, insert into bulk 테스트")
    public void saveCustomerTest() {
        /**
         * bulk 옵션 적용... 데이터 개수 1만개, bulk size ~ 1000 ~ 10000 대략 14 ~ 15 sec
         */
        final List<Customer> IDENTITYCustomerList = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            IDENTITYCustomerList.add(new Customer((long) i, "강준모" + i));
        }

        customerRepository.saveAll(IDENTITYCustomerList);
//        for(Customer customer : IDENTITYCustomerList) {
//            customerRepository.save(customer);
//        }

        customerRepository.flush();
    }

    @Test
    @Transactional
    @DisplayName("JdbcTemplate을 이용한 insert")
    public void saveJdbcBatchCustomerTest() {
        /**
         * bulk 옵션 적용... 데이터 개수 1만개, bulk size ~ 1000 ~ 10000 대략 331ms
         */

        /**
         *  ... 굉장히 경이로울 만큼 빠르다. 압도적으로 ...
         */
        final List<Customer> IDENTITYCustomerList = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            IDENTITYCustomerList.add(new Customer((long) i, "강준모" + i));
        }

        jdbcCustomerBatchRepo.saveAllCustomer(IDENTITYCustomerList, 5000);
    }

    @Test
    @Transactional
    @DisplayName("AUTO, insert into bulk 테스트")
    public void saveUserTest() {
        /**
         * bulk 옵션 적용... 데이터 개수 1만개, bulk size ~ 1000 ~ 10000 대략 14 ~ 15 sec
         */
        final List<User> userList = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            userList.add(new User("강준모 회원" + i));
        }
        userRepository.saveAll(userList);

        userRepository.flush();
    }
}
