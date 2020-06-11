package com.big.Service;

import java.util.List;

import com.big.entity.Upload;

public interface IUploadService {
	public void insertbyUpload(Upload up);
	
	public List<Upload> selectAll();
}
