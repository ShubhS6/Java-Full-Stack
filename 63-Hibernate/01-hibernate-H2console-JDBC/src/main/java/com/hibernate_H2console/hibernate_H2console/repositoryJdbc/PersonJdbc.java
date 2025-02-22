package com.hibernate_H2console.hibernate_H2console.repositoryJdbc;

import com.hibernate_H2console.hibernate_H2console.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    //create own row mapper
    class rm implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person=new Person();
            person.setId(rs.getInt("id"));
            return person;
        }
    }



    public List<Person> findAll(){
         //return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<Person>(Person.class));
        //After creating own row mapper we cane simple write
        return jdbcTemplate.query("select * from person",new rm());
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new BeanPropertyRowMapper<Person>(Person.class),new Object[]{id});
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    public int insert(Person person){
        return jdbcTemplate.update("insert into person(id,name,location,birth_date)"+"values(?,?,?,?)",
                new Object[]{person.getId(),person.getName(),person.getLocation(),
                        new Timestamp(person.getBirth_date().getTime())});
    }

    public int update(Person person){
        return jdbcTemplate.update("update person "+" set name = ?, location = ?,birth_date = ? "+" where id = ?",
                new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime()),person.getId()});
    }
}
