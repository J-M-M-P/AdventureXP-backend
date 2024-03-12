package dat3.AXP.api;

import dat3.AXP.entity.Equipment;
import dat3.AXP.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/equipment")
    public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;


        @GetMapping
        public String helloAdventureXP() {
            return "Equipment site for AdventureXP";
        }


        @GetMapping("/all-equipment")
        public List<Equipment> getAllEquipment() {
            return equipmentService.getAllEquipment();
        }

    @PostMapping("/add-equipment")
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }






}

