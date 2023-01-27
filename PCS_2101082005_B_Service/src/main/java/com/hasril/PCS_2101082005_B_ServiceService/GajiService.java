/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hasril.PCS_2101082005_B_ServiceService;

import com.hasril.PCS_2101082005_B_Service.Entity.Gaji;
import com.hasril.PCS_2101082005_B_Service.Repository.GajiRepository;
import com.hasril.PCS_2101082005_B_Service.Vo.Anggota;
import com.hasril.PCS_2101082005_B_Service.Vo.ResponseTemplateVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;



/**
 *
 * @author WINDOWS
 */
public class GajiService {
      @Autowired
    private GajiRepository gajiRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Gaji saveGaji(Gaji gaji){
        double potongan = 0.001;
        double gajiPokok = 0.0;
        double tunjangan = 0.0;
        double gajiBersih = 0.0;
        if(gaji.getGolongan() == 1){
            gajiPokok = 750000;
            tunjangan = 500000;
        }else if(gaji.getGolongan()==2){
            gajiPokok = 900000;
            tunjangan = 800000;
        }else{
            gajiPokok = 1000000;
            tunjangan = 1000000;
        }
        gaji.setPotongan(potongan);
        gajiBersih = gajiPokok+tunjangan-potongan;
        gaji.setGajiBersih(gajiBersih);
        return gajiRepository.save(gaji);
    }
    
    public ResponseTemplateVo getGaji(Long kodeSlip){
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Gaji gaji = gajiRepository.findBykodeSlip(kodeSlip);
        Anggota anggota = restTemplate.getForObject("http://localhost:8111/anggota/" 
              + gaji.getAnggotaId(), Anggota.class);
        vo.setGaji(gaji);
        vo.setAnggota(anggota);
        return vo;
    }
    public List<Gaji> getAllGaji(){
        return gajiRepository.findAll();
    }
    
    public void deleteGaji(Long kodeSlip){
       gajiRepository.deleteById(kodeSlip);
    }
    
    public Gaji updateGaji(Gaji gaji){
        return gajiRepository.save(gaji);
    }
}
