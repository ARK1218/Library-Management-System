package org.example.controller;

import org.example.entity.Member;
import org.example.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

    @GetMapping("/search")
    public List<Member> getMembersByName(@RequestParam String name){
        return memberService.getMembersByName(name);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member memberDetails){
        return memberService.updateMember(id, memberDetails);
    }
}