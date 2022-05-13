package com.web.board.controller.item;

import com.web.board.component.S3Uploader;
import com.web.board.construct.eum.BType;
import com.web.board.controller.item.dto.SaveItemDTO;
import com.web.board.dsl.ItemDsl;
import com.web.board.entity.item.Alubum;
import com.web.board.entity.item.Book;
import com.web.board.entity.item.Movie;
import com.web.board.repository.AlubumRepository;
import com.web.board.repository.BookRepository;
import com.web.board.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class ItemService {


    private final BookRepository bookRepository;
    private final AlubumRepository alubumRepository;
    private final MovieRepository movieRepository;

    private final S3Uploader s3Uploader;

    private final ItemDsl itemDsl;


    private final ModelMapper modelMapper;


    public void getItemList(Model model, Pageable pageable) {
        model.addAttribute("page", itemDsl.getItemList(pageable));
    }


    /**
     * 상품 저장
     * @param saveItemDTO 상품 저장 DTO
     */
    @Transactional
    public void saveItem(SaveItemDTO saveItemDTO, MultipartFile multipartFile) {


        String imageUrl = null;
        if (!Objects.equals(multipartFile.getOriginalFilename(), ""))
            imageUrl = imageUpLoad(multipartFile);

        saveItemDTO.setImageUrl(imageUrl);
        if (saveItemDTO.getBType().equals(BType.BOOK.getValue())) {
            Book item = modelMapper.map(saveItemDTO, Book.class);
            bookRepository.save(item);
        } else if (saveItemDTO.getBType().equals(BType.ALUBUM.getValue())) {
            Alubum alubum = modelMapper.map(saveItemDTO, Alubum.class);
            alubumRepository.save(alubum);
        } else if (saveItemDTO.getBType().equals(BType.MOVIE.getValue())) {
            Movie movie = modelMapper.map(saveItemDTO, Movie.class);
            movieRepository.save(movie);
        }


    }

    public String imageUpLoad(MultipartFile multipartFile) {
        String uuid = s3Uploader.uploadFileV1(multipartFile);
        log.info("============= uuid ============= : {} ", uuid);
        return uuid;
    }

}
