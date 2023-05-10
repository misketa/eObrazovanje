package com.eObrazovanje.eObrazovanje.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.eObrazovanje.eObrazovanje.model.entity.Dokument;
import com.eObrazovanje.eObrazovanje.payload.response.DokumentResponse;
import com.eObrazovanje.eObrazovanje.service.DokumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/uploadfile")
@CrossOrigin(origins = "http://localhost:4200")
public class DokumentController {
    DokumentService dokumentService;
    public static final String DIRECTORY = "./uploads";

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFile(@RequestParam("files") List<MultipartFile> files) throws IOException {
        List<String> filenames = new ArrayList<>();
        for(MultipartFile file : files) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            Path fileStorage = Paths.get(DIRECTORY, filename).toAbsolutePath().normalize();
            Files.copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            filenames.add(filename);
        }
        return ResponseEntity.ok().body(filenames);
    }

    @GetMapping("/files")
    public ResponseEntity<List<Dokument>> getListFiles() {
        List<Dokument> fileInfos = dokumentService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(DokumentController.class, "getFile", path.getFileName().toString()).build().toString();

            return Dokument.builder().naziv(filename).url(url).build();
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = dokumentService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
