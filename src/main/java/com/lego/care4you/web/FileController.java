package com.lego.care4you.web;

import com.lego.care4you.domain.File;
import com.lego.care4you.dto.FileRequestDTO;
import com.lego.care4you.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/files")
@Api(value = "files", description = "Operations related to files")
public class FileController {

    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<File> findAll() {
        return fileService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public File findById(@PathVariable String id) {
        return fileService.findById(id);
    }

    @RequestMapping(
            value = "/{referenceId}",
            method = RequestMethod.POST
    )
    public File upload(@RequestParam("file") MultipartFile multipart, @PathVariable String referenceId) {
        FileRequestDTO dto = new FileRequestDTO(referenceId);
        return fileService.upload(multipart, dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public File delete(@PathVariable String id) {
        return fileService.delete(id);
    }
}
