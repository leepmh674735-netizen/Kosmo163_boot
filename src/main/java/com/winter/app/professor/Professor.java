Bind to grammar/schema. . . 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTO Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapprer namespace="com.winter.app.professorMapper">
  <select id="">
      SELECT PROFESSOR_NO, PROFSSOR_NAME, DEPARTMENT_NO FROM TB_PROFESSOR
  </select>
  
   <select id="detail" resultType="ProfessorDTO" parameterType="ProfessorDTO">   
    SELECT * FROM TB_PROFESSOR
    WHERE PROFESSOR_NO=#{professorNo}
      </select>
      
      <insert id="create">
           INSERT INTO TB_PROFESSOR
           VALUES (#{professorNo}, #{professorName}, #{professorSsn}, #{professprAddress}, #
       </insert> 	
           
           <update id="update"> parameterType="ProfessorDTO">
           UPDATE TB_PROFESSPR
           SET
           PROFESSOR_NAME=#{profesorName},
           PROFESSOR
