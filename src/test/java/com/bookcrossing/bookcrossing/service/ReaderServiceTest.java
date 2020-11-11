/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookcrossing.bookcrossing.service;

import com.bookcrossing.bookcrossing.domain.Reader;
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReaderServiceTest {
    
    @Autowired
    ReaderService readerService;
    
    @Test
    void ShouldFindById(){
        Reader firstReader = findFirstReader();
        String Id=firstReader.getId();
        Reader reader = readerService.findById(Id);
        assertNotNull(reader);
        assertEquals(firstReader.getId(), reader.getId());
        assertEquals(firstReader.getLogin(), reader.getLogin());
        assertEquals(firstReader.getReaderName(), reader.getReaderName());
        assertEquals(firstReader.getPassword(), reader.getPassword());
    }
    
    @Test
    void ShouldFindByLogin(){
        Reader firstReader = findFirstReader();
        String login=firstReader.getLogin();
        Reader reader = readerService.findByLogin(login);
        assertNotNull(reader);
        assertEquals(firstReader.getId(), reader.getId());
        assertEquals(firstReader.getLogin(), reader.getLogin());
        assertEquals(firstReader.getReaderName(), reader.getReaderName());
        assertEquals(firstReader.getPassword(), reader.getPassword());
    }
    
    @Test
    void ShouldDeleteReader(){
        // create sample book
        Reader reader = new Reader();
        reader.setLogin("d_reader@mail.com");
        reader.setPassword("11111111");
        reader.setReaderName("Deleted reader");        
        reader = readerService.save(reader);
        int countBefore = readerService.count();
        // delete book
        readerService.delete(reader);
        // verify
        int countAfter = readerService.count();
        assertTrue(countBefore == countAfter + 1);
    }
    
    @Test
    void ShouldFindAll(){
        List<Reader> readers = readerService.findAll();
        assertNotNull(readers);
        assertTrue(readers.size() > 0);
    }
    
    @Test
    void ShouldAddNewReader(){
        int countBefore = readerService.count();

        // add new book
        Reader reader = new Reader();
        reader.setLogin("a_reader@mail.com");
        reader.setPassword("11111111");
        reader.setReaderName("Added reader");
        reader = readerService.save(reader);
        // verify
        int countAfter = readerService.count();
        assertTrue(countBefore == countAfter - 1);
        Reader storedReader = readerService.findById(reader.getId());
        assertEquals(reader.getId(), storedReader.getId());
        assertEquals(reader.getLogin(), storedReader.getLogin());
        assertEquals(reader.getReaderName(), storedReader.getReaderName());
        assertEquals(reader.getPassword(), storedReader.getPassword());
    }
    
    @Test
    void ShouldNotAddNewReader(){
        int countBefore = readerService.count();
        Reader reader = new Reader();
        reader.setLogin(findFirstReader().getLogin());
        reader.setPassword("11111111");
        reader.setReaderName("NotAdded reader");
        reader = readerService.save(reader);
        int countAfter = readerService.count();
        assertTrue(countBefore == countAfter);
    }
    
    @Test
    void UpdateNewReader(){
        // update first reader
        Reader reader = findFirstReader();
        reader.setLogin("u_reader@mail.com");
        reader.setPassword("updateupdate");
        reader.setReaderName("Update reader");
        Reader readerUpdated = readerService.save(reader);
        Reader storedReader = readerService.findById(readerUpdated.getId());
        assertEquals(readerUpdated.getId(), storedReader.getId());
        assertEquals(readerUpdated.getLogin(), storedReader.getLogin());
        assertEquals(readerUpdated.getReaderName(), storedReader.getReaderName());
        assertEquals(readerUpdated.getPassword(), storedReader.getPassword());
    }
    
    private Reader findFirstReader() {
        List<Reader> readers = readerService.findAll();
        return readers.get(0);
    }
    
}
