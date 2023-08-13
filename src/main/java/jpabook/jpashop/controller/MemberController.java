package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // form 화면 열기
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm",  new MemberForm());
        return "members/createMemberForm";
    }

    // 회원 가입 데이터 등록
    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {    // 회원가입 항목이 Member 엔티티와 일치하지 않기 때문에 따로 MemberForm 사용

        if(result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }
}
