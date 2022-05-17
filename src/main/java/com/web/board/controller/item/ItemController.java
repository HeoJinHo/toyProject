package com.web.board.controller.item;

import com.web.board.controller.item.dto.SaveItemDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String itemSavePage() {
        return "item/item";
    }



    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String saveItem(SaveItemDTO saveItemDTO, @RequestParam(value = "images", required = false) List<MultipartFile> multipartFile)  throws IOException {
        log.info("============= /save =============");
        log.info("============= saveItemDTO ============= : {} ", saveItemDTO);
        itemService.saveItem(saveItemDTO, multipartFile);

        return "redirect:/";
    }

}
