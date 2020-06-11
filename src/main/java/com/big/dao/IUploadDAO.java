package com.big.dao;

import java.util.List;

import com.big.entity.Upload;

public interface IUploadDAO {
	public void insertbyUpload(Upload up);
	
	public List<Upload> selectAll();
}
