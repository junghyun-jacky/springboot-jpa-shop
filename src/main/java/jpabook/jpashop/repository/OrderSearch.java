package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    // 하단 파라미터 조건이 있을 때 where문으로 검색
    private String memberName;
    private OrderStatus orderStatus;
}
