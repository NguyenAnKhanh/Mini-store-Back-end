package com.funnycode.ministore.WorkSheetAPI.repository;

import com.funnycode.ministore.WorkSheetAPI.entity.WorkSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWorkSheetRepository extends JpaRepository<WorkSheet, String> {
}
