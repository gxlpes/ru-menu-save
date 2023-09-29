package com.rudb.controller;

import com.rudb.entity.response.RuMenuDto;
import com.rudb.service.RuMenuService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RuMenuController {

    private final RuMenuService ruMenuService;

    public RuMenuController(RuMenuService ruMenuService) {
        this.ruMenuService = ruMenuService;
    }

    @PostMapping("/menu")
    public RuMenuDto ruMenu(@RequestBody RuMenuDto ruMenuDto) {
        return ruMenuService.saveRuMenu(ruMenuDto);
    }

}