package com.winter.app.professor;

import static org.junit.jupiter.api.Assertions. *;

import 
import

@SpringBootTest
class PrefessorMapperTest {
	
	@Autowired
	private professorMapper professorMapper;
	
	@Test
	void listTest() throws Exception {
		List<ProfessorDTO> ar= professorMapper.list();
		System.out.println(ar.size());
		//단정문
		assertEquals(0, ar.size());
	}
	
	@Test
	void detailTesst()throws Exception{
		ProfessorDTO professorDTO = new ProfesserDTO();
		professorDTO = setProfessorNo("P001123");
//	   = professorMapper.detail(null);
//	   
//	   assertNotNull(professprDTO);
	}
	
}
