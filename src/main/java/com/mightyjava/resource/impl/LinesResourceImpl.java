package com.mightyjava.resource.impl;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.mightyjava.domain.Lines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mightyjava.resource.Resource;
import com.mightyjava.service.IPageService;
import com.mightyjava.service.IService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins="http://localhost:3000")
public class LinesResourceImpl implements Resource<Lines> {
	
	@Autowired
	private IService<Lines> bookService;
	
	@Autowired
	private IPageService<Lines> bookPageService;

	@Override
	public ResponseEntity<Page<Lines>> findAll(Pageable pageable, String searchText) {
		return new ResponseEntity<>(bookPageService.findAll(pageable, searchText), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Page<Lines>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
		return new ResponseEntity<>(bookPageService.findAll(
				PageRequest.of(
						pageNumber, pageSize,
						sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
				)
		), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Lines> findById(Long id) {
		return new ResponseEntity<>(bookService.findById(id).get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Lines> save(Lines lines) {
		return new ResponseEntity<>(bookService.saveOrUpdate(lines), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Lines> update(Lines lines) {
		return new ResponseEntity<>(bookService.saveOrUpdate(lines), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(bookService.deleteById(id), HttpStatus.OK);
	}

	@GetMapping("/languages")
	public  ResponseEntity<Set<String>> findAllLanguages() {
        return new ResponseEntity<>(new TreeSet<>(Arrays.asList("French", "Portuguese", "English", "Russian", "Hindi", "Arabic", "Spanish", "Chinese")), HttpStatus.OK);
    }

    @GetMapping("/genres")
    public  ResponseEntity<Set<String>> findAllGenres() {
        return new ResponseEntity<>(new TreeSet<>(Arrays.asList("Technology", "Science", "History", "Fantasy", "Biography", "Horror", "Romance")), HttpStatus.OK);
    }
}
