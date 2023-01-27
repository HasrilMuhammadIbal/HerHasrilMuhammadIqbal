/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hasril.PCS_2101082005_B_Service.Repository;

import com.hasril.PCS_2101082005_B_Service.Entity.Gaji;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author WINDOWS
 */
public interface GajiRepository extends JpaRepository<Gaji, Long>{
    public Gaji findBykodeSlip(Long kodeSlip);
}
