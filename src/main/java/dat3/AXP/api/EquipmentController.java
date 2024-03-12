package dat3.AXP.api;

import dat3.AXP.entity.Equipment;
import dat3.AXP.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/equipment")
    public class EquipmentController {


        @Autowired
        EquipmentRepository equipmentRepository;


        @GetMapping("/")
        public String helloAdventureXP() {
            return "Equipment site for AdventureXP";
        }


        @GetMapping("/all-equipment")
        public List<Equipment> getAllEquipment() {
            return equipmentRepository.findAll();
        }

    @PostMapping("/add-equipment")
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }






}

