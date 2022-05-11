package com.web.board.controller.item;

import com.web.board.controller.item.dto.SaveItemDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/save")
    public String itemSavePage() {
        return "item/item";
    }



    @PostMapping("/save")
    public String saveItem(SaveItemDTO saveItemDTO) {
        log.info("============= /save =============");
        log.info("============= saveItemDTO ============= : ", saveItemDTO);
        itemService.saveItem(saveItemDTO);
        return "item/item";
    }

}
