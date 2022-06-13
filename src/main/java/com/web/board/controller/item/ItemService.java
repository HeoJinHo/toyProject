package com.web.board.controller.item;

import com.web.board.component.S3Uploader;
import com.web.board.controller.item.dto.SaveItemDTO;
import com.web.board.dsl.ItemDsl;
import com.web.board.entity.Category;
import com.web.board.entity.item.Item;
import com.web.board.entity.item.ItemImage;
import com.web.board.repository.CategoryRepository;
import com.web.board.repository.ItemImageRepository;
import com.web.board.repository.ItemRepository;
import com.web.board.service.BaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ItemService extends BaseService {


    private final CategoryRepository categoryRepository;

    private final ItemRepository itemRepository;

    private ItemImageRepository itemImageRepository;


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
    public void saveItem(SaveItemDTO saveItemDTO, List<MultipartFile> multipartFile) {

        log.info("============= saveItem ==============");
        log.debug("============= saveItemDTO ============= {}", saveItemDTO);
        log.debug("============= multipartFile ============= {}", multipartFile);
        Long memberNo = getMemberNo();


        Category category = categoryRepository.findById(saveItemDTO.getCategoryId()).orElse(null);

        Item item = modelMapper.map(saveItemDTO, Item.class);
        item.setCategory(category);
        item.setRegMemberNo(memberNo);
        Item saveItem = itemRepository.save(item);


        List<ItemImage> imageList = new ArrayList<>();
         if (multipartFile.size() > 0) {
            for (MultipartFile file : multipartFile) {
                String imageUrl = imageUpLoad(file);
                ItemImage itemImage = new ItemImage();
                itemImage.setImageId(null);
                itemImage.setImageUrl(imageUrl);
                itemImage.setItem(saveItem);
                itemImage.setRegMemberNo(memberNo);
                imageList.add(itemImage);
            }
        }

        itemImageRepository.saveAll(imageList);


    }

    public String imageUpLoad(MultipartFile multipartFile) {
        String uuid = s3Uploader.uploadFileV1(multipartFile);
        log.info("============= uuid ============= : {} ", uuid);
        return uuid;
    }

}
