package com.winter.app.professor;






@Mapper
public class professorMapper {

	//list
	public List<PrfessorDTO> list() throws Exception;

	
	//detail
	public ProfessorDTO detail(ProfessorDTO professorDTO)throws Exeption;
	
	//create
	public int create(ProfessorDTO professorDTO)throws Exception;
	
	//update
	public int update(ProfeddorDTO profess)throws Exception;
	
	//delete
	
}
