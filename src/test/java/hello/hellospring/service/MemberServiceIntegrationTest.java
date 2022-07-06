package hello.hellospring.service;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	public void ȸ������() throws Exception {
		//Given
		Member member = new Member();
		member.setName("spring");
		
		//When
		Long saveId = memberService.join(member);
		
		//Then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}
	
	@Test
	public void �ߺ�_ȸ��_����() throws Exception {
		//Given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//When
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));//���ܰ� �߻��ؾ� �Ѵ�.
		assertThat(e.getMessage()).isEqualTo("�̹� �����ϴ� ȸ���Դϴ�.");
	}
}