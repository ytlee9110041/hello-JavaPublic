package hello.hellospring;

import hello.hellospring.service.MemberService;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/*
	 * @Bean public MemberRepository memberRepository() { //return new
	 * MemoryMemberRepository(); //return new JdbcMemberRepository(dataSource);
	 * //return new JdbcTemplateMemberRepository(dataSource); return new
	 * JpaMemberRepository(em); }
	 */
}
