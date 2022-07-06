package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/* 
	 * ȸ�� ����
	 * */
	
	public Long join(Member member) {
		
		long start = System.currentTimeMillis();
		
		try {
			validateDuplicateMember(member); //�ߺ� ȸ�� ����
			memberRepository.save(member);
			return member.getId();
		} finally {
			long finish = System.currentTimeMillis();
			long timsMs = finish - start;
			System.out.println("join = " + timsMs);
		}
		
		
	}
	
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m -> {
			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
		});
	}
	
	/*
	 * ��ü ȸ�� ��ȸ 
	 */
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
