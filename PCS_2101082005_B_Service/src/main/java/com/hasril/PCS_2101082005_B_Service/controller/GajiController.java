/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hasril.PCS_2101082005_B_Service.controller;

import com.hasril.PCS_2101082005_B_Service.Entity.Gaji;
import com.hasril.PCS_2101082005_B_Service.Vo.ResponseTemplateVo;
import com.hasril.PCS_2101082005_B_ServiceService.GajiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author WINDOWS
 */
public class GajiController {
  @Autowired
    private GajiService gajiService;
    
    @PostMapping("/")
    public Gaji saveGaji(@RequestBody Gaji gaji){
        return gajiService.saveGaji(gaji);
    }
    
    @GetMapping("/{id}")
    public ResponseTemplateVo getGaji(@PathVariable("id") Long kodeSlip){
     return (ResponseTemplateVo) gajiService.getGaji(kodeSlip);
    }
    
     @GetMapping("/")
    public List<Gaji> getAllGaji(){
        return gajiService.getAllGaji();
    }
    @DeleteMapping("/{id}")
    public void deleteGaji(@PathVariable("id") Long kodeSlip){
        gajiService.deleteGaji(kodeSlip);
    }
    @PutMapping("/")
    public Gaji updateGaji(@RequestBody Gaji gaji){
        return gajiService.updateGaji(gaji);
    }  
}
