package dat3.AXP.api;

import dat3.AXP.dto.EquipmentDto;
import dat3.AXP.entity.Equipment;
import dat3.AXP.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/equipment")
    public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //Get all equipment in database
     @GetMapping("")
     public List<Equipment> getAllEquipment() {
            return equipmentService.getAllEquipment();
        }

        //Get equipment based on id
    @GetMapping("/{id}")
    public EquipmentDto getEquipmentById(@PathVariable int id) {
        return equipmentService.getEquipmentById(id);
    }

    //Post equipment to database
    @PostMapping("/add-equipment")
        public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    //Update equipment in database
    @PutMapping("/update-equipment/{id}")
    public Equipment updateEquipment(@PathVariable int id, @RequestBody Equipment equipment) {
        return equipmentService.updateEquipment(id, equipment);
    }

    //Delete equipment in database
    @DeleteMapping("/delete-equipment/{id}")
    public String deleteEquipment(@PathVariable int id) {
        equipmentService.deleteEquipment(id);
        return "Equipment with ID: " + id + " has been deleted";
    }

}

