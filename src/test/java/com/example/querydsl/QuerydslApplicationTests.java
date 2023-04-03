package com.example.querydsl;
import static com.example.querydsl.entity.QCategory.*;
//import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.querydsl.shop.repository.CustomCustomerRepository;
import com.example.querydsl.shop.entity.Category;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
class QuerydslApplicationTests {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private CustomCustomerRepository customerRepository;

    @Test
    void queryDSLInsertTest() {
        customerRepository.findCustomersFetch(PageRequest.of(1,3));
        System.out.println(customerRepository.findCustomersFetch());
    }

    @Test
    void queryDslSelectTest() {
        List<Category> qCategories = jpaQueryFactory.selectFrom(category).where(category.id.between(1,100000).and(memberIdLt(50000L))).orderBy(category.id.desc()).fetch();
        System.out.println(qCategories);
    }

    private BooleanExpression memberIdLt(Long lastMemberId) {
        return lastMemberId != null ? category.id.lt(lastMemberId): null;
    }
}
