package hello.hellospring.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@Test
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("hello");
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		
		try {
			memberService.join(member2);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
		}
		
		
		//then
		
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
