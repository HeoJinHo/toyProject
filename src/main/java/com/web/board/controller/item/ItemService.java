package com.web.board.controller.item;

import com.web.board.construct.eum.BType;
import com.web.board.controller.item.dto.SaveItemDTO;
import com.web.board.entity.item.Alubum;
import com.web.board.entity.item.Book;
import com.web.board.entity.item.Movie;
import com.web.board.repository.AlubumRepository;
import com.web.board.repository.BookRepository;
import com.web.board.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class ItemService {


    private final BookRepository bookRepository;
    private final AlubumRepository alubumRepository;
    private final MovieRepository movieRepository;

    private final ModelMapper modelMapper;

    /**
     * 상품 저장
     * @param saveItemDTO 상품 저장 DTO
     */
    @Transactional
    public void saveItem(SaveItemDTO saveItemDTO) {


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

}
