package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipecode;

    // Embedded type 이므로 protected 설정
    protected Address() {
    }

    public Address(String city, String street, String zipecode) {
        this.city = city;
        this.street = street;
        this.zipecode = zipecode;
    }
}
