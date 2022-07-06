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
	void ȸ������() {
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
	void �ߺ�_ȸ��_����() {
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
			assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�.123123");
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
