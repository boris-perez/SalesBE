package com.lego.care4you.service;

import com.lego.care4you.domain.File;
import com.lego.care4you.dto.FileRequestDTO;
import com.lego.care4you.repository.*;
import com.lego.care4you.service.bootstrap.GenericService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class FileService extends GenericService<File, FileRequestDTO> {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<File> findAll() {
        return fileRepository.findAll();
    }

    @Override
    public File findById(String id) {
        return fileRepository.findOne(id);
    }

    @Override
    public File delete(String id) {
        File file = findById(id);
        fileRepository.delete(file);
        return file;
    }

    @Override
    public File insert(FileRequestDTO dto) {
        return null;
    }

    public File upload(MultipartFile multipart, FileRequestDTO dto) {
        File file = buildCreateFile(dto, multipart);
        file = fileRepository.insert(file);
        return file;
    }

    @Override
    public File update(String id, FileRequestDTO dto) {
        return null;
    }

    private File buildCreateFile(FileRequestDTO dto, MultipartFile multipart) {
        File file = new File();
        setFileInformation(dto, file, multipart);

        return file;
    }

    private void setFileInformation(FileRequestDTO dto, File file, MultipartFile multipart) {
        try {
            file.setReferenceId(dto.getReferenceId());
            file.setFile(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
