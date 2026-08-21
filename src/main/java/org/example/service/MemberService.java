package org.example.service;

import org.example.entity.Member;
import org.example.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }



    public Optional<Member> getMemberById(Long id){
        return memberRepository.findById(id);
    }

    public Member updateMember(Long id, Member memberDetails){
        return memberRepository.findById(id).map(member -> {
            member.setEmail(memberDetails.getEmail());
            member.setName(memberDetails.getName());
            return memberRepository.save(member);
        }).orElseThrow(() -> new RuntimeException("Member not found with id " + id));
    }
    public List<Member> getMembersByName(String name) {
        return memberRepository.findByName(name);
    }
}