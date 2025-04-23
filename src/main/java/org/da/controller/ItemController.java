package org.da.controller;

import lombok.RequiredArgsConstructor;
import org.da.dto.Item;
import org.da.dto.Orders;
import org.da.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item-controller")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;
    @PostMapping("/add-item")
    public void addDepartment(@RequestBody Item item){
        service.addItem(item);
    }
    @GetMapping("/get-all")
    public List<Item> getall(){
        return service.getall();
    }
    @DeleteMapping("/delete-item/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id) {
        service.removeItem(id);
        return "Deleted";

    }

}
