package com.gura.step04.file.dao;

import java.util.List;

import com.gura.step04.file.dto.FileDto;

public interface FileDao {
	public void insert(FileDto dto);
	public void delete(int num);
	public List<FileDto> getList();
	public FileDto getData(int num);
}
