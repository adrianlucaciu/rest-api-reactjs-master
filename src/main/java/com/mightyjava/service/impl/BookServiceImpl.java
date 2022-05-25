package com.mightyjava.service.impl;

import java.util.Collection;
import java.util.Optional;

import com.mightyjava.domain.Lines;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mightyjava.repository.LinesRepository;
import com.mightyjava.service.IPageService;
import com.mightyjava.service.IService;

@Service
public class BookServiceImpl implements IService<Lines>, IPageService<Lines> {

	@Autowired
	private LinesRepository linesRepository;
	
	@Override
	public Collection<Lines> findAll() {
		return (Collection<Lines>) linesRepository.findAll();
	}

	@Override
	public Page<Lines> findAll(Pageable pageable, String searchText) {
		return linesRepository.findAllBooks(pageable, searchText);
	}

	@Override
	public Page<Lines> findAll(Pageable pageable) {
		return linesRepository.findAll(pageable);
	}

	@Override
	public Optional<Lines> findById(Long id) {
		return linesRepository.findById(id);
	}

	@Override
	public Lines saveOrUpdate(Lines lines) {
		return linesRepository.save(lines);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			linesRepository.deleteById(id);
			jsonObject.put("message", "Book deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
