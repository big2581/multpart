package com.big.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.big.Service.IUploadService;
import com.big.dao.IUploadDAO;
import com.big.entity.Upload;

@Service
public class IUploadServiceImpl implements IUploadService {

    @Autowired
    private IUploadDAO iup;

    @Override
    public void insertbyUpload(Upload up) {
        iup.insertbyUpload(up);
    }

    @Override
    public List<Upload> selectAll() {
        return iup.selectAll();
    }

}
