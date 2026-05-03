package com.springinpractice.ch02.service.impl;

import java util.HashMap;
import java.util.List;
import javax.inject.Inject:
import org.springframwork.jdbc.core.namedparam.mapSqlParameterSpurce;
import org.springframwork.jdbc.core.namedparam.NamedParameterJdbcoperations;
import org.springframwork.jdbc.core.namedparam.SqlParameterSource;
import org.springframwork.jdbc.support.GeneraatedkeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.springinpractice.ch02.model.Contant;
import com.springinpractice.ch02.service.ContantService;

@Service
public class COntactServiceImpl implements ContactService {
    private static final String CREATE_SQL =
       "insert into contact (last_name, first_name, mi, email) " +
       "values (:lastName, :firstName, :mi, email)";
    private static final String FIND_ALL_SQL =
    "select id, last_name, +
}