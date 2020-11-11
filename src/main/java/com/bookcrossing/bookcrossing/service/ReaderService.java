/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Reader;
import java.util.List;

public interface ReaderService {
    Reader save(Reader reader);

    void delete(Reader reader);

    List<Reader> findAll();

    Reader findById(String Id);
    
    Reader findByLogin(String login);

    int count();
}
